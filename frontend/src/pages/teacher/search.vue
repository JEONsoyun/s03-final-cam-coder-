<template>
  <c-main-layout>
    <div class="teacher-search-page__container">
      <div class="teacher-search-page">
        <div class="teacher-search-page__title">
          221,440명의 과외 선생님이 있습니다.
        </div>
        <div class="d-flex teacher-search-page__search-container">
          <v-text-field
            class="teacher-search-page-input"
            dense
            hide-details
            solo
            flat
            outlined
            label="키워드를 입력해주세요."
            v-model="keyword"
            @keydown.enter="onSearchClick(keyword)"
          ></v-text-field>
          <c-button
            @click="onSearchClick"
            type="gradient"
            class="flex-grow-0"
            style="width: 80px"
            >검색</c-button
          >
        </div>
        <div class="d-flex teacher-search-page__content">
          <div
            v-for="(item, ti) in teachers"
            :key="`teacher-${ti}`"
            class="d-flex flex-column teacher-search-page__item-container"
          >
            <div
              class="d-flex flex-column teacher-search-page__item"
              @click="onItemClick(item)"
            >
              <div
                v-if="item.user.userProfile != null"
                class="d-flex flex-shrink-0 teacher-search-page__profile-image"
                :style="`background-image: url(${
                  item.user ? item.user.userProfile : '/static/images/user.png'
                })`"
              />
              <div
                v-else
                class="d-flex flex-shrink-0 teacher-search-page__profile-image"
                :style="`background-image: url('/static/images/user.png')`"
              />
              <div class="d-flex flex-column teacher-search-page__item-content">
                <div style="font-weight: 800">
                  {{ item.user ? item.user.userName : '' }}
                </div>
                <div
                  class="d-flex flex-grow-1 flex-column"
                  style="height: 90px"
                >
                  <div class="ellipsis" style="margin: 8px 0">
                    {{ item.expertise }}
                  </div>
                  <div v-html="item.avaliableTime" class="ellipsis" />
                </div>
                <div class="d-flex teacher-search-page__item-bottom">
                  <div class="d-flex flex-grow-0 align-center">
                    <v-icon color="#ff4a62" style="margin-right: 2px"
                      >favorite</v-icon
                    >
                    {{ item.likeCnt }}
                  </div>
                  <div class="d-flex" />
                  <div class="d-flex flex-grow-0 align-center">
                    <v-icon color="#4e41ff" style="margin-right: 2px"
                      >account_circle</v-icon
                    >
                    {{ item.studentCnt }}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="teacher-search-page__more">
          <c-button @click="onMoreClick" type="gradient">더 불러오기</c-button>
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
    // searchKey: {
    //   avaliableTime: '',
    //   expertise: '',
    //   intro: '',
    //   keywords: '',
    //   price: null,
    //   profile: '',
    //   sorttype: null,
    // },
    keyword: '',
    data: {
      keywords: '',
    },
  }),
  methods: {
    async onSearchClick(keyword) {
      try {
        let data = {
          keywords: this.keyword,
        };
        console.log(data);
        let tmp = await this.$api.searchTeacher(data, this.$store.state.config);
        this.teachers = tmp.data;
      } catch (e) {
        console.error(e);
      }
    },
    onMoreClick() {
      alert('더 불러올 데이터가 없습니다.');
    },
    onItemClick(item) {
      this.$router.push(`/teacher/detail/${item.teacherCode}`);
    },
  },
  async created() {
    try {
      this.teachers = await this.$api.sortTeacher(
        {
          keywords: this.keyword,
        },

        this.$store.state.config
      );
    } catch (e) {
      console.error(e);
    }
  },
};
</script>

<style>
.teacher-search-page__container {
  padding: 40px 0 0 0;
  width: 100%;
}

.teacher-search-page {
  width: 1024px;
  margin: 0 auto;
}

.teacher-search-page__title {
  color: #525252;
  font-size: 18px;
  font-weight: 600;
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
  border-color: #fb8805 !important;
  height: 46px;
}

.teacher-search-page__content {
  margin-top: 40px;
  flex-wrap: wrap;
}

.teacher-search-page__item-container {
  width: 25%;
}

.teacher-search-page__item {
  margin: 24px 12px;
  height: 350px;
  cursor: pointer;
  border: solid 1px #fb8805;
  border-radius: 8px;
  background: #fff;
  overflow: hidden;
}

.teacher-search-page__item:hover {
  box-shadow: 0 0 20px 4px rgb(0, 0, 0, 0.1);
  transition: all 0.3s;
}

.teacher-search-page__profile-image {
  width: 100%;
  height: 180px;
  background-size: cover;
  background-position: center center;
  border-bottom: solid 1px #fb8805;
}

.teacher-search-page__item-content {
  height: 100%;
  padding: 12px 8px;
  font-size: 14px;
  letter-spacing: -0.38px;
}

.teacher-search-page__item-bottom {
  margin-top: 8px;
  font-weight: 800;
}

.teacher-search-page__more {
  margin-top: 40px;
}
</style>
