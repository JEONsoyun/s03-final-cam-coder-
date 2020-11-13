<template>
  <c-mypage-layout title="관심 선생님 목록">
    <div class="d-flex mypage-student-like-page__content">
      <div
        v-for="(item, ti) in SAMPLE_DATA"
        :key="`teacher-${ti}`"
        class="d-flex flex-column mypage-student-like-page__item-container"
      >
        <div class="d-flex flex-column mypage-student-like-page__item">
          <div
            class="d-flex flex-shrink-0 mypage-student-like-page__profile-image"
          >
            {{ item.userProfile }}
          </div>
          <div
            class="d-flex flex-column mypage-student-like-page__item-content"
          >
            <div style="font-weight: 800">userName {{ item.userName }}</div>
            <div class="d-flex flex-grow-1 flex-column">
              <div class="ellipsis">{{ item.expertise }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-student-like-page',
  data: () => ({
    user: {},
    likes: [],
    SAMPLE_DATA: [
      {
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
        profile: null,
        likeCnt: 2,
        avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
        studentCnt: 3,
      },
      {
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
        profile: null,
        likeCnt: 2,
        avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
        studentCnt: 3,
      },
      {
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
        profile: null,
        likeCnt: 2,
        avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
        studentCnt: 3,
      },
      {
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
        profile: null,
        likeCnt: 2,
        avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
        studentCnt: 3,
      },
      {
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
        profile: null,
        likeCnt: 2,
        avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
        studentCnt: 3,
      },
      {
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
        profile: null,
        likeCnt: 2,
        avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
        studentCnt: 3,
      },
    ],
  }),
  methods: {},
  async created() {
    console.log(this.$store.state.config);
    try {
      this.likes = await this.$api.getLike(this.$store.state.config);
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>

<style>
.mypage-student-like-page__content {
  margin-top: -12px;
  flex-wrap: wrap;
}

.mypage-student-like-page__item-container {
  width: calc(100% / 3);
}

.mypage-student-like-page__item {
  margin: 12px;
  height: 250px;
  cursor: pointer;
  border: solid 1px #fb8805;
  border-radius: 8px;
  background: #fff;
  overflow: hidden;
}

.mypage-student-like-page__item:hover {
  box-shadow: 0 0 20px 4px rgb(0, 0, 0, 0.1);
  transition: all 0.3s;
}

.mypage-student-like-page__profile-image {
  width: 100%;
  height: 180px;
  background: #dfdfdf;
}

.mypage-student-like-page__item-content {
  height: 100%;
  padding: 12px 8px;
  font-size: 14px;
  letter-spacing: -0.38px;
}
</style>