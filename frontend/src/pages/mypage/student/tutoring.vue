<template>
<div style="padding: 16px;">
    <div class="d-flex flex-column message-index-page">
        <div class="d-flex flex-column message-index-page__title">
            <div class="d-flex" style="font-weight:bold;font-size:30px;margin-bottom:20px;">나의 과외 목록</div>
        </div>
        <div class="d-flex flex-row flex-wrap message-list">
            <div class="d-flex align-center flex-grow-0 list">
                <div class="d-flex" style="width:120px">
                    <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                </div>
                <div class="d-flex" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                <div class="d-flex">과외 상태 (요청중, 수락, 완료, 취소)</div>
                <div class="d-flex justify-center align-center flex-grow-1 enter_button">입장하기</div>      
                <div class="d-flex justify-center align-center flex-grow-1 cancel_button">취소하기</div>      
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {

}
</script>

<style>
.message-index-page {
  padding: 16px;
  width: 100%;
  border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;

}
.message-list {
    width:100%;
}
.list {
    width: 100%;
    border-style: solid;
        border-color: #eaeaea;
        border-width: 1px;
    height: 120px;   
}
.enter_button {
    background-color: #fb8805;
    box-shadow: 5px;
    color: white;
    cursor: pointer;
    border-radius: 4px;
    height: 30px;
    width: 20px;
    margin-top: 90px; 
    margin-left: 10px;
}
.cancel_button {
    background-color: #fb8805;
    box-shadow: 5px;
    color: white;
    cursor: pointer;
    border-radius: 4px;
    height: 30px;
    width: 20px;
    margin-top: 90px; 
    margin-left: 10px;
}
</style>