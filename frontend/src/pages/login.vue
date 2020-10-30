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
      name: 'namea',
      profile: 'i like math',
    },
  }),
  methods: {
    async onLoginClick() {
      try {
        //console.log(this.data);
        //console.log(this.data.id);
        await this.$api.login(this.data).then((res) => {
          //console.log(res.data);
          //console.log(res.data.token);
          this.$store.commit('SET_AUTHTOKEN', res.data.token);
          console.log(this.$store.state.AUTHTOKEN);
          //console.log(this.$store.state.config);
        });
        alert('로그인 성공');
        //location.href = '/';
        this.$router.push('/user');
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