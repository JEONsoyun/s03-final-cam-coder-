<template>
  <c-main-layout>
      <div class="teacher-search-page__container">
          <div class="teacher-search-page">
            <div class="teacher-search-page__title">221,440명의 과외 선생님이 있습니다.</div>
            <div class="d-flex teacher-search-page__search-container">
            <v-text-field
              label="키워드를 입력해주세요."
              single-line
              solo
              flat
              height="44px"
              hide-details
              @keydown.enter="onSearchClick"
            ></v-text-field>
                <c-button class="flex-grow-0" style="height:48px;width:80px;">검색</c-button>
            </div>
            <div class="teacher-search-page__content">
                <div class="teacher-search-page__item">
                    <div class="teacher-search-page__item-image"></div>
                    <div class="teacher-search-page__item-content">
                        <div>text1</div>
                        <div>text2</div>
                        <div>text3</div>
                        <div>text4</div>
                    </div>
                </div>
            </div>
          </div>
      </div>
  </c-main-layout>
</template>

<script>
export default {
    name: 'teacher-search-page',
    methods: {
        onSearchClick() {
            
        }
    }
}
</script>

<style>
.teacher-search-page__container {
    padding: 40px 0;
    width: 100%;
}

.teacher-search-page {
    width: 1024px;
    margin: 0 auto;
}

.teacher-search-page__title {

}

.teacher-search-page__search-container {
    margin-top: 32px;
    max-width: 500px;
}

.teacher-search-page .v-input__control {
  height: 44px !important;
  border-color:  #fb8805 !important;
}

.teacher-search-page .v-input__slot {
border-color:  #fb8805 !important;
border-color:  #fb8805 !important;
}

.teacher-search-page .v-text-field__slot {
  height: 44px;
  font-size: 16px;
  color: #8a8a8a !important;
  border-color:  #fb8805 !important;
}

.teacher-search-page fieldset {
  border-color:  #fb8805 !important;
  height: 48px;
  background: #fff;
}

.teacher-search-page .v-text-field {
    border-color:  #fb8805 !important;
  font-size: 14px;
  font-weight: 400;
  letter-spacing: -0.39px;
  color: #c5c5c5;
}


</style>