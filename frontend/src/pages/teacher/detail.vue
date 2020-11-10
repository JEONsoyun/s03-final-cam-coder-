<template>
  <c-main-layout background="white">
    <div class="teacher-detail-page__container">
      <div class="teacher-detail-page">
        <div class="teacher-detail-page__right">
          <div class="d-flex teacher-detail-page__right-content">
            <div class="d-flex" />
            <div
              class="d-flex flex-column flex-grow-0 flex-shrink-0 teacher-detail-page__right-box"
            >
              <div
                class="d-flex flex-column flex-grow-1 justify-center align-center"
              >
                <div>
                  <span style="color: #fb8805; font-weight: 800">{{
                    SAMPLE_DATA.user.userName
                  }}</span>
                  <span>선생님에게</span>
                </div>
                <div>원하는 수업에 대해 문의해보세요!</div>
              </div>
              <c-button class="flex-grow-0" type="gradient">문의하기</c-button>
            </div>
          </div>
        </div>
        <div class="d-flex teacher-detail-page__box">
          <div
            class="d-flex flex-grow-0 flex-shrink-0 teacher-detail-page__profile"
            :style="`background-image:url(${SAMPLE_DATA.profile})`"
          />
          <div class="d-flex flex-column teacher-detail-page__intro">
            <div class="d-flex">
              <div style="font-weight: 800; font-size: 24px">
                {{ SAMPLE_DATA.user.userName }}
              </div>
              <div class="d-flex" />
              <div @click="onFavoriteClick" style="cursor:pointer">
                <v-icon v-if="isSelected" size="36" color="#fb8805"
                  >favorite</v-icon
                >
                <v-icon v-else size="36" color="#fb8805"
                  >favorite_border</v-icon
                >
              </div>
            </div>
            <div class="d-flex">{{ SAMPLE_DATA.expertise }}</div>
            <div class="d-flex">{{ SAMPLE_DATA.avaliableTime }}</div>
            <div class="d-flex flex-grow-0" style="font-weight: 800">
              <div class="d-flex flex-grow-0 align-center">
                <v-icon color="#ff4a62" style="margin-right: 2px"
                  >favorite</v-icon
                >
                {{ SAMPLE_DATA.likeCnt }}
              </div>
              <div class="d-flex" />
              <div class="d-flex flex-grow-0 align-center">
                <v-icon color="#4e41ff" style="margin-right: 2px"
                  >account_circle</v-icon
                >
                {{ SAMPLE_DATA.studentCnt }}
              </div>
            </div>
          </div>
        </div>
        <div class="teacher-detail-page__content">
          <div style="font-weight: 800; font-size: 18px">선생님 소개</div>
          <div
            class="teacher-detail-page__content-box"
            v-html="SAMPLE_DATA.intro"
          ></div>
        </div>
      </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {
  name: 'teacher-detail-page',
  data: () => ({
    teacherId: 0,
    teacher: {},
    isSelected: false,
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
    onFavoriteClick() {
      this.isSelected = !this.isSelected;
    }
  },
  async created() {
    this.teacherId = this.$route.params.id;
    console.log(this.teacherId);
    if (this.teacherId == 0) {
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }
    console.dir(this.$store.state.config);
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
.teacher-detail-page__container {
  padding: 32px 0;
  width: 1024px;
  margin: 0 auto;
}

.teacher-detail-page {
  width: 700px;
}

.teacher-detail-page__box {
  width: 100%;
  height: 246px;
}

.teacher-detail-page__profile {
  width: 246px;
  height: 100%;
  background-size: cover;
  background-position: center center;
}

.teacher-detail-page__intro {
  padding: 32px;
  border: solid 1px #eaeaea;
}

.teacher-detail-page__right {
  height: 246px;
  width: 100%;
  position: fixed;
  top: 107px;
  left: 0;
  font-size: 16px;
  color: #333;
  font-weight: 600;
  letter-spacing: -0.48px;
}

.teacher-detail-page__right-content {
  width: 1024px;
  height: 100%;
  margin: 0 auto;
}

.teacher-detail-page__right-box {
  padding: 16px;
  width: 300px;
  height: 100%;
  border: solid 1px #eaeaea;
  z-index: 2;
  background: #fff;
}

.teacher-detail-page__content {
  padding-top: 40px;
  letter-spacing: -0.38px;
}

.teacher-detail-page__content-box {
  margin-top: 16px;
  padding: 32px;
  background: rgb(250, 250, 250);
}
</style>
