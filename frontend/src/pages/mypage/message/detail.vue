<template>
  <c-mypage-layout title="쪽지 보기">
    <div
      v-if="
        messages && messages[0] && messages[0].receiver && messages[0].sender
      "
      class="mypage-message-detail-page"
    >
      <div class="d-flex align-center mypage-message-detail-page__info">
        <div
          @click="$router.go(-1)"
          class="d-flex flex-grow-0 flex-shrink-0 justify-center align-center"
          style="width: 40px; height: 100%; margin-right: 12px; cursor: pointer"
        >
          <v-icon size="28">keyboard_arrow_left</v-icon>
        </div>
        <div
          v-if="messages && messages[0]"
          class="d-flex flex-grow-0 flex-shrink-0 mypage-message-detail-page__profile"
          :style="`background-image:url(${
            me != messages[0].receiver.userCode
              ? messages[0].receiver.userProfile
              : messages[0].sender.userProfile
          })`"
        />
        <div
          v-if="me != messages[0].receiver.userCode"
          class="d-flex mypage-message-detail-page__name"
        >
          {{ messages[0].receiver.userName }}
        </div>
        <div v-else class="d-flex mypage-message-detail-page__name">
          {{ messages[0].sender.userName }}
        </div>
      </div>
      <template v-if="messages != null && messages != 0">
      <div class="d-flex" v-for="(item, mi) in messages" :key="`message-${mi}`">
        <div
          class="d-flex flex-grow-1 flex-shrink-0 mypage-message-detail-page__blank"
          v-if="me != item.receiver.userCode"
        />
        <div class="d-flex flex-column">
          <div class="d-flex mypage-message-detail-page__date">
            <div
              class="d-flex flex-grow-1"
              v-if="me != item.receiver.userCode"
            />
            <div class="d-flex flex-grow-0">
              {{ $moment(item.sendDate).format('YYYY.MM.DD hh:mm') }}
            </div>
            <div class="d-flex flex-grow-1" v-if="me != item.sender.userCode" />
          </div>
          <div
            class="mypage-message-detail-page__message"
            :class="{
              'mypage-message-detail-page__left': me != item.receiver.userCode,
              'mypage-message-detail-page__right': me != item.sender.userCode,
            }"
          >
            {{ item.content }}
          </div>
        </div>
        <div
          class="d-flex flex-grow-1 flex-shrink-0 mypage-message-detail-page__blank"
          v-if="me != item.sender.userCode"
        />
      </div>
      </template>
      <template v-else>
        <c-empty content="주고받은 쪽지" />
      </template>
      <div class="d-flex mypage-message-detail-page__input-container">
        <v-text-field
          class="mypage-message-detail-page__input"
          v-model="input"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
        <c-button
          @click="onMessageButtonClick"
          class="flex-grow-0"
          type="gradient"
          style="height: 48px"
          >쪽지 보내기</c-button
        >
      </div>
    </div>
  </c-mypage-layout>
</template>
<script>
export default {
  name: 'mypage-message-detail-page',
  data: () => ({
    me: 0,
    userId: 1,
    input: '',
    messages: [],
    anotherUser: '',
    message: {
      content: '',
      receiver: '',
    },
  }),
  methods: {
    async onMessageButtonClick() {
      console.log('onMessageButtonClick');
      console.log(this.input);
      if (this.messages[0].receiver.userCode == this.me) {
        this.message.receiver = this.messages[0].sender.userCode;
      } else {
        this.message.receiver = this.messages[0].receiver.userCode;
      }
      console.log(this.message);
      try {
        this.message.content = this.input;
        console.log(this.message);
        console.log(this.$store.state.config);
        await this.$api.sendMessage(this.message, this.$store.state.config);
        alert('쪽지를 전송했습니다.');
        let url = '/mypage/message/' + this.message.receiver;
        location.href = url;
      } catch (e) {
        alert('쪽지 전송에 실패했습니다.');
      }
    },
  },
  async created() {
    console.log(this.$store.state.config);
    try {
      this.anotherUser = this.$route.params.usercode;
      console.log(this.anotherUser);
      this.messages = await this.$api.getUserMessage(
        this.anotherUser,
        this.$store.state.config
      );
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }

    let user = this.$store.state.USER;
    this.me = user.userCode;
    console.log('나다', this.me);
    console.log('메시지다', this.messages);
  },
};
</script>

<style>
.mypage-message-detail-page__input input {
  padding: 0 !important;
}
.mypage-message-detail-page__input .v-input__control {
  height: 48px !important;
}

.mypage-message-detail-page__input .v-text-field__slot {
  height: 48px;
  font-size: 16px;
  color: #8a8a8a !important;
}
.mypage-message-detail-page__input fieldset {
  border-color: #fb8805 !important;
  height: 52px;
}

.mypage-message-detail-page {
}

.mypage-message-detail-page__info {
  height: 74px;
  background: #fff;
  padding: 8px 16px;
  border: solid 1px #eaeaea;
  letter-spacing: -0.38px;
  margin-bottom: 32px;
}

.mypage-message-detail-page__profile {
  width: 36px;
  height: 36px;
  margin-right: 12px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
}

.mypage-message-detail-page__name {
  font-size: 14px;
  font-weight: 800;
  color: #666;
}

.mypage-message-detail-page__date {
  width: 100%;
  /* max-width: 200px; */
  margin-bottom: 4px;
  font-size: 10px;
  color: #999;
}

.mypage-message-detail-page__blank {
  min-width: 55%;
}

.mypage-message-detail-page__message {
  width: auto;
  max-width: 320px;
  padding: 16px 32px;
  border-radius: 4px;
  word-break: break-all;
}

.mypage-message-detail-page__left {
  background: rgba(255, 255, 150, 0.6);
}

.mypage-message-detail-page__right {
  background: rgba(187, 224, 255, 0.6);
}

.mypage-message-detail-page__input-container {
  margin-top: 80px;
}
</style>