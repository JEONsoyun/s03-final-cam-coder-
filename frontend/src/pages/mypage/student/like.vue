<template>
  <c-mypage-layout title="관심 선생님 목록">
    <div class="d-flex mypage-student-like-page__content">
      <template v-if="likes != null && likes.length != 0">
        <div
          v-for="(item, ti) in likes"
          :key="`teacher-${ti}`"
          class="d-flex flex-column mypage-student-like-page__item-container"
        >
          <div
            @click="$router.push(`/teacher/detail/${item.teacher.teacherCode}`)"
            class="d-flex flex-column mypage-student-like-page__item"
          >
            <div
              v-if="item.teacher.user.userProfile != null"
              class="d-flex flex-shrink-0 mypage-student-like-page__profile-image"
              :style="`background-image: url(${item.teacher.user.userProfile})`"
            />
            <div
              v-else
              class="d-flex flex-shrink-0 mypage-student-like-page__profile-image"
              :style="`background-image: url('/static/images/user.png')`"
            />
            <div
              class="d-flex flex-column mypage-student-like-page__item-content"
            >
              <div style="font-weight: 800">
                {{ item.teacher.user.userName }}
              </div>
              <div class="d-flex flex-grow-1 flex-column">
                <div class="ellipsis">{{ item.teacher.expertise }}</div>
              </div>
            </div>
          </div>
        </div>
      </template>
      <template v-else>
        <c-empty content="관심 설정한 선생님 데이터" style="width: 100%" />
      </template>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-student-like-page',
  data: () => ({
    user: {},
    likes: [],
  }),
  methods: {},
  async created() {
    try {
      this.likes = await this.$api.getLike(this.$store.state.config);
    } catch (e) {
      console.error(e);
    }
  },
};
</script>

<style>
.mypage-student-like-page__content {
  width: 728px;
  margin-top: -12px;
  flex-wrap: wrap;
}

.mypage-student-like-page__item-container {
  width: calc(100% / 3);
}

.mypage-student-like-page__item {
  margin: 12px;
  height: 250px;
  cursor: pointer;
  border: solid 1px #fb8805;
  border-radius: 8px;
  background: #fff;
  overflow: hidden;
}

.mypage-student-like-page__item:hover {
  box-shadow: 0 0 20px 4px rgb(0, 0, 0, 0.1);
  transition: all 0.3s;
}

.mypage-student-like-page__profile-image {
  width: 100%;
  height: 180px;
  background: #dfdfdf;
  background-size: cover;
  background-position: center center;
}

.mypage-student-like-page__item-content {
  height: 100%;
  padding: 12px 8px;
  font-size: 14px;
  letter-spacing: -0.38px;
}
</style>