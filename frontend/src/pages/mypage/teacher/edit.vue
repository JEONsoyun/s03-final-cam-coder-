<template>
  <c-mypage-layout title="선생님 정보 수정">
    <div class="mypage-teacher-edit-page">
      <div class="d-flex align-center mypage-teacher-edit-page__row">
        <div class="d-flex flex-shrink-0 mypage-teacher-edit-page__label">
          소개
        </div>
        <div class="mypage-teacher-edit-page__textarea-container">
          <textarea style="width: 100%; height: 100px" v-model="data.intro" />
        </div>
      </div>
      <div class="d-flex align-center mypage-teacher-edit-page__row">
        <div class="d-flex flex-shrink-0 mypage-teacher-edit-page__label">
          경력
        </div>
        <div class="mypage-teacher-edit-page__textarea-container">
          <textarea
            style="width: 100%; height: 100px"
            v-model="data.expertise"
          />
        </div>
      </div>
      <div class="d-flex align-center mypage-teacher-edit-page__row">
        <div class="mypage-teacher-edit-page__label">수업료</div>
        <v-text-field
          class="mypage-teacher-edit-page-input"
          v-model="data.price"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>
      <!-- <div class="d-flex align-center mypage-teacher-edit-page__row">
        <div class="mypage-teacher-edit-page__label">프로필 이미지</div>
        <v-text-field
          class="mypage-teacher-edit-page-input"
          v-model="data.profile"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div> -->
      <div class="d-flex align-center mypage-teacher-edit-page__row">
        <div class="mypage-teacher-edit-page__label">가능 일자</div>
        <v-text-field
          class="mypage-teacher-edit-page-input"
          v-model="data.avaliableTime"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>
      <c-button
        v-if="data.teacherCode == null"
        class="flex-grow-0"
        style="margin-top: 60px"
        @click="onEnrollTeacher"
        >선생님 등록하기</c-button
      >
      <c-button
        v-else
        class="flex-grow-0"
        style="margin-top: 60px"
        @click="onUpdateTeacher"
        >수정하기</c-button
      >
    </div>
  </c-mypage-layout>
</template>
<script>
export default {
  name: 'mypage-teacher-edit-page',
  data: () => ({
    teacher: {},
    data: {
      intro: '재미있는 자료구조 수업입니다.',
      expertise: 'OO대학교에서 자료구조 수업을 A+로 완료하였습니다.',
      price: '10000',
      profile: 'profile',
      avaliableTime: 'every sunday',
    },
  }),
  methods: {
    async onUpdateTeacher() {
      try {
        console.log(this.$store.state.config);
        await this.$api.updateTeacher(this.data, this.$store.state.config);
        alert('정보변경 성공');
      } catch (e) {
        alert('정보변경 실패.');
      }
    },
    async onEnrollTeacher() {
      try {
        console.log(this.$store.state.config);
        await this.$api.postTeacher(this.data, this.$store.state.config);
        alert('선생님 등록 성공');
      } catch (e) {
        alert('선생님 등록 실패.');
      }
    },
  },
  async created() {
    try {
      this.teacher = await this.$api.getTeacherMe(this.$store.state.config);
      console.log(this.teacher);
      this.data = this.teacher;
    } catch (e) {
      alert('잘못된 접근입니다.');
    }
  },
};
</script>
<style>
.mypage-teacher-edit-page {
  width: 400px;
  margin: 0 auto;
}
.mypage-teacher-edit-page-input input {
  padding: 0 !important;
}
.mypage-teacher-edit-page-input .v-input__control {
  height: 42px !important;
}

.mypage-teacher-edit-page-input .v-text-field__slot {
  height: 42px;
  font-size: 14px;
  color: #8a8a8a !important;
}
.mypage-teacher-edit-page-input fieldset {
  border-color: #fb8805 !important;
  height: 46px;
}

.mypage-teacher-edit-page__row {
  margin-bottom: 16px;
}

.mypage-teacher-edit-page__label {
  margin-right: 16px;
  width: 104px;
}

.mypage-teacher-edit-page__textarea-container {
  width: 100%;
  padding: 8px;
  padding-bottom: 2px;
  border: solid 1px #fb8805;
  border-radius: 4px;
  color: #686868;
  font-size: 14px;
}
</style>