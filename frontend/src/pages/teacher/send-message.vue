<template>
  <c-main-layout>
    <div class="send-message-page">
      <div class="d-flex align-center send-message-page__info">
        <div
          @click="$router.go(-1)"
          class="d-flex flex-grow-0 flex-shrink-0 justify-center align-center"
          style="width: 40px; height: 100%; margin-right: 12px; cursor: pointer"
        >
          <v-icon size="28">keyboard_arrow_left</v-icon>
        </div>
        <div
          class="d-flex flex-grow-0 flex-shrink-0 send-message-page__profile"
          :style="`background-image:url(${teacher.profile})`"
        />
        <div class="d-flex flex-column ellipsis">
          <div class="send-message-page__name">
            {{ teacher.user.userName }}
          </div>
          <div
            class="send-message-page__intro ellipsis"
            style="height: 24px"
            v-html="teacher.intro"
          />
        </div>
      </div>
      <div class="send-message-page__textarea-container">
        <textarea
          placeholder="문의할 내용을 입력해주세요."
          style="width: 100%; height: 300px"
          v-model="message.content"
        />
      </div>
      <c-button @click="onSendClick" type="gradient">문의하기 </c-button>
    </div>
  </c-main-layout>
</template>
<script>
export default {
  name: 'send-message-page',
  data: () => ({
    teacherId: 0,
    teacher: {},
    message: {
      content: '',
      receiver: '',
    },
  }),
  methods: {
    async onSendClick() {
      try {
        this.message.receiver = this.teacher.user.userCode;
        console.log(this.message);
        console.log(this.$store.state.config);
        await this.$api.sendMessage(this.message, this.$store.state.config);
        alert('쪽지를 전송했습니다.');
        console.log(this.teacher.user.userCode);
        let url = '/mypage/message/' + this.teacher.user.userCode;
        location.href = url;
      } catch (e) {
        alert('쪽지 전송에 실패했습니다.');
        console.error(e);
      }
    },
  },
  async created() {
    this.teacherId = this.$route.params.userid;
    console.log(this.teacherId);
    if (this.teacherId == 0) {
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }
    try {
      this.teacher = await this.$api.getTeacher(
        this.teacherId,
        this.$store.state.config
      );
    } catch (e) {
      console.log('선생님 로딩 실패');
    }
  },
};
</script>
<style>
.send-message-page {
  padding-top: 40px;
  width: 480px;
  margin: 0 auto;
}

.send-message-page__info {
  height: 74px;
  background: #fff;
  padding: 8px 16px;
  border: solid 1px #eaeaea;
  letter-spacing: -0.38px;
}

.send-message-page__profile {
  width: 36px;
  height: 36px;
  margin-right: 12px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
}

.send-message-page__name {
  font-size: 14px;
  font-weight: 800;
  color: #666;
}

.send-message-page__intro {
  margin-top: 2px;
  font-weight: 400;
  font-size: 12px;
  color: #999;
  line-height: 12px;
}

.send-message-page__textarea-container {
  width: 100%;
  padding: 16px;
  padding-bottom: 2px;
  margin-bottom: -4px;
  border-left: solid 1px #eaeaea;
  border-right: solid 1px #eaeaea;
  font-size: 14px;
  background: #fff;
}
</style>