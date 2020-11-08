<template>
  <div class="d-flex flex-column" style="width: 100%; height: 100%">
    <div class="d-flex">
      <div class="d-flex flex-column room-page__camera">
        <video width="200" id="remote-video" autoplay />
        <div class="d-flex" />
        <video width="200" id="local-video" autoplay />
      </div>
      <div class="d-flex room-page__contents-share">
        <video width="100%" id="screen-video" autoplay></video>
      </div>
      <div
        class="d-flex flex-column flex-grow-1 flex-shrink-0"
        style="min-width: 500px"
      >
        <div class="d-flex flex-grow-1 flex-column room-page__code-editor">
          <div class="d-flex flex-grow-0">
            <div class="d-flex" />
            <div>언어</div>
          </div>
          <div class="d-flex">editor</div>
          <div class="d-flex flex-grow-0">
            <div class="d-flex" />
            <c-button class="flex-grow-0">run</c-button>
          </div>
        </div>
        <div class="d-flex flex-grow-1 room-page__console"></div>
      </div>
    </div>
    <div
      class="d-flex flex-grow-0 align-center justify-center room-page__footer"
    >
      <c-button id="btn-start" v-if="!isShared" class="flex-grow-0"
        >콘텐츠 공유</c-button
      >
      <div class="d-flex" />
      <div
        id="btn-camera"
        class="d-flex justify-center align-center flex-grow-0 room-page__circle"
      >
        <v-icon v-if="isPaused" color="white" size="28"> videocam_off</v-icon>
        <v-icon v-if="!isPaused" color="white" size="28"> videocam</v-icon>
      </div>
      <div
        id="btn-mic"
        class="d-flex justify-center align-center flex-grow-0 room-page__circle"
      >
        <v-icon v-if="isMuted" color="white" size="28">mic_off</v-icon>
        <v-icon v-if="!isMuted" color="white" size="28">mic</v-icon>
      </div>
      <div class="d-flex" />
      <div
        @click="onCloseClick"
        class="d-flex justify-center align-center flex-grow-0 room-page__circle"
      >
        <v-icon color="white" size="28">close</v-icon>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'room-page',
  data: () => ({
    isMuted: true,
    isPaused: true,
    webRTC: {},
    isShared: false,
  }),
  methods: {
    onCloseClick() {
      window.close();
    },
  },
  mounted() {
    this.webRTC = initMedia(this);
    this.webRTC.peerHandler.getUserMedia(
      this.webRTC.mediaOption,
      this.webRTC.onLocalStream
    );
    initScreenShare(this);
  },
};

function initMedia(vue) {
  console.log('Loaded Main');

  let roomId;
  let userId;
  let remoteUserId;
  let isOffer;

  const socket = io(location.hostname + ':3001');
  const mediaHandler = new MediaHandler();
  const peerHandler = new PeerHandler({
    send: send,
  });
  const animationTime = 500;
  const isSafari = DetectRTC.browser.isSafari;
  const isMobile = DetectRTC.isMobileDevice;
  const mediaOption = {
    audio: true,
    video: {
      mandatory: {
        maxWidth: 1920,
        maxHeight: 1080,
        maxFrameRate: 30,
      },
      optional: [
        { googNoiseReduction: true }, // Likely removes the noise in the captured video stream at the expense of computational effort.
        { facingMode: 'user' }, // Select the front/user facing camera or the rear/environment facing camera if available (on Phone)
      ],
    },
  };

  // DOM
  const $body = $('body');
  const $createWrap = $('#create-wrap');
  const $waitWrap = $('#wait-wrap');
  const $videoWrap = $('#video-wrap');
  const $uniqueToken = $('#unique-token');

  /**
   * 입장 후 다른 참여자 발견시 호출
   */
  function onDetectUser() {
    console.log('onDetectUser');

    // $waitWrap.html(
    //   [
    //     '<div class="room-info">',
    //     '<p>당신을 기다리고 있어요. 참여 하실래요?</p>',
    //     '<button id="btn-join">Join</button>',
    //     '</div>',
    //   ].join('\n')
    // );

    isOffer = true;
    peerHandler.getUserMedia(mediaOption, onLocalStream, isOffer);
    $(this).attr('disabled', true);

    $createWrap.slideUp(animationTime);
  }

  /**
   * 참석자 핸들링
   * @param roomId
   * @param userList
   */
  function onJoin(roomId, userList) {
    console.log('onJoin', userList);

    if (Object.keys(userList).length > 1) {
      onDetectUser();
    }
  }

  /**
   * 이탈자 핸들링
   * @param userId
   */
  function onLeave(userId) {
    console.log('onLeave', arguments);

    if (remoteUserId === userId) {
      $('#remote-video').remove();
      $body.removeClass('connected').addClass('wait');
      remoteUserId = null;
    }
  }

  /**
   * 소켓 메세지 핸들링
   * @param data
   */
  function onMessage(data) {
    console.log('onMessage', arguments);

    if (!remoteUserId) {
      remoteUserId = data.sender;
    }

    if (data.sdp || data.candidate) {
      peerHandler.signaling(data);
    } else {
      // etc
    }
  }

  /**
   * 소켓 메시지 전송
   * @param data
   */
  function send(data) {
    console.log('send', arguments);

    data.roomId = roomId;
    data.sender = userId;
    socket.send(data);
  }

  /**
   * 방 고유 접속 토큰 생성
   */
  function setRoomToken() {
    const hashValue = (Math.random() * new Date().getTime())
      .toString(32)
      .toUpperCase()
      .replace(/\./g, '-');

    if (location.hash.length > 2) {
      $uniqueToken.attr('href', location.href);
    } else {
      location.hash = '#' + hashValue;
    }
  }

  /**
   * 클립보드 복사
   */
  function setClipboard() {
    $uniqueToken.click(function () {
      const link = location.href;

      if (window.clipboardData) {
        window.clipboardData.setData('text', link);
        alert('Copy to Clipboard successful.');
      } else {
        window.prompt('Copy to clipboard: Ctrl+C, Enter', link); // Copy to clipboard: Ctrl+C, Enter
      }
    });
  }

  /**
   * 로컬 스트림 핸들링
   * @param stream
   */
  function onLocalStream(stream) {
    // $videoWrap.prepend('<video width="200" id="local-video" autoplay />');
    const localVideo = document.querySelector('#local-video');
    mediaHandler.setVideoStream({
      type: 'local',
      el: localVideo,
      stream: stream,
    });
    stream.getVideoTracks()[0].enabled = false;

    $body.addClass('room wait');

    if (isMobile && isSafari) {
      mediaHandler.playForIOS(localVideo);
    }
  }

  /**
   * 상대방 스트림 핸들링
   * @param stream
   */
  function onRemoteStream(stream) {
    console.log('onRemoteStream', stream);

    // $videoWrap.prepend('<video width="200" id="remote-video" autoplay />');
    const remoteVideo = document.querySelector('#remote-video');
    mediaHandler.setVideoStream({
      type: 'remote',
      el: remoteVideo,
      stream: stream,
    });

    $body.removeClass('wait').addClass('connected');

    if (isMobile && isSafari) {
      mediaHandler.playForIOS(remoteVideo);
    }
  }

  function onScreenInfoReceived(mediaInfo) {
      console.log('onScreenInfoReceived');
  }

  function onScreenEnded() {
      // TODO 종료
      console.log('onScreenEnded');
  }

  /**
   * 초기 설정
   */
  function initialize() {
    roomId = location.href.replace(/\/|:|#|%|\.|\[|\]/g, '');
    userId = Math.round(Math.random() * 99999);
    setRoomToken();
    setClipboard();

    // 소켓 관련 이벤트 바인딩
    socket.emit('enter', roomId, userId);
    socket.on('join', onJoin);
    socket.on('leave', onLeave);
    socket.on('message', onMessage);
    socket.on('screen.info', onScreenInfoReceived);
    socket.on('screen.end', onScreenEnded);

    // Peer 관련 이벤트 바인딩
    peerHandler.on('addRemoteStream', onRemoteStream);

    $('#btn-start').click(function () {
      peerHandler.getUserMedia(mediaOption, onLocalStream);
    });

    $('#btn-camera').click(function () {
      vue.isPaused = !vue.isPaused;
      mediaHandler[vue.isPaused ? 'pauseVideo' : 'resumeVideo']();
    });

    $('#btn-mic').click(function () {
      vue.isMuted = !vue.isMuted;
      mediaHandler[vue.isMuted ? 'muteAudio' : 'unmuteAudio']();
    });
  }

  initialize();
  return { peerHandler, mediaOption, onLocalStream, mediaHandler };
}

/*!
 *
 * WebRTC Lab
 * @author dodortus (dodortus@gmail.com / codejs.co.kr)
 *
 */
function initScreenShare(vue) {
  console.log('Loaded Main');

  const screenHandler = new ScreenHandler();

  /**
   * 비디오 엘리먼트에 재생을 위해 stream 바인딩
   * @param data
   */
  function setVideoStream(data) {
    const video = data.el;
    video.srcObject = data.stream;
  }

  /**
   * 로컬 스트림 핸들링
   * @param stream
   */
  function onLocalStream(stream) {
    console.log('onLocalStream', stream);

    setVideoStream({
      el: document.querySelector('#screen-video'),
      stream: stream,
    });
  }

  /**
   * screenHandler를 통해 캡쳐 API를 호출합니다.
   */
  function startScreenShare() {
    screenHandler.start((stream) => {
      onLocalStream(stream);
    });
  }

  /**
   * DOM 이벤트 바인딩
   */
  function bindEvent() {
    document.querySelector('#btn-start').onclick = startScreenShare;
  }

  /**
   * 초기화
   */
  function initialize() {
    bindEvent();
  }

  initialize();
}
</script>

<style>
.room-page__camera {
  background: #fff;
  width: 200px;
}

.room-page__contents-share {
  background: #eaeaea;
}

.room-page__code-editor {
  width: 100%;
  background: rgb(49, 35, 29);
  height: 70%;
  padding: 16px;
  color: white;
  border-bottom: solid 1px #fff;
}

.room-page__console {
  width: 100%;
  background: rgb(49, 35, 29);
  height: 30%;
  padding: 16px;
}

.room-page__footer {
  background: #eaeaea;
  height: 70px;
  padding: 0 32px;
  border-top: solid 1px rgb(49, 35, 29);
}

.room-page__circle {
  width: 45px;
  height: 45px;
  border-radius: 50%;
  background: rgb(231, 0, 39);
  cursor: pointer;
  margin-left: 16px;
}
</style>