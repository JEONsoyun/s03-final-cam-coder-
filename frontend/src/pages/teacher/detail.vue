<template>
<c-main-layout>
<div class="d-flex justify-center">
    <div class="d-flex flex-column">
    <div class="d-flex flex-column justify-center teacher-detail-page">
        <div class="d-flex flex-row teacher-detail">
            <img style="width:200px" src="https://kimstudy.com/Resources/images/tutor.png"/>
            <div class="d-flex flex-column teacher-page__title">
                <div class="d-flex justify-center" style="margin-bottom:10px;font-weight:bold;font-size:20px">한국에서 영어 유학</div>
                <div class="d-flex flex-row">
                    <div class="d-flex" style="font-size:15px;width:20px">경력</div>
                    <div class="d-flex" style="font-size:15px">Conventry University 국제경영 15학번 여자</div>
                </div> 
                <div class="d-flex flex-row">
                    <div class="d-flex" style="font-size:15px;width:20px">가격</div>
                    <div class="d-flex" style="font-size:15px">시간당 20,000원</div>
                </div> 
                <div class="d-flex flex-row">
                    <div class="d-flex" style="font-size:15px;width:20px">좋아요 수</div>
                    <div class="d-flex" style="font-size:15px">16개</div>
                </div>  
                <div class="d-flex flex-row">
                    <div class="d-flex" style="font-size:15px;width:20px">가능한 시간</div>
                    <div class="d-flex" style="font-size:15px">협의 가능</div>
                </div>  
                <div class="d-flex flex-row">
                    <div class="d-flex" style="font-size:15px;width:20px">CamCoder에서의 과외 횟수</div>
                    <div class="d-flex" style="font-size:15px">20회</div>
                </div> 
            </div>
        </div>
        <div class="d-flex flex-row teacher-information">
            <div class="d-flex">
            </div>    
        </div>
    </div>
    <div class="d-flex flex-column flex-grow-1 teacher-message">
        <div class="d-flex flex-column" style="font-weight:bold;font-size:18px">한국에서 영어유학</div>
        <div class="d-flex flex-column">선생님에게 원하는 수업에 대해서 문의해 보세요!</div>
        <c-button>문의하기</c-button> 
    </div>
    <div class="d-flex flex-column teacher-intro">
        <div class="d-flex flex-column">
            <div class="d-flex" style="font-weight:bold;font-size:18px">INTRODUCE</div>
            <div class="d-flex justify-center intro">
                <div class="d-flex">인트로~~~~~~~~~~~~</div>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column teacher-review">
        <div class="d-flex flex-column">
            <div class="d-flex" style="font-weight:bold;font-size:18px">REVIEW</div>
            <div class="d-flex" style="margin-top: 8px;font-size:15px">실제 과외를 수강한 학생들이 남긴 리뷰입니다.</div>
            <div class="d-flex flex-row review">
                <div class="d-flex flex-row flex-wrap review-list">
                    <div class="d-flex align-center flex-grow-0 list">
                        <div class="d-flex" style="width:120px">
                            <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                        </div>
                        <div class="d-flex user" style="font-size:18px">김00</div>
                        <div class="d-flex">이해가 너무 잘돼요~~~~~</div>
                    </div>
                    <div class="d-flex align-center flex-grow-0 list">
                        <div class="d-flex" style="width:120px">
                            <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                        </div>
                        <div class="d-flex user" style="font-size:18px">임00</div>
                        <div class="d-flex">선생님 너무 친절하세요!!</div>
                    </div>
                </div>
            </div>
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
.teacher-detail-page {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.intro {
    margin-top: 20px;
    width : 600px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.user {
    margin-left: 10px;
    margin-right: 10px;
}
.review {
    margin-top: 20px;
    width : 600px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-profile {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-intro {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-review {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-message {
    margin-top: 20px;
    width : 100px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-page__title {
    margin-top: 10px;
    width : 600px;
}
</style>