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
                    teacher.user.userName
                  }}</span>
                  <span>선생님에게</span>
                </div>
                <div>원하는 수업에 대해 문의해보세요!</div>
              </div>
              <c-button
                @click="onMessageClick"
                class="flex-grow-0"
                type="gradient"
                >문의하기</c-button
              >
            </div>
          </div>
        </div>
        <div class="d-flex teacher-detail-page__box">
          <div
            class="d-flex flex-grow-0 flex-shrink-0 teacher-detail-page__profile"
            :style="`background-image:url(${teacher.profile})`"
          />
          <div class="d-flex flex-column teacher-detail-page__intro">
            <div class="d-flex">
              <div style="font-weight: 800; font-size: 24px">
                {{ teacher.user.userName }}
              </div>
              <div class="d-flex" />
              <div @click="onFavoriteClick" style="cursor: pointer">
                <v-icon v-if="isSelected" size="36" color="#fb8805"
                  >favorite</v-icon
                >
                <v-icon v-else size="36" color="#fb8805"
                  >favorite_border</v-icon
                >
              </div>
            </div>
            <div class="d-flex">{{ teacher.expertise }}</div>
            <div class="d-flex">{{ teacher.avaliableTime }}</div>
            <div class="d-flex flex-grow-0" style="font-weight: 800">
              <div class="d-flex flex-grow-0 align-center">
                <v-icon color="#ff4a62" style="margin-right: 2px"
                  >favorite</v-icon
                >
                {{ teacher.likeCnt }}
              </div>
              <div class="d-flex" />
              <div class="d-flex flex-grow-0 align-center">
                <v-icon color="#4e41ff" style="margin-right: 2px"
                  >account_circle</v-icon
                >
                {{ teacher.studentCnt }}
              </div>
            </div>
          </div>
        </div>
        <div class="teacher-detail-page__content">
          <div style="font-weight: 800; font-size: 18px">선생님 소개</div>
          <div
            class="teacher-detail-page__content-box"
            v-html="teacher.intro"
          ></div>
          <div style="font-weight: 800; font-size: 18px; margin: 40px 0 20px 0">
            선생님 리뷰
          </div>
          <div
            class="teacher-detail-page__review"
            v-for="(item, ri) in SAMPLE_DATA2"
            :key="`review-${ri}`"
          >
            <div class="d-flex align-center">
              <div
                v-if="teacher"
                class="d-flex flex-grow-0 flex-shrink-0 teacher-detail-page__review-profile"
                :style="`background-image:url(${item.student.userProfile})`"
              />
              <div style="font-weight: 800; font-size: 18px">
                {{ item.student.userId }}
              </div>
              <div class="d-flex" />
              <div style="color: #666; font-size: 14px">
                {{ $moment(item.evaluationDate).format('YYYY.MM.DD hh:mm') }}
              </div>
            </div>
            <div class="teacher-detail-page__review-text">
              {{ item.evaluationContent }}
            </div>
          </div>
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
    SAMPLE_DATA2: [
      {
        reviewCode: 6,
        tutoringCode: 7,
        evaluationContent:
          '이해하기 쉬운 예시를 많이 들어주십니다.이해하기 쉬운 예시를 많이 들어주십니다.이해하기 쉬운 예시를 많이 들어주십니다.이해하기 쉬운 예시를 많이 들어주십니다.이해하기 쉬운 예시를 많이 들어주십니다.이해하기 쉬운 예시를 많이 들어주십니다.이해하기 쉬운 예시를 많이 들어주십니다.',
        evaluationDate: '2020-11-02T06:57:48.000+00:00',
        student: {
          id: 1,
          userCode: 16,
          userId: 'studenta',
          userPw:
            '$2a$10$q4esBwQfUamOVv4kFCkSiuXdBCEAJeNWwzpFRUJ/o39x828XeUxEG',
          userName: 'namea',
          userProfile: '/static/images/user.png',
          joinDate: '2020-10-29T01:07:45.000+00:00',
        },
        teacher: {
          id: 2,
          teacherCode: 1,
          user: {
            id: 3,
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
          profile: null,
          likeCnt: 1,
          avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
          studentCnt: 1,
        },
      },
      {
        reviewCode: 6,
        tutoringCode: 7,
        evaluationContent: '이해하기 쉬운 예시를 많이 들어주십니다.',
        evaluationDate: '2020-11-02T06:57:48.000+00:00',
        student: {
          id: 1,
          userCode: 16,
          userId: 'studenta',
          userPw:
            '$2a$10$q4esBwQfUamOVv4kFCkSiuXdBCEAJeNWwzpFRUJ/o39x828XeUxEG',
          userName: 'namea',
          userProfile: '/static/images/user.png',
          joinDate: '2020-10-29T01:07:45.000+00:00',
        },
        teacher: {
          id: 2,
          teacherCode: 1,
          user: {
            id: 3,
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
          profile: null,
          likeCnt: 1,
          avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
          studentCnt: 1,
        },
      },
      {
        reviewCode: 6,
        tutoringCode: 7,
        evaluationContent: '이해하기 쉬운 예시를 많이 들어주십니다.',
        evaluationDate: '2020-11-02T06:57:48.000+00:00',
        student: {
          id: 1,
          userCode: 16,
          userId: 'studenta',
          userPw:
            '$2a$10$q4esBwQfUamOVv4kFCkSiuXdBCEAJeNWwzpFRUJ/o39x828XeUxEG',
          userName: 'namea',
          userProfile: '/static/images/user.png',
          joinDate: '2020-10-29T01:07:45.000+00:00',
        },
        teacher: {
          id: 2,
          teacherCode: 1,
          user: {
            id: 3,
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
          profile: null,
          likeCnt: 1,
          avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
          studentCnt: 1,
        },
      },
    ],
  }),
  methods: {
    onFavoriteClick() {
      this.isSelected = !this.isSelected;
    },
    onMessageClick() {
      this.$router.push(`/teacher/send-message/${this.teacherId}`);
    },
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

.teacher-detail-page__review {
  margin-bottom: 16px;
  padding: 32px;
  letter-spacing: -0.48px;
  border-radius: 10px;
  background: #fff1e2;
}

.teacher-detail-page__review-profile {
  width: 36px;
  height: 36px;
  margin-right: 12px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
  border: solid 1px #ccc;
}

.teacher-detail-page__review-text {
  margin-top: 12px;
  padding: 0 47px;
}
</style>
