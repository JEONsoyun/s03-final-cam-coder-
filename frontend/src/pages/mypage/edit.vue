<template>
  <div>
    <button style="margin-top: 24px" @click="onUpdateUser">
      유저정보 수정하기
    </button>
    <div>{{ user }}</div>
  </div>
</template>
<script>
export default {
  data: () => ({
    user: {},
    data: {
      id: '',
      pw: '',
      name: '',
      profile: '',
      pw_verification: '',
    },
  }),
  methods: {
    async onUpdateUser() {
      try {
        console.log(this.$store.state.config);
        await this.$api.updateUser(this.data, this.$store.state.config);
        alert('정보변경 성공');
      } catch (e) {
        alert('정보변경 실패.');
      }
    },
  },
  async created() {
    console.log(this.$store.state.config);
    try {
      this.user = await this.$api.getMe(this.$store.state.config);
      this.user = await this.$api.getMe(this.$store.state.config);
      this.data.id = this.user.userId;
      this.data.name = this.user.userName;
      this.data.profile = this.user.userProfile;
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>