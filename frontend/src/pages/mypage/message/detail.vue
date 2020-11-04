<template>
  <div>
    <div>{{ this.messages }}</div>
  </div>
</template>
<script>
export default {
  data: () => ({
    messages: [],
    anotherUser: '',
  }),
  methods: {},
  async created() {
    console.log(this.$store.state.config);
    try {
      this.anotherUser = this.$route.params.usercode;
      console.log(this.anotherUser);
      this.messages = await this.$api.getUserMessage(
        this.anotherUser,
        this.$store.state.config
      );
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>

<style>
</style>