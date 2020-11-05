<template>
  <c-mypage-layout title="나의 관심 선생님 목록">
    <div style="padding: 16px">
      <div class="d-flex flex-column like-page">
        <div class="d-flex flex-column like-page__title">
          <div
            class="d-flex"
            style="font-weight: bold; font-size: 30px; margin-bottom: 20px"
          >
            나의 관심 선생님 목록
          </div>
        </div>
        <div class="d-flex flex-wrap teacher-list">
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
          <div class="d-flex flex-column align-center flex-grow-0 list">
            <div class="d-flex flex-column justify-center">
              <img
                style="width: 120px"
                src="https://kimstudy.com/Resources/images/tutor.png"
              />
            </div>
            <div
              class="d-flex flex-column justify-center"
              style="font-weight: bold; font-size: 18px"
            >
              한국에서 영어 유학
            </div>
            <div class="d-flex flex-column justify-center">
              가격 : 시간당 20,000원
            </div>
            <div
              class="d-flex flex-column justify-center align-center flex-grow-1 delete_button"
            >
              삭제
            </div>
          </div>
        </div>
      </div>
      <div>{{ this.likes }}</div>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: "mypage-student-like-page",
  data: () => ({
    user: {},
    likes: [],
  }),
  methods: {},
  async created() {
    console.log(this.$store.state.config);
    try {
      this.user = await this.$api.getMe(this.$store.state.config);
      this.likes = await this.$api.getLike(this.$store.state.config);
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>

<style>
.like-page {
  padding: 16px;
  width: 100%;
  border-style: solid;
  border-color: #eaeaea;
  border-width: 1px;
}
.teacher-list {
  width: 100%;
  flex-direction: row;
}
.list {
  width: 200px;
  border-style: solid;
  border-color: #eaeaea;
  border-width: 1px;
}
.delete_button {
  background-color: #fb8805;
  box-shadow: 5px;
  color: white;
  cursor: pointer;
  border-radius: 4px;
  height: 40px;
  width: 100px;
  margin-top: 10px;
}
</style>