<template>
  <div class="c-main-layout">
      <div class="c-main-layout__header-container">
          <div class="c-main-layout__header">
            <div @click="onLogoClick" class="d-flex flex-grow-0 align-center" style="margin-right: 40px;cursor:pointer">
                <img src="/static/images/CamCoder.png" style="height: 40px;"/>
            </div>
            <div v-for="(item, ii) in items" :key="`item-${ii}`" @click="onItemClick(item)" class="c-main-layout__item" :class="{'c-main-layout__item--selected': selectedId == item.id}">{{item.text}}</div>
            <div class="d-flex" />
            <c-button @click="$router.push('/signup')" class="flex-grow-0" type="white" style="margin-right: 12px;">회원가입</c-button>
            <c-button @click="$router.push('/login')" class="flex-grow-0">로그인</c-button>
          </div>
      </div>
      <div class="c-main-layout__content">
          <slot />
      </div>
      <div class="c-main-layout__footer"></div>
  </div>
</template>

<script>
export default {
    data:() => ({
        selectedId: null,
        items: [
            {text: '선생님 찾기', id: 0, path: '/'},
            {text: '마이페이지', id: 1, path: '/'},
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
    }
}
</script>

<style>
.c-main-layout {
    width: 100%;
    height: 100vh;
    background-color: #f6f7f7;
    
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
}
</style>