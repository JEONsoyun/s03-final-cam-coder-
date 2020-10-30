<template>
  <div>
    회원가입 <br />데이터 입력<br />
    <button @click="onJoinClick">가입버튼</button>
  </div>
</template>
<script>
export default {
  name: 'login-page',
  data: () => ({
    data: {
      id: 'studentbb',
      pw: 'passworda',
      name: 'namea',
      profile: 'i like math',
    },
  }),
  methods: {
    async onJoinClick() {
      try {
        await this.$api.signup(this.data);
        alert('가입완료.');
        location.href = '/';
      } catch (e) {
        alert('중복된 아이디입니다.');
      }
    },
  },
};
</script>
<style>
</style>