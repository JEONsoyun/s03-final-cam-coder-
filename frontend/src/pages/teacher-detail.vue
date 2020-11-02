<template>
<div class="d-flex justify-center">
    <div>
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
                <!-- <div class="d-flex flex-row">
                    <div class="d-flex">
                        <img style="width:50px;height:50px;" src="https://kimstudy.com/Resources/images/tutor.png"/>
                    </div>
                    <div class="d-flex" style="font-size:15px">과목</div>
                    <div class="d-flex" style="font-size:15px">영어, 회화</div>
                </div> 
                <div class="d-flex flex-row">
                    <div class="d-flex">
                        <img style="width:50px;height:50px;" src="https://kimstudy.com/Resources/images/tutor.png"/>
                    </div>
                    <div class="d-flex" style="font-size:15px">지역</div>
                    <div class="d-flex" style="font-size:15px">서울 강남구, 경기 수원시 권선구, 경기 수원시 영통구</div>
                </div>  
                <div class="d-flex flex-row">
                    <div class="d-flex">
                        <img style="width:50px;height:50px;" src="https://kimstudy.com/Resources/images/tutor.png"/>
                    </div>
                    <div class="d-flex" style="font-size:15px">조회수</div>
                    <div class="d-flex" style="font-size:15px">1,210</div>
                </div>               -->
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
        <div class="d-flex justify-center align-center flex-grow-0 message_button">문의하기</div>  
    </div>
    <div class="d-flex flex-column teacher-information">
        <div class="d-flex flex-column">
            <div class="d-flex" style="font-weight:bold;font-size:18px">상세정보</div>
            <div class="d-flex justify-center info">
                <div class="d-flex">상세정보~~~~~~~~~~~~</div>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column teacher-review">
        <div class="d-flex flex-column">
            <div class="d-flex"></div>
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
.teacher-detail-page {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.info {
    margin-top: 20px;
    width : 600px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-information {
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
.message_button {
    background-color: #fb8805;
    box-shadow: 1px;
    color: white;
    cursor: pointer;
    border-radius: 4px;
    height: 40px;
    padding: 0 12px;
    margin-top: 50px;
}
.teacher-page__title {
    margin-top: 10px;
    width : 600px;
}
</style>