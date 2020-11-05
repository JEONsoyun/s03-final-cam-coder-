<template>
  <c-main-layout>
      <div class="teacher-search-page__container">
          <div class="teacher-search-page">
            <div class="teacher-search-page__title">221,440명의 과외 선생님이 있습니다.</div>
            <div class="d-flex teacher-search-page__search-container">
            <v-text-field
              class="teacher-search-page-input"
              dense
              hide-details
              solo
              flat
              outlined
              label="키워드를 입력해주세요."
              @keydown.enter="onSearchClick"
            ></v-text-field>
            <c-button class="flex-grow-0" style="width:80px;">검색</c-button>
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
  data: () => ({
    teachers: [],
    searchKey: {
      avaliableTime: '',
      expertise: '',
      intro: '',
      keywords: '',
      price: null,
      profile: '',
      sorttype: null,
    },
  }),
  methods: {
    async onSearchClick() {
      try {
        this.teachers = await this.$api.searchTeacher(this.searchKey);
      } catch (e) {
        console.log('선생님 로딩 실패');
      }
    },
  },
  async created() {
    try {
      this.teachers = await this.$api.searchTeacher(this.searchKey);
    } catch (e) {
      console.log('선생님 로딩 실패');
    }
  },
};
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

.teacher-search-page-input input {
  padding: 0 !important;
}
.teacher-search-page-input .v-input__control {
  height: 42px !important;
}

.teacher-search-page-input .v-text-field__slot {
  height: 42px;
  font-size: 14px;
  color: #8a8a8a !important;
}
.teacher-search-page-input fieldset {
  border-color:  #fb8805 !important;
  height: 46px;
}
</style>
