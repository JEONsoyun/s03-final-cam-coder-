<template>
  <c-main-layout>
      <div class="teacher-search-page__container">
          <div class="teacher-search-page">
            <div class="teacher-search-page__title">221,440명의 과외 선생님이 있습니다.</div>
            <div class="d-flex teacher-search-page__search-container">
                <div>검색공간</div>
                <c-button class="flex-grow-0">검색</c-button>
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
    name: 'teacher-search-page'
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

}
</style>