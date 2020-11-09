<template>
<div class="d-flex justify-center">
    <div class="d-flex flex-column">
    <div class="d-flex flex-column justify-center teacher-index-page">
        <div class="d-flex flex-column teacher-information">
            <div class="d-flex flex-column">
                <div class="d-flex" style="font-weight:bold;font-size:25px">나의 정보</div>
                <div class="d-flex flex-row teacher-detail">
                    <img style="width:200px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                    <div class="d-flex flex-column detail-page__title">
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
                <div class="d-flex align-center flex-grow-1">
                    <c-button style="height:30px;width:20px;margin-top:80px;margin-left:10px;">나의 정보 상세보기</c-button>
                </div>
            </div>
        </div> 


        <div class="d-flex flex-column teacher-message">
            <div class="d-flex flex-column">
                <div class="d-flex" style="font-weight:bold;font-size:25px">나의 메세지</div>
                <div class="d-flex flex-row flex-wrap message-list">
                    <div class="d-flex align-center flex-grow-0 list">
                    <div class="d-flex" style="width:120px">
                        <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                    </div>
                    <div class="d-flex" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                    <c-button style="margin-top:60px;margin-left:240px;">메세지 상세보기</c-button>
                    <c-button type="white" style="margin-top:60px;margin-left:10px;">메세지 삭제하기</c-button>
                </div>
                <div class="d-flex align-center flex-grow-0 list">
                    <div class="d-flex" style="width:120px">
                        <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                    </div>
                    <div class="d-flex" style="font-weight:bold;font-size:18px">한국에서 영어 유학</div>
                    <c-button style="margin-top:60px;margin-left:240px;">메세지 상세보기</c-button>
                    <c-button type="white" style="margin-top:60px;margin-left:10px;">메세지 삭제하기</c-button>
                </div>
            </div>
                <div class="d-flex align-center flex-grow-1">
                    <c-button style="height:30px;width:20px;margin-top:80px;margin-left:10px;">나의 메세지 목록보기</c-button>
                </div>
            </div>
        </div>


        <div class="d-flex flex-column teacher-tutoring">
            <div class="d-flex flex-column">
                <div class="d-flex" style="font-weight:bold;font-size:25px">나의 과외</div>
                <div class="d-flex flex-row flex-wrap tutoring-list">
                    <div class="d-flex align-center flex-grow-0 list">
                        <div class="d-flex" style="width:120px">
                            <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                        </div>
                        <div class="d-flex" style="font-weight:bold;font-size:18px;margin-right:20px;">한국에서 영어 유학</div>
                        <div class="d-flex">과외 상태 (요청중, 수락, 완료, 취소)</div>
                        <c-button style="margin-top:60px;margin-left:50px;">입장하기</c-button>
                        <c-button type="white" style="margin-top:60px;margin-left:10px;">취소하기</c-button>  
                    </div>
                    <div class="d-flex align-center flex-grow-0 list">
                        <div class="d-flex" style="width:120px">
                            <img style="width:120px" src="https://kimstudy.com/Resources/images/tutor.png"/>
                        </div>
                        <div class="d-flex" style="font-weight:bold;font-size:18px;margin-right:20px;">한국에서 영어 유학</div>
                        <div class="d-flex">과외 상태 (요청중, 수락, 완료, 취소)</div>
                        <c-button style="margin-top:60px;margin-left:50px;">입장하기</c-button>
                        <c-button type="white" style="margin-top:60px;margin-left:10px;">취소하기</c-button>  
                    </div>
                </div>
                <div class="d-flex align-center flex-grow-1">
                    <c-button style="height:30px;width:20px;margin-top:80px;margin-left:10px;">나의 과외 목록보기</c-button>
                </div>
            </div>
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
.teacher-index-page {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.teacher-detail {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;
}
.detail-page__title {
    margin-top: 10px;
    width : 600px;
}
.teacher-message {
    margin-top: 20px;
    width : 800px;
    border-style: solid;
    border-color: #eaeaea;
    border-width: 1px;  
}
.teacher-tutoring {
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
.like-list {
    width:100%;
    flex-direction: row;
}
.like {
    width: 200px;
    border-style: solid;
        border-color: #eaeaea;
        border-width: 1px;   
}
</style>