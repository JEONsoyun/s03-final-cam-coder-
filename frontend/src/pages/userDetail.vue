<template>
  <div>
    {{ user.userCode }}
  </div>
</template>
<script>
export default {
  name: '',
  data: () => ({
    user: [],
  }),
  methods: {},
  async created() {
    console.log(this.$store.state.config);
    this.user = await this.$api.getMe(this.$store.state.config);
    console.dir(this.user);
  },
};
</script>
<style>
</style>