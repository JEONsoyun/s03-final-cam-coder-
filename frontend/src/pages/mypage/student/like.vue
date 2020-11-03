<template>
<div style="padding: 16px;">
    <div class="d-flex flex-column like-page">
        <div class="d-flex flex-column like-page__title">
            <div class="d-flex" style="font-weight:bold;font-size:30px;margin-bottom:20px;">나의 관심 선생님 목록</div>
        </div>
        <div class="d-flex flex-wrap teacher-list">
            <div class="d-flex flex-column align-center flex-grow-0 list">
                <div class="d-flex flex-column justify-center">
                    <img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                </div>
                <div class="d-flex flex-column justify-center" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                <div class="d-flex flex-column justify-center">가격 : 시간당 20,000원</div>
                <c-button style="margin-top:10px">삭제</c-button>   
            </div>
            <div class="d-flex flex-column align-center flex-grow-0 list">
                <div class="d-flex flex-column justify-center">
                    <img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                </div>
                <div class="d-flex flex-column justify-center" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                <div class="d-flex flex-column justify-center">가격 : 시간당 20,000원</div>
                <c-button style="margin-top:10px">삭제</c-button>   
            </div>
            <div class="d-flex flex-column align-center flex-grow-0 list">
                <div class="d-flex flex-column justify-center">
                    <img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                </div>
                <div class="d-flex flex-column justify-center" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                <div class="d-flex flex-column justify-center">가격 : 시간당 20,000원</div>
                <c-button style="margin-top:10px">삭제</c-button>   
            </div>
            <div class="d-flex flex-column align-center flex-grow-0 list">
                <div class="d-flex flex-column justify-center">
                    <img  style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                </div>
                <div class="d-flex flex-column justify-center" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                <div class="d-flex flex-column justify-center">가격 : 시간당 20,000원</div>
                <c-button style="margin-top:10px">삭제</c-button>   
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
.like-page {
  padding: 16px;
  width: 100%;
  border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;

}
.teacher-list {
    width:100%;
    flex-direction: row;
}
.list {
    width: 200px;
    border-style: solid;
        border-color: #eaeaea;
        border-width: 1px;   
}
.delete_button {
    background-color: #fb8805;
    box-shadow: 5px;
    color: white;
    cursor: pointer;
    border-radius: 4px;
    height: 40px;
    width: 100px;
    margin-top: 10px;
}
</style>