<template>
  <c-main-layout>
    <div class="teacher-search-page__container">
      <div class="teacher-search-page">
        <div class="teacher-search-page__title">
          221,440명의 과외 선생님이 있습니다.
        </div>
        <div class="d-flex teacher-search-page__search-container">
          <v-text-field
            class="teacher-search-page-input"
            dense
            hide-details
            solo
            flat
            outlined
            label="키워드를 입력해주세요."
            v-model="keyword"
            @keydown.enter="onSearchClick"
          ></v-text-field>
          <c-button
            @click="onSearchClick"
            type="gradient"
            class="flex-grow-0"
            style="width: 80px"
            >검색</c-button
          >
        </div>
        <div class="d-flex teacher-search-page__content">
          <div
            v-for="(item, ti) in teachers"
            :key="`teacher-${ti}`"
            class="d-flex flex-column teacher-search-page__item-container"
          >
            <div class="d-flex flex-column teacher-search-page__item">
              <div
                class="d-flex flex-shrink-0 teacher-search-page__profile-image"
              >
                {{ item.user.userProfile }}
              </div>
              <div class="d-flex flex-column teacher-search-page__item-content">
                <div style="font-weight: 800">{{ item.user.userName }}</div>
                <div class="d-flex flex-grow-1 flex-column">
                  <div>{{ item.expertise }}</div>
                  <div>{{ item.avaliableTime }}</div>
                </div>
                <div class="d-flex teacher-search-page__item-bottom">
                  <div class="d-flex flex-grow-0 align-center">
                    <v-icon color="#ff4a62" style="margin-right: 2px"
                      >favorite</v-icon
                    >
                    {{ item.likeCnt }}
                  </div>
                  <div class="d-flex" />
                  <div class="d-flex flex-grow-0 align-center">
                    <v-icon color="#4e41ff" style="margin-right: 2px"
                      >account_circle</v-icon
                    >
                    {{ item.studentCnt }}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="teacher-search-page__more">
          <c-button @click="onMoreClick" type="gradient">더 불러오기</c-button>
        </div>
      </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {
  name: 'teacher-search-page',
  data: () => ({
    teachers: [],
    // searchKey: {
    //   avaliableTime: '',
    //   expertise: '',
    //   intro: '',
    //   keywords: '',
    //   price: null,
    //   profile: '',
    //   sorttype: null,
    // },
    keyword: '',
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
  methods: {
    async onSearchClick() {
      try {
        console.log('선생님', this.teachers);
        console.log('선생님키워드', this.keyword);
        let tmp = await this.$api.searchTeacher(
          {
            keyword: this.keyword,
          },
          this.$store.state.config
        );
        this.teachers = tmp;
        console.log(this.teachers);
      } catch (e) {
        console.log('선생님 로딩 실패');
      }
    },
    onMoreClick() {
      alert('더 불러올 데이터가 없습니다.');
    },
    onItemClick(item) {
      this.$router.push(`/teacher/detail/${item.user.userCode}`);
    },
  },
  async created() {
    try {
      console.log('선생님', this.teachers);
      this.teachers = await this.$api.sortTeacher(
        {
          keyword: this.keyword,
        },

        this.$store.state.config
      );
      //console.log(this.teachers);
    } catch (e) {
      console.log('선생님 로딩 실패');
    }
  },
};
</script>

<style>
.teacher-search-page__container {
  padding: 40px 0 0 0;
  width: 100%;
}

.teacher-search-page {
  width: 1024px;
  margin: 0 auto;
}

.teacher-search-page__title {
  color: #525252;
  font-size: 18px;
  font-weight: 600;
}

.teacher-search-page__search-container {
  margin-top: 32px;
  max-width: 500px;
}

.teacher-search-page-input input {
  padding: 0 !important;
}
.teacher-search-page-input .v-input__control {
  height: 42px !important;
}

.teacher-search-page-input .v-text-field__slot {
  height: 42px;
  font-size: 14px;
  color: #8a8a8a !important;
}
.teacher-search-page-input fieldset {
  border-color: #fb8805 !important;
  height: 46px;
}

.teacher-search-page__content {
  margin-top: 40px;
  flex-wrap: wrap;
}

.teacher-search-page__item-container {
  width: 25%;
}

.teacher-search-page__item {
  margin: 24px 12px;
  height: 350px;
  cursor: pointer;
  border: solid 1px #fb8805;
  border-radius: 8px;
  background: #fff;
  overflow: hidden;
}

.teacher-search-page__item:hover {
  box-shadow: 0 0 20px 4px rgb(0, 0, 0, 0.1);
  transition: all 0.3s;
}

.teacher-search-page__profile-image {
  width: 100%;
  height: 180px;
  background: #dfdfdf;
}

.teacher-search-page__item-content {
  height: 100%;
  padding: 12px 8px;
  font-size: 14px;
  letter-spacing: -0.38px;
}

.teacher-search-page__item-bottom {
  margin-top: 8px;
  font-weight: 800;
}

.teacher-search-page__more {
  margin-top: 40px;
}
</style>
