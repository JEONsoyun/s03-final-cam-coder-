<template>
  <div class="d-flex flex-column c-main-layout">
      <div class="c-main-layout__header-container">
          <div class="c-main-layout__header">
            <div @click="onLogoClick" class="d-flex flex-grow-0 align-center" style="margin-right: 40px;cursor:pointer">
                <img src="/static/images/CamCoder_text.png" style="height: 40px;"/>
            </div>
            <div v-for="(item, ii) in items" :key="`item-${ii}`" @click="onItemClick(item)" class="c-main-layout__item" :class="{'c-main-layout__item--selected': selectedId == item.id}">{{item.text}}</div>
            <div class="d-flex" />
            <c-button @click="$router.push('/signup')" class="flex-grow-0" type="white" style="margin-right: 12px;">회원가입</c-button>
            <c-button @click="$router.push('/login')" class="flex-grow-0">로그인</c-button>
          </div>
      </div>
      <div class="d-flex flex-column flex-grow-1 c-main-layout__content">
          <slot />
      </div>
      <div class="d-flex flex-column c-main-layout__footer">
          <div class="c-main-layout__footer-content-container">
              <div class="c-main-layout__footer-content">
                  <div style="color: #333;margin-bottom: 8px;">CamCoder</div>
                  SSAFY 3기 자율 프로젝트<br>
                  팀코드: 110<br>
                  팀장: 임진희 | 
                  팀원: 김채은 박지호 서승희 전소윤<br>
                  도메인: k3a110.p.ssafy.io
              </div>
              
          </div>
          <div class="d-flex justify-center align-center c-main-layout__footer-bottom">
              ©2020 CamCoder All Rights Reserved.
          </div>
      </div>
  </div>
</template>

<script>
export default {
    data:() => ({
        selectedId: null,
        items: [
            {text: '선생님 찾기', id: 0, path: '/teacher/search'},
            {text: '마이페이지', id: 1, path: '/mypage'},
        ]
    }),
    methods: {
        onLogoClick() {
            this.$router.push('/');
        },
        onItemClick(item) {
            this.$router.push(item.path);
            this.selectedId = item.id;
        }
    },
    created() {
        console.log(this.$route.path);
    }
}
</script>

<style>
.c-main-layout {
    width: 100%;
    background-color: #f6f7f7;
    min-height: 100vh;
}

.c-main-layout__header-container {
    width: 100%;
    height: 75px;
    position: fixed;
    border-bottom: 1px solid #eaeaea;
    background-color: white;
    z-index: 9999;
    font-family: 'NanumSquareRound' !important;
}

.c-main-layout__header {
    width: 1024px;
    height: 100%;
    margin: 0 auto;
    display: flex;
    align-items: center;
}

.c-main-layout__item {
    padding: 0 12px;
    cursor: pointer;
}

.c-main-layout__item--selected {
    font-weight: 800;
    color: #fb8805;
}

.c-main-layout__content {
    padding-top: 75px;
    padding-bottom: 75px;
}

.c-main-layout__footer-content-container {
    width: 100%;
    border-top: 1px solid #eaeaea;
}

.c-main-layout__footer-content {
    width: 1024px;
    height: 100%;
    margin: 0 auto;
    padding: 32px 0;
    color: #a3a3a3;
    font-size: 12px;
    font-weight: 800;
    letter-spacing: -0.32px;
}

.c-main-layout__footer-bottom {
    height: 54px;
    background: #fb8805;
    color: #fff;
    font-size: 12px;
    font-weight: 700;
}
</style>