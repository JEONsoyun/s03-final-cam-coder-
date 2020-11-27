<template>
  <c-mypage-layout title="학생 메뉴">
    <div class="d-flex flex-grow-0" style="padding: 16px">
      <div
        @click="$router.push('/mypage/student/tutoring')"
        class="d-flex justify-center align-center mypage-student-page__menu"
      >
        <img
          class="mypage-student-page__image"
          src="/static/images/status.png"
        />
        <div class="mypage-student-page__text">나의 과외 현황</div>
      </div>
      <div
        @click="$router.push('/mypage/student/like')"
        class="d-flex justify-center align-center mypage-student-page__menu"
      >
        <img class="mypage-student-page__image" src="/static/images/like.png" />
        <div class="mypage-student-page__text">관심 선생님 목록</div>
      </div>
    </div>
  </c-mypage-layout>
</template>
<script>
export default {
  name: 'mypage-student-page',
  data: () => ({
    user: {},
  }),
  methods: {},
  async created() {
    try {
      this.user = await this.$api.getMe(this.$store.state.config);
    } catch (e) {
      console.error(e);
    }
  },
};
</script>
<style>
.mypage-student-page {
}

.mypage-student-page__menu {
  padding: 16px;
  border: solid 1px #eaeaea;
  cursor: pointer;
  width: 100px;
}

.mypage-student-page__menu:last-child {
  padding: 16px;
  border-left: 0;
}

.mypage-student-page__menu:hover {
  background: linear-gradient(to right, #eea849, #f46b45);
  color: #fff;
}

.mypage-student-page__image {
  width: 60px;
  border-radius: 50%;
  border: solid 1px #fff;
  background: #fff;
}

.mypage-student-page__text {
  margin-left: 16px;
  font-size: 28px;
  font-weight: 800;
  letter-spacing: -1px;
  margin-right: 16px;
}
</style>
