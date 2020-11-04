<template>
    <c-main-layout>
        <div class="c-mypage-layout">
            <div class="c-mypage-layout__top" />
            <div class="c-mypage-layout__content-container">
                <div class="c-mypage-layout__content">
                    <div @click="selectedId=0" class="c-mypage-layout__content-menu1" :class="{'c-mypage-layout__content-menu--selected': selectedId == 0}"></div>
                    <div @click="selectedId=1" class="c-mypage-layout__content-menu2" :class="{'c-mypage-layout__content-menu--selected': selectedId == 1}"></div>
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

.c-mypage-layout__top {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 250px;
    background: linear-gradient(to right, #EEA849, #F46B45);
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
    padding: 16px;
}

.c-mypage-layout__content {
    position: relative;
}

.c-mypage-layout__content-menu1 {
    position: absolute;
    right: 100px;
    top: -56px;
    width: 60px;
    height: 40px;
    background: rgb(209, 209, 209);
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    cursor: pointer;
}

.c-mypage-layout__content-menu2 {
    position: absolute;
    right: 42px;
    top: -56px;
    width: 60px;
    height: 40px;
    background: rgb(209, 209, 209);
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    cursor: pointer;
}

.c-mypage-layout__content-menu--selected {
    background: #fff;
    box-shadow: 2px -6px 6px 1px rgba(0, 0, 0, 0.3);
    z-index: 2;
}
</style>