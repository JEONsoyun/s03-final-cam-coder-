<template>
<div style="padding: 16px;">
  <div class="d-flex flex-column main-page">
    <div class="d-flex flex-column main-page__title">
      <div class="d-flex justify-center" style="font-weight:bold;font-size:18px">김과외는 많은 분께 신뢰받고 있습니다.</div>
      <div class="d-flex justify-center main-page__10-black" style="margin-top: 8px">학생, 학부모님 이용 압도적 1위, 선생님 풀 압도적 1위 과외 플랫폼입니다.</div>
    </div>
    <div class="d-flex">
      <div class="d-flex flex-column flex-grow-1" style="width:20px">
        <div class="d-flex justify-center">
          <img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
        </div>
        <div class="d-flex justify-center">220,619명</div>
        <div class="d-flex justify-center main-page__10-black">선생님 회원</div>
      </div>
      <div class="d-flex flex-column flex-grow-1" style="width:20px">
        <div class="d-flex justify-center"><img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/></div>
        <div class="d-flex justify-center">563,116명</div>
        <div class="d-flex justify-center main-page__10-black">학생/학부모 회원</div>
      </div>
      <div class="d-flex flex-column flex-grow-1" style="width:20px">
        <div class="d-flex justify-center"><img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/></div>
        <div class="d-flex justify-center">96.4%</div>
        <div class="d-flex justify-center main-page__10-black">선생님 회원</div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'main-page',
  data: () => ({
  }),
  methods: {
  },
  async created() {
  },
  mounted() {
  },
};
</script>

<style>
.main-page {
  padding: 16px;
  border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}

.main-page__title {
    margin-top: 20px;
    margin-bottom: 20px;
}

.main-page__10-black {
    font-size:10px;
}
</style>
