<template>
  <c-mypage-layout title="나의 수업 현황">
    <div class="mypage-teacher-tutoring-page">
      <div
        class="d-flex mypage-teacher-tutoring-page__box"
        v-for="(item, mi) in tutorings"
        :key="`item-${mi}`"
      >
        <div
          v-if="item.student.userProfile != null"
          class="d-flex flex-grow-0 flex-shrink-0 mypage-teacher-tutoring-page__profile"
          :style="`background-image:url(${item.student.userProfile})`"
        />
        <div
          v-else
          class="d-flex flex-grow-0 flex-shrink-0 mypage-teacher-tutoring-page__profile"
          :style="`background-image:url('/static/images/user.png')`"
        />
        <div class="d-flex flex-column" style="width: 100%; height: 100%">
          <div class="d-flex">
            <div>
              <div
                v-if="item.status == 0"
                class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-0"
              >
                수락
              </div>
              <div
                v-if="item.status == 1"
                class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-1"
              >
                요청
              </div>
              <div
                v-if="item.status == 2"
                class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-2"
              >
                완료
              </div>
              <div
                v-if="item.status == 3"
                class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-3"
              >
                취소
              </div>
            </div>
            <div class="d-flex" />
          </div>
          <div class="d-flex flex-grow-0">
            <div class="d-flex mypage-teacher-tutoring-page__name">
              {{ item.student.userName }}
            </div>
            <div class="d-flex flex-grow-0 mypage-teacher-tutoring-page__date">
              {{ $moment(item.requestDate).format('YYYY.MM.DD hh:mm') }}
            </div>
          </div>
          <div
            class="d-flex mypage-teacher-tutoring-page__content"
            style="margin-top: 4px"
          >
            과외 날짜:
            {{ $moment(item.startDate).format('YYYY.MM.DD hh:mm') }} ~
            {{ $moment(item.endDate).format('YYYY.MM.DD hh:mm') }}
          </div>
          <div class="d-flex">
            <div class="d-flex" />
            <c-button
              @click="onStateClick(item, 0)"
              v-if="getType(item)"
              :type="getType(item)"
              class="flex-grow-0"
            />
            <c-button
              @click="onStateClick(item, 3)"
              v-if="item.status == 1"
              type="cancel"
              class="flex-grow-0"
              style="margin-left: 8px"
            />
          </div>
        </div>
      </div>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-teacher-tutoring-page',
  data: () => ({
    user: {},
    tutorings: [],
    SAMPLE_DATA: [
      {
        id: 1,
        tutoringCode: 7,
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
          profile: '/static/images/user.png',
          likeCnt: 1,
          avaliableTime: '주말 모두 가능, 평일 7시 이후 ',
          studentCnt: 1,
        },
        student: {
          id: 4,
          userCode: 16,
          userId: 'studenta',
          userPw:
            '$2a$10$q4esBwQfUamOVv4kFCkSiuXdBCEAJeNWwzpFRUJ/o39x828XeUxEG',
          userName: 'namea',
          userProfile: 'i like math',
          joinDate: '2020-10-29T01:07:45.000+00:00',
        },
        startDate: '2012-04-23 18:25:44',
        endDate: '2013-04-23 18:25:44',
        status: 0,
        roomNum: 1,
        requestDate: '2020-10-30T09:31:39.000+00:00',
      },
      {
        id: 5,
        tutoringCode: 8,
        teacher: {
          id: 6,
          teacherCode: 2,
          user: {
            id: 7,
            userCode: 6,
            userId: 'teacher1',
            userPw: '1234',
            userName: '뭘또이런걸다',
            userProfile: null,
            joinDate: '2020-10-27T02:18:23.000+00:00',
          },
          intro:
            '현직 6년차 대리 개발자 입니다. ^^. 컴퓨터 공학과에서 배우는 개론부터 실무가지 전반적인 지식을 정리할 수 있습니다. 개념적인 구조와 역사<br> 또는, C계열이나 Java계열(Android포함), Arduino같은 마이크로콘트롤러까지 다양한 분야를 포괄합니다.',
          expertise:
            'C,C++,컴퓨터공학, C#, Java, 프로그래밍 과목을 수업합니다.',
          price: 20000,
          profile: '/static/images/user.png',
          likeCnt: 0,
          avaliableTime:
            '현직 개발자이므로 근무시간 외 가능합니다. <br> 평일과 오후6시 이후와 주말 상시입니다.',
          studentCnt: 1,
        },
        student: 4,
        startDate: '2020-10-23 18:25:44',
        endDate: '2020-11-23 18:25:44',
        status: 1,
        roomNum: 2,
        requestDate: '2020-10-30T09:34:02.000+00:00',
      },
      {
        id: 5,
        tutoringCode: 8,
        teacher: {
          id: 6,
          teacherCode: 2,
          user: {
            id: 7,
            userCode: 6,
            userId: 'teacher1',
            userPw: '1234',
            userName: '뭘또이런걸다',
            userProfile: null,
            joinDate: '2020-10-27T02:18:23.000+00:00',
          },
          intro:
            '현직 6년차 대리 개발자 입니다. ^^. 컴퓨터 공학과에서 배우는 개론부터 실무가지 전반적인 지식을 정리할 수 있습니다. 개념적인 구조와 역사<br> 또는, C계열이나 Java계열(Android포함), Arduino같은 마이크로콘트롤러까지 다양한 분야를 포괄합니다.',
          expertise:
            'C,C++,컴퓨터공학, C#, Java, 프로그래밍 과목을 수업합니다.',
          price: 20000,
          profile: '/static/images/user.png',
          likeCnt: 0,
          avaliableTime:
            '현직 개발자이므로 근무시간 외 가능합니다. <br> 평일과 오후6시 이후와 주말 상시입니다.',
          studentCnt: 1,
        },
        student: 4,
        startDate: '2020-10-23 18:25:44',
        endDate: '2020-11-23 18:25:44',
        status: 2,
        roomNum: 2,
        requestDate: '2020-10-30T09:34:02.000+00:00',
      },
      {
        id: 5,
        tutoringCode: 8,
        teacher: {
          id: 6,
          teacherCode: 2,
          user: {
            id: 7,
            userCode: 6,
            userId: 'teacher1',
            userPw: '1234',
            userName: '뭘또이런걸다',
            userProfile: null,
            joinDate: '2020-10-27T02:18:23.000+00:00',
          },
          intro:
            '현직 6년차 대리 개발자 입니다. ^^. 컴퓨터 공학과에서 배우는 개론부터 실무가지 전반적인 지식을 정리할 수 있습니다. 개념적인 구조와 역사<br> 또는, C계열이나 Java계열(Android포함), Arduino같은 마이크로콘트롤러까지 다양한 분야를 포괄합니다.',
          expertise:
            'C,C++,컴퓨터공학, C#, Java, 프로그래밍 과목을 수업합니다.',
          price: 20000,
          profile: '/static/images/user.png',
          likeCnt: 0,
          avaliableTime:
            '현직 개발자이므로 근무시간 외 가능합니다. <br> 평일과 오후6시 이후와 주말 상시입니다.',
          studentCnt: 1,
        },
        student: 4,
        startDate: '2020-10-23 18:25:44',
        endDate: '2020-11-23 18:25:44',
        status: 3,
        roomNum: 2,
        requestDate: '2020-10-30T09:34:02.000+00:00',
      },
    ],
  }),
  methods: {
    getType(item) {
      if (item.status == 1) {
        return 'accept';
      } else if (item.status == 0) {
        // TODO: 현재 날짜가 과외 날짜 안에 포함될 때 조건 걸기
        // 현재는 그냥 수락하면 다 방 입장하는걸로 되어있음
        return 'enter';
      } else {
        return '';
      }
    },
    async onStateClick(item, status) {
      console.log(status);
      if (status == 3) {
        let data = {
          status: 3,
        };
        try {
          await this.$api.updateTutoring(
            item.tutoringCode,
            data,
            this.$store.state.config
          );
          alert('취소되었습니다');
          console.log(this.$store.state.config);
          try {
            //this.user = await this.$api.getMe(this.$store.state.config);
            this.tutorings = await this.$api.getTeacherTutoring(
              this.$store.state.config
            );
          } catch (e) {
            console.log('잘못된 접근입니다. 로딩 실패');
          }
        } catch (e) {
          alert('취소 실패 ');
        }
      } else if (status == 0) {
        let data = {
          status: 0,
        };
        try {
          await this.$api.updateTutoring(
            item.tutoringCode,
            data,
            this.$store.state.config
          );
          alert('수락되었습니다');
          console.log(this.$store.state.config);
          try {
            //this.user = await this.$api.getMe(this.$store.state.config);
            this.tutorings = await this.$api.getTeacherTutoring(
              this.$store.state.config
            );
          } catch (e) {
            console.log('잘못된 접근입니다. 로딩 실패');
          }
        } catch (e) {
          alert('수락 실패 ');
        }
      }
    },
  },
  async created() {
    try {
      this.tutorings = await this.$api.getTeacherTutoring(
        this.$store.state.config
      );
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>

<style>
.mypage-teacher-tutoring-page {
}

.mypage-teacher-tutoring-page__box {
  padding: 16px;
  border: solid 1px #eaeaea;
  border-bottom: none;
}

.mypage-teacher-tutoring-page__box:last-child {
  border-bottom: solid 1px #eaeaea;
}

.mypage-teacher-tutoring-page__profile {
  margin: 12px;
  width: 48px;
  height: 48px;
  margin-right: 28px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
}

.mypage-teacher-tutoring-page__tag {
  padding: 0 6px;
  font-size: 12px;
  letter-spacing: -0.32px;
  border-radius: 2px;
  border: solid 1px #333;
  margin-bottom: 8px;
  font-weight: 800;
}

.mypage-teacher-tutoring-page__tag-0 {
  color: rgb(18, 211, 0);
  border-color: rgb(18, 211, 0);
}

.mypage-teacher-tutoring-page__tag-1 {
  color: rgb(231, 189, 0);
  border-color: rgb(231, 189, 0);
}

.mypage-teacher-tutoring-page__tag-2 {
  color: rgb(0, 89, 255);
  border-color: rgb(0, 89, 255);
}

.mypage-teacher-tutoring-page__tag-3 {
  color: rgb(129, 129, 129);
  border-color: rgb(129, 129, 129);
}

.mypage-teacher-tutoring-page__name {
  font-weight: 800;
  font-size: 14px;
  color: #333;
}

.mypage-teacher-tutoring-page__date {
  font-size: 12px;
  color: #999;
}

.mypage-teacher-tutoring-page__content {
  letter-spacing: -0.32px;
  color: #555;
}
</style>