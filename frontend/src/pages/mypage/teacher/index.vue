<template>
  <c-mypage-layout title="선생님 메뉴">
    <div class="d-flex flex-grow-0" style="padding: 16px">
      <div
        @click="$router.push('/mypage/teacher/tutoring')"
        class="d-flex justify-center align-center mypage-teacher-page__menu"
      >
        <img
          class="mypage-teacher-page__image"
          src="/static/images/status.png"
        />
        <div class="mypage-teacher-page__text">나의 수업 현황</div>
      </div>
      <div
        @click="$router.push('/mypage/teacher/edit')"
        class="d-flex justify-center align-center mypage-teacher-page__menu"
      >
        <img
          class="mypage-teacher-page__image"
          src="/static/images/edit.png"
        />
        <div class="mypage-teacher-page__text">선생님 프로필 수정</div>
      </div>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-teacher-page',
};
</script>

<style>
.mypage-teacher-page {
}

.mypage-teacher-page__menu {
  padding: 16px;
  border: solid 1px #eaeaea;
  cursor: pointer;
  width: 100px;
}

/* .mypage-teacher-page__menu:last-child {
  padding: 16px;
  border-left: 0;
} */

.mypage-teacher-page__menu:hover {
  background: linear-gradient(to right, #eea849, #f46b45);
  color: #fff;
}

.mypage-teacher-page__image {
  width: 60px;
  border-radius: 50%;
  border: solid 1px #fff;
  background: #fff;
}

.mypage-teacher-page__text {
  margin-left: 16px;
  font-size: 28px;
  font-weight: 800;
  letter-spacing: -1px;
  margin-right: 16px;
}
</style>