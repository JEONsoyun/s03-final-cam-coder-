<template>
    <c-main-layout>
        <div class="c-mypage-layout">
            <div class="c-mypage-layout__top" />
            <div class="c-mypage-layout__content-container">
                <div class="c-mypage-layout__content">
                    <div></div>
                </div>
            </div>
        </div>
    </c-main-layout>
</template>

<script>
export default {
    data:() => ({
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
</style>