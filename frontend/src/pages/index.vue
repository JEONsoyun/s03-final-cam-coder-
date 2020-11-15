<template>
  <c-main-layout>
    <div class="main-page__top-container">
      <div class="d-flex main-page__top">
        <div class="d-flex flex-column justify-center main-page__top-left">
          <div class="main-page__fs-20">좋은 선생님을 원하는 곳에서</div>
          <div class="main-page__fs-30">대한민국 1위를 꿈꾸는</div>
          <div class="d-flex flex-grow-0" style="margin-top: 8px">
            <div class="main-page__fs-40">과외 플랫폼</div>
            <div class="main-page__fs-44">CamCoder</div>
          </div>
        </div>
        <div class="main-page__top-right">
          <div class="main-page__top-right-image"></div>
        </div>
      </div>
    </div>
    <div class="main-page__content-container">
      <div class="d-flex flex-column main-page__content">
        <div class="d-flex flex-column main-page__title">
          <div
            class="d-flex justify-center main-page__fs-22"
            style="margin-top: -8px"
          >
            CamCoder는 실시간 영상 공유, 코드 빌더를 제공합니다.
          </div>
          <div class="d-flex justify-center main-page__fs-14">
            멋진 개발자를 꿈꾸는 학생들이 가진 코딩의 어려움을 해결해 줄 과외 플랫폼입니다.
          </div>
        </div>
        <div class="d-flex">
          <div class="d-flex flex-column flex-grow-1" style="width: 20px">
            <div class="d-flex justify-center" style="padding: 30px">
              <v-icon size="60" color="#EEA849">record_voice_over</v-icon>
            </div>
            <div class="d-flex justify-center main-page__fs-22">220,619명</div>
            <div class="d-flex justify-center main-page__fs-14">
              선생님 회원을 꿈꾸는
            </div>
          </div>
          <div class="d-flex flex-column flex-grow-1" style="width: 20px">
            <div class="d-flex justify-center" style="padding: 30px">
              <v-icon size="60" color="#Fb8805">face</v-icon>
            </div>
            <div class="d-flex justify-center main-page__fs-22">563,116명</div>
            <div class="d-flex justify-center main-page__fs-14">
              학생 회원을 꿈꾸는
            </div>
          </div>
          <div class="d-flex flex-column flex-grow-1" style="width: 20px">
            <div class="d-flex justify-center" style="padding: 30px">
              <v-icon size="60" color="#F46B45">thumb_up</v-icon>
            </div>
            <div class="d-flex justify-center main-page__fs-22">96.4%</div>
            <div class="d-flex justify-center main-page__fs-14">
              고객 만족도을 꿈꾸는
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-if="!$store.state.ISLOGGEDIN" class="main-page__content-container">
      <div class="d-flex flex-column align-center main-page__content">
        <div style="font-size: 20px; color: #777; font-weight: 800">
          1분안에 내게 딱 맞는 과외 선생님 또는 학생을 찾아볼 수 있어요.
        </div>
        <c-button
          type="gradient"
          @click="$router.push('/signup')"
          style="margin-top: 32px"
          >회원 가입하고 서비스 이용하기</c-button
        >
      </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {
  name: 'main-page',
  data: () => ({}),
  methods: {},
  async created() {},
  mounted() {},
};
</script>

<style>
.main-page__top-container {
  width: 100%;
  height: 300px;
  background: linear-gradient(to right, #EEA849, #F46B45);
}

.main-page__top {
  width: 780px;
  height: 100%;
  margin: 0 auto;
}

.main-page__top-left {
  width: 55%;
  height: 100%;
  color: #fff;
  font-weight: 700;
}

.main-page__fs-20 {
  font-size: 20px;
}

.main-page__fs-30 {
  margin-top: 24px;
  font-size: 30px;
}

.main-page__fs-40 {
  font-size: 40px;
}

.main-page__fs-44 {
  font-size: 44px;
  font-weight: 800;
  letter-spacing: -4px;
  margin-left: 16px;
}

.main-page__top-right {
  width: 45%;
  height: 100%;
}

.main-page__top-right-image {
  width: 100%;
  height: 100%;
  background-image: url('/static/images/monitor.png');
  background-size: 320px auto;
  background-position: center 56px;
}

.main-page__content-container {
  width: 100%;
  padding-top: 32px;
}

.main-page__content {
  width: 660px;
  margin: 0 auto;
  background: #fff;
  padding: 32px;
  border-style: solid;
  border-color: #eaeaea;
  border-width: 1px;
}

.main-page__title {
  margin-top: 20px;
  margin-bottom: 20px;
}

.main-page__fs-22 {
  margin-top: 12px;
  font-size: 22px;
  font-weight: 600;
}

.main-page__fs-14 {
  margin-top: 12px;
  font-size: 14px;
}
</style>

