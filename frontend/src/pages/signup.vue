<template>
  <div>
    login
    <button @click="onLoginClick">로그인</button>
    <button @click="onSignupClick">회원가입</button>
  </div>
</template>
<script>
export default {
  name: 'login-page',
  data: () => ({
    data: {
      id: 'studenta',
      pw: 'passworda',
    },
  }),
  methods: {
    async onLoginClick() {
      try {
        await this.$api.login(this.data);
        this.$store.commit('ISSKIP', true);
        location.href = '/';
      } catch (e) {
        alert('아이디 또는 비밀번호를 확인해주세요.');
      }
    },
    onSignupClick() {
      this.$router.push('/signup');
    },
  },
};
</script>
<style>
</style>