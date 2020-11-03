<template>
<c-main-layout>
<div class="d-flex justify-center">
    <div>
    <div class="d-flex flex-column justify-center signup-result-page">
        <div class="d-flex flex-column result-message">
            <div class="d-flex justify-center">
                <img style="width:200px" src="https://kimstudy.com/Resources/images/tutor.png"/>
            </div>
            <div class="d-flex" style="margin-left:10px;font-weight:bold;font-size:20px">ooo님, 반갑습니다.</div>
            <div class="d-flex main-page__10-black" style="margin-left:10px;margin-top: 8px">실시간 화상 코딩 과외 서비스 플랫폼 'Cam-coder'입니다.</div>
            <div class="d-flex main-page__10-black" style="margin-left:10px;margin-top: 8px">지금 바로 나에게 맞는 과외 선생님을 만나 보세요!</div>
            <c-button style="margin-top:20px;">선생님 찾으러가기</c-button>
        </div>
    </div>
    </div>
</div>
</c-main-layout>
</template>

<script>
export default {

}
</script>

<style>

.signup-result-page {
    margin-top: 20px;
    width : 600px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.search_button {
    background-color: #fb8805;
    box-shadow: 1px;
    color: white;
    cursor: pointer;
    border-radius: 4px;
    height: 40px;
    padding: 0 12px;
    margin-top: 50px;
}
</style>