<template>
  <c-mypage-layout title="쪽지 보기">
    <div class="mypage-message-detail-page">
      <div class="d-flex align-center mypage-message-detail-page__info">
        <div
          @click="$router.go(-1)"
          class="d-flex flex-grow-0 flex-shrink-0 justify-center align-center"
          style="width: 40px; height: 100%; margin-right: 12px; cursor: pointer"
        >
          <v-icon size="28">keyboard_arrow_left</v-icon>
        </div>
        <div
          v-if="SAMPLE_DATA"
          class="d-flex flex-grow-0 flex-shrink-0 mypage-message-detail-page__profile"
          :style="`background-image:url(${SAMPLE_DATA[0].profile})`"
        />
        <div class="d-flex mypage-message-detail-page__name">사용자이름</div>
      </div>
      <div
        class="d-flex"
        v-for="(item, mi) in SAMPLE_DATA"
        :key="`message-${mi}`"
      >
        <div
          class="d-flex flex-grow-1 flex-shrink-0 mypage-message-detail-page__blank"
          v-if="me == item.receiver"
        />
        <div class="d-flex flex-column">
          <div class="d-flex mypage-message-detail-page__date">
            <div class="d-flex" v-if="me == item.receiver" />
            {{ $moment(item.sendDate).format('YYYY.MM.DD hh:mm') }}
            <div class="d-flex" v-if="me == item.sender" />
          </div>
          <div
            class="mypage-message-detail-page__message"
            :class="{
              'mypage-message-detail-page__left': me == item.receiver,
              'mypage-message-detail-page__right': me == item.sender,
            }"
          >
            {{ item.content }}
          </div>
        </div>
        <div
          class="d-flex flex-grow-1 flex-shrink-0 mypage-message-detail-page__blank mypage-message-detail-page__blank"
          v-if="me == item.sender"
        />
      </div>
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
        <c-button @click="onMessageButtonClick" class="flex-grow-0" type="gradient" style="height:48px"
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
    me: 15,
    userId: 1,
    input: '',
    messages: [],
    anotherUser: '',
    SAMPLE_DATA: [
      {
        messageCode: 12,
        sendDate: '2020-10-28T05:45:02.000+00:00',
        content: 'byebye',
        sender: 15,
        profile: '/static/images/user.png',
        receiver: 14,
        isRead: 0,
      },
      {
        messageCode: 11,
        sendDate: '2020-10-28T05:00:29.000+00:00',
        content: 'oh, hi',
        sender: 14,
        receiver: 15,
        isRead: 0,
      },
      {
        messageCode: 10,
        sendDate: '2020-10-28T04:59:59.000+00:00',
        content:
          'hihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihi',
        sender: 15,
        receiver: 14,
        isRead: 0,
      },
    ],
  }),
  methods: {
    onMessageButtonClick() {
      this.$router.push(`/teacher/send-message/${this.userId}`);
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
  max-width: 200px;
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