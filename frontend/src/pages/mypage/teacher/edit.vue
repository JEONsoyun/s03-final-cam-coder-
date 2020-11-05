<template>
    <c-mypage-layout title="선생님 정보 수정"> 
      <button style="margin-top: 24px" @click="onUpdateTeacher">
        선생님 정보 수정하기
      </button>
    </c-mypage-layout>
</template>
<script>
export default {
  name: "mypage-teacher-edit-page",
  data: () => ({
    data: {
      intro: '재미있는 자료구조 수업입니다.',
      expertise: 'OO대학교에서 자료구조 수업을 A+로 완료하였습니다.',
      price: '10000',
      profile: 'profile',
      avaliableTime: 'every sunday',
    },
  }),
  methods: {
    async onUpdateTeacher() {
      try {
        console.log(this.$store.state.config);
        await this.$api.updateTeacher(this.data, this.$store.state.config);
        alert('정보변경 성공');
      } catch (e) {
        alert('정보변경 실패.');
      }
    },
  },
  async created() {
    //? 불러올 무언가 없다...
  },
};
</script>