<template>
    <c-main-layout>
        <div class="c-mypage-layout">
            <div class="c-mypage-layout__top-container">
                <div class="c-mypage-layout__top">[안내] 과외룸 입장은 과외 현황에서 할 수 있습니다.</div>
            </div>
            <div class="c-mypage-layout__content-container">
                <div class="d-flex c-mypage-layout__content">
                    <div @click="selectedId=0" class="d-flex justify-center align-center c-mypage-layout__content-menu1" 
                    :class="{'c-mypage-layout__content-menu--selected': selectedId == 0}">
                        학생
                    </div>
                    <div @click="selectedId=1" class="d-flex justify-center align-center c-mypage-layout__content-menu2" 
                    :class="{'c-mypage-layout__content-menu--selected': selectedId == 1}">
                        선생님
                    </div>
                    <div class="d-flex flex-column flex-grow-0 align-center c-mypage-layout__content-left">
                        <div class="c-mypage-layout__profile-image">프로필 이미지</div>
                        <div class="c-mypage-layout__profile-text">사용자 이름<span style="font-weight:400">님
                            <v-icon>keyboard_arrow_right</v-icon></span></div>
                        <div></div>
                    </div>
                    <div class="d-flex c-mypage-layout__content-right"></div>
                </div>
            </div>
        </div>
    </c-main-layout>
</template>

<script>
export default {
    data:() => ({
        selectedId: 0,
    }),
}
</script>

<style>
.c-mypage-layout {
    position: relative;
    width: 100%;
    height: 680px;
}

.c-mypage-layout__top-container {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 220px;
    background: linear-gradient(to right, #EEA849, #F46B45);
}

.c-mypage-layout__top {
    width: 1024px;
    margin: 0 auto;
    padding: 16px;
    padding-top: 34px;
    color: #fff;
    font-size: 12px;
    font-weight: 800;
}

.c-mypage-layout__content-container {
    position: absolute;
    width: 1024px;
    top: 80px;
    left: 0;
    right: 0;
    margin: 0 auto;
    height: 600px;
    background: #fff;
    border-radius: 16px;
    border: solid 1px #eaeaea;
    padding: 32px 0;
}

.c-mypage-layout__content {
    position: relative;
    width: 100%;
    height: 100%;
}

.c-mypage-layout__content-menu1 {
    position: absolute;
    right: 120px;
    top: -72px;
    width: 76px;
    height: 40px;
    background: rgb(228, 228, 228);
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    cursor: pointer;
    color: rgb(165, 165, 165);
    font-weight: 800;
}

.c-mypage-layout__content-menu2 {
    position: absolute;
    right: 52px;
    top: -72px;
    width: 76px;
    height: 40px;
    background: rgb(228, 228, 228);
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    cursor: pointer;
    color: rgb(165, 165, 165);
    font-weight: 800;
}

.c-mypage-layout__content-menu--selected {
    background: #fff;
    box-shadow: 2px -6px 6px 1px rgba(0, 0, 0, 0.3);
    z-index: 2;
    color:#F46B45;
    font-weight: 800;
}

.c-mypage-layout__content-left {
    width: 230px;
    height: 100%;
    padding-top: 24px;
}

.c-mypage-layout__content-right {
    border-left: 1px solid #f2f4f6;
    border-left-width: 1px;
    border-left-style: solid;
    border-left-color: rgb(242, 244, 246);
}

.c-mypage-layout__profile-image {
    width: 100px;
    height: 100px;
    background: #eaeaea;
    border-radius: 50%;
    overflow: hidden;
}
.c-mypage-layout__profile-text {
    margin-right: -24px;
    margin-top: 16px;
    font-size: 14px;
    font-weight: 800;
}

</style>