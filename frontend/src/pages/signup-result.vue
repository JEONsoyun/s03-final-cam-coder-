<template>
  <c-main-layout>
    <div
      class="d-flex justify-center signup-result-page__container"
    >
      <div class="signup-result-page">
        <div class="signup-result-page__title">환영합니다!</div>
        <div class="signup-result-page__subtitle">
          이제 CamCoder의 1:1 과외 서비스를 이용하실 수 있습니다.
        </div>
        <c-button @click="$router.push('/login')" type="gradient">로그인 화면으로</c-button>
        <c-button @click="$router.push('/')" type="white" style="margin-top: 8px">메인페이지</c-button>
      </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {};
</script>

<style>
.signup-result-page__container {
  margin-top: 80px;
}

.signup-result-page {
  width: 400px;
}

.signup-result-page__title {
  font-size: 28px;
  font-weight: 800;
  letter-spacing: -0.48px;
  margin-bottom: 8px;
  color: #333;
}

.signup-result-page__subtitle {
  color: #555;
  font-size: 14px;
  letter-spacing: -0.32px;
  margin-bottom: 40px;
}
</style>