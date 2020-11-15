<template>
  <div class="d-flex flex-column room-page">
    <!-- 상단 카메라/에디터 -->
    <div class="d-flex">
      <div class="d-flex flex-column room-page__camera">
        <video
          width="199"
          id="remote-video"
          autoplay
          style="
            background-image: url('/static/images/user.png');
            background-position: center;
            background-size: 150px;
            border-bottom: solid 1px #fff;
            height: 150px;
          "
        />
        <div>상대방 화면</div>
        <div class="d-flex" />
        <div>내 화면</div>
        <video
          width="199"
          id="local-video"
          autoplay
          style="
            background-image: url('/static/images/user.png');
            background-position: center;
            background-size: 150px;
            border-top: solid 1px #fff;
            height: 150px;
          "
        />
      </div>
      <div class="d-flex flex-column flex-grow-0 room-page__contents-share">
        <div class="d-flex align-center justify-center">내가 공유한 화면</div>
        <video
          width="100%"
          id="screen-local-video"
          autoplay
          style="border-bottom: solid 1px #fff; max-height: 40vh"
        ></video>
        <video
          width="100%"
          id="screen-remote-video"
          style="max-height: 40vh"
          autoplay
        ></video>
        <div class="d-flex align-center justify-center">
          상대방이 공유한 화면
        </div>
      </div>
      <div
        class="d-flex flex-column flex-grow-1 flex-shrink-0"
        style="min-width: 40%"
      >
        <div class="d-flex flex-grow-1 flex-column room-page__code-editor">
          <div class="d-flex flex-grow-0 align-center">
            <div class="d-flex" />
            언어
            <select
              v-model="language"
              style="
                margin-left: 8px;
                background: white;
                margin-right: 16px;
                height: 40px;
                padding: 8px;
                border-radius: 4px;
                border: solid 1px #fb8805;
                font-size: 14px;
                font-weight: 800;
              "
            >
              <option value="c">C</option>
              <option value="cpp">C++</option>
              <option value="java">Java</option>
              <option value="python">Python 3.7</option>
            </select>
          </div>
          <div class="d-flex" style="padding-top: 4px">
            <div id="monaco" style="height: 100%; width: 100%"></div>
          </div>

          <div class="d-flex flex-grow-0">
            <div class="d-flex" />
            <c-button
              class="flex-grow-0"
              style="margin-right: 16px"
              @click="executeBuild"
              >run</c-button
            >
          </div>
        </div>
        <div class="d-flex flex-grow-1 room-page__console">
          <textarea
            ref="output"
            style="resize: none; width: 400px; height: 50px; overflow: visible"
            readonly="readonly"
          ></textarea>
        </div>
      </div>
    </div>

    <!-- 하단바 부분 -->
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
import * as monaco from 'monaco-editor';
import ReconnectingWebSocket from 'reconnecting-websocket';
import sharedb from 'sharedb/lib/client';
import richText from 'rich-text';
import Quill from 'quill';

const BASE_CODE = {
  c: `#include <stdio.h>
int main() {
  printf("Hello, world!");
  return 0;
}`,
  java: `class Main {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}`,
  cpp: `#include <iostream>
using namespace std;

int main() {
  cout << "Hello, world!" << endl;
  return 0;
}`,
  python: `print("Hello, world!")`,
};

export default {
  name: 'room-page',
  data: () => ({
    isMuted: true,
    isPaused: true,
    webRTC: {},
    displayRTC: {},
    isShared: false,
    tutoringCode: null,
    editor: null,
    language: 'c',
    editorValueChangedByRemote: false,
  }),
  watch: {
    language() {
      const model = monaco.editor.createModel('', this.language);
      this.editor.setModel(model);
      this.editor.setValue(BASE_CODE[this.language]);
    },
  },
  methods: {
    initRoomToken() {
      const hash = this.tutoringCode
        .toString(32)
        .toUpperCase()
        .replace(/\./g, '-');

      this.$router.push({
        path: this.$route.pash,
        hash,
      });
    },
    onCloseClick() {
      if (confirm('수업에서 나가시겠습니까?')) {
        location.href = `/review/${this.tutoringCode}`;
      }
    },
    executeBuild() {
      const url = 'cbuild';
      const code = this.editor.getValue();
      const lang = this.language;
      const data = JSON.stringify({ code, lang });
      const xhr = new XMLHttpRequest();
      xhr.open('POST', url, true);
      xhr.setRequestHeader('Content-type', 'application/json');
      xhr.send(data);
      xhr.addEventListener('load', () => {
        const result = JSON.parse(xhr.responseText);
        this.$refs.output.value = result.output;
      });
    },
    initEditor() {
      this.editor = monaco.editor.create(document.getElementById('monaco'), {
        theme: 'vs-dark',
        fontFamily: 'Nanum Gothic Coding',
        automaticLayout: true,
        language: this.language,
        value: BASE_CODE[this.language],
      });
    },
    initRealtimeCodeSharing() {
      sharedb.types.register(richText.type);

      // Open WebSocket connection to ShareDB server
      var socket = new ReconnectingWebSocket(
        'wss://' + window.location.hostname + '/realtime'
      );
      var connection = new sharedb.Connection(socket);
      console.log(connection, '1234');

      // For testing reconnection
      window.disconnect = function () {
        connection.close();
      };
      window.connect = function () {
        var socket = new ReconnectingWebSocket(
          'wss://' + window.location.hostname + '/realtime'
        );
        connection.bindToSocket(socket);
      };

      // Create local Doc instance mapped to 'examples' collection document with id 'richtext'
      var doc = connection.get('examples', 'richtext');
      doc.on('error', (err) => {
        /* Ignore replay error. */
      });
      doc.subscribe((err) => {
        if (err) throw err;

        this.editor.onDidChangeModelContent((e) => {
          if (this.editorValueChangedByRemote) {
            this.editorValueChangedByRemote = false;
            return;
          }
          const content = this.editor.getValue();
          doc.submitOp(
            {
              ops: [
                {
                  sr: content,
                },
              ],
            },
            { source: this }
          );
        });

        doc.on('op', ({ ops }, source) => {
          if (source === this) {
            return;
          }
          this.editorValueChangedByRemote = true;
          this.editor.setValue(ops[0].sr);
        });
      });
    },
  },
  mounted() {
    this.tutoringCode = this.$route.query.tutoringCode;
    if (this.$route.fullPath == '/room') {
      alert('잘못 된 접근입니다.');
      this.$router.push('/');
    }
    // 에디터 초기화
    this.initEditor();
    this.initRealtimeCodeSharing();

    // 방 초기화
    if (!this.$route.hash) {
      this.initRoomToken();
    }

    // 사용자 공유
    this.webRTC = new initMedia(this, {
      namespace: '/userMedia',
      localVideoId: 'local-video',
      remoteVideoId: 'remote-video',
      videoEnabledOnStart: false,
    });

    this.webRTC.peerHandler.getUserMedia(
      this.webRTC.mediaOption,
      this.webRTC.onLocalStream
    );

    $('#btn-camera').click(() => {
      this.isPaused = !this.isPaused;
      this.webRTC.mediaHandler[this.isPaused ? 'pauseVideo' : 'resumeVideo']();
    });

    $('#btn-mic').click(() => {
      this.isMuted = !this.isMuted;
      console.log(this.isMuted);
      this.webRTC.mediaHandler[this.isMuted ? 'muteAudio' : 'unmuteAudio']();
    });

    // 스크린 공유
    this.displayRTC = new initMedia(this, {
      type: 'displayMedia',
      namespace: '/displayMedia',
      localVideoId: 'screen-local-video',
      remoteVideoId: 'screen-remote-video',
      videoEnabledOnStart: true,
    });

    document.querySelector('#btn-start').onclick = () => {
      this.displayRTC.peerHandler.getUserMedia(
        null,
        this.displayRTC.onLocalStream,
        true
      );
    };
  },
};

function initMedia(vue, options) {
  console.log('Loaded Main');

  let roomId;
  let userId;
  let remoteUserId;
  let isOffer;

  const socket = io('k3a110.p.ssafy.io' + options.namespace);
  const mediaHandler = new MediaHandler();
  const peerHandler = new PeerHandler(
    Object.assign(
      {
        send: send,
      },
      options
    )
  );
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
    if (options.type != 'displayMedia') {
      peerHandler.getUserMedia(mediaOption, onLocalStream, isOffer);
    } else {
      peerHandler.resetLocalConnection();
    }
    $(this).attr('disabled', true);
    // $createWrap.slideUp(animationTime);
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
    peerHandler.resetLocalConnection();

    if (remoteUserId === userId) {
      $(options.remoteVideoId).remove();
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
    const localVideo = document.getElementById(options.localVideoId);
    console.log('onLocalStream', stream, options.localVideoId);
    mediaHandler.setVideoStream({
      type: 'local',
      el: localVideo,
      stream: stream,
    });
    stream.getVideoTracks()[0].enabled = options.videoEnabledOnStart;

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
    const remoteVideo = document.getElementById(options.remoteVideoId);
    mediaHandler.setVideoStream({
      type: 'remote',
      el: remoteVideo,
      stream: stream,
    });

    // $body.removeClass('wait').addClass('connected');

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
    roomId = vue.$route.hash;
    userId = Date.now() + Math.round(Math.random() * 99999);
    // setRoomToken();
    // setClipboard();

    // 소켓 관련 이벤트 바인딩
    socket.emit('enter', roomId, userId);
    socket.on('join', onJoin);
    socket.on('leave', onLeave);
    socket.on('message', onMessage);
    // socket.on('screen.info', onScreenInfoReceived);
    // socket.on('screen.end', onScreenEnded);

    // Peer 관련 이벤트 바인딩
    peerHandler.on('addRemoteStream', onRemoteStream);
  }

  initialize();
  return { peerHandler, mediaOption, onLocalStream, mediaHandler };
}
</script>

<style>
.room-page {
  height: 100vh;
  width: 100vw;
  background: rgb(30, 30, 30);
  color: #fff;
}
.room-page__camera {
  width: 200px;
  margin-right: 2px;
  border-right: solid 1px #fff;
  text-align: center;
}

.room-page__contents-share {
  height: 100%;
  min-width: 40%;
  border-right: solid 1px #fff;
  text-align: center;
}

.room-page__code-editor {
  width: 100%;
  height: 80%;
  padding: 16px 0;
  border-bottom: solid 1px #fff;
}

.room-page__console {
  width: 100%;
  height: 20%;
  padding: 16px;
}

.room-page__footer {
  height: 65px;
  padding: 0 32px;
  border-top: solid 1px#fff;
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
