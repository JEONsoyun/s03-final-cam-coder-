<template>
  <c-main-layout>
    <div class="review-page">
      <div class="d-flex align-center review-page__info">
        선생님의 수업 후기를 적어주세요!
      </div>
      <div class="review-page__textarea-container">
        <textarea style="width: 100%; height: 300px" v-model="content" />
      </div>
      <c-button @click="onPoistClick" type="gradient">리뷰 남기기</c-button>
    </div>
  </c-main-layout>
</template>
<script>
export default {
  name: 'review-page',
  data: () => ({
    tutoringId: 0,
    content: '',
  }),
  methods: {
    async onPoistClick() {
      try {
        console.log(this.$store.state.config);
        let data = {
          content: this.content,
          tutoring_code: this.tutoringId,
        };
        await this.$api.postReview(data, this.$store.state.config);
        alert('리뷰를 작성했습니다.');
        location.href = '/';
      } catch (e) {
        alert('리뷰 작성에 실패했습니다.');
        console.error(e);
      }
    },
  },
  async created() {
    this.tutoringId = this.$route.params.tutoringCode;
    console.log(this.tutoringId);
  },
};
</script>
<style>
.review-page {
  padding-top: 40px;
  width: 480px;
  margin: 0 auto;
}

.review-page__info {
  height: 74px;
  background: #fff;
  padding: 8px 16px;
  border: solid 1px #eaeaea;
  letter-spacing: -0.38px;
  font-weight: 600;
}

.review-page__profile {
  width: 36px;
  height: 36px;
  margin-right: 12px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
}

.review-page__name {
  font-size: 14px;
  font-weight: 800;
  color: #666;
}

.review-page__intro {
  margin-top: 2px;
  font-weight: 400;
  font-size: 12px;
  color: #999;
  line-height: 12px;
}

.review-page__textarea-container {
  width: 100%;
  padding: 16px;
  padding-bottom: 2px;
  margin-bottom: -4px;
  border-left: solid 1px #eaeaea;
  border-right: solid 1px #eaeaea;
  font-size: 14px;
  background: #fff;
}
</style>