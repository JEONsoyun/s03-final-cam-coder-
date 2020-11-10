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
          :style="`background-image:url(${SAMPLE_DATA.profile})`"
        />
        <div class="d-flex flex-column ellipsis">
          <div class="send-message-page__name">
            {{ SAMPLE_DATA.user.userName }}
          </div>
          <div
            class="send-message-page__intro ellipsis"
            style="height: 24px"
            v-html="SAMPLE_DATA.intro"
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
      <c-button @click="onSendClick" type="gradient"> 문의하기 </c-button>
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
    SAMPLE_DATA: {
      teacherCode: 1,
      user: {
        userCode: 3,
        userId: 'teacher0',
        userPw: '1234',
        userName: '야근이싫은개발자',
        userProfile: null,
        joinDate: '2020-10-27T01:46:43.000+00:00',
      },
      intro:
        '안녕하세요.<br> 저는 위메프에서 웹개발자로 일하고 있는 야근이 싫은 개발자입니다. <br>자바를 처음 접하는\n 분들에게 적합한 커리큘럼입니다. 마지막에는 프로젝트를 완성시켜서 포트폴리오를 하나 만드는 것이 목표입니다. 과외생 분이 배우시는 속도에 따라 커리큘럼은 조금씩 변동될 수 있습니다.<br>현업에서 웹 디자이너와 가장 가깝게 일하는 실무자로서 더 실용적이고 실무에서 필요하는 것들 위주로 가르쳐드리겠습니다.',
      expertise:
        'Javascript, Swift, Objective-C, C++, SQL, Java, 프로그래밍 과목을 수업합니다.',
      price: 20000,
      profile: '/static/images/user.png',
      likeCnt: 2,
      avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
      studentCnt: 3,
    },
  }),
  methods: {
    async onSendClick() {
      try {
        console.log(this.message);
        console.log(this.$store.state.config);
        await this.$api.sendMessage(this.message, this.$store.state.config);
        alert('메시지 전송 성공');
      } catch (e) {
        alert('메시지 전송 실패.');
      }
    },
  },
  async created() {
    console.log(this.$store.storagelocal);
    this.teacherId = this.$route.params.userid;
    console.log(this.teacherId);
    if (this.teacherId == 0) {
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }
    console.dir(this.$store.state.config);
    try {
      console.log(this.teacherId);
      console.dir(this.$store.state.config);
      this.teacher = await this.$api.getTeacher(
        this.teacherId,
        this.$store.state.config
      );
      this.message.receiver = this.teacher.user.userCode;
      console.log(this.teacher.user.userCode);
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