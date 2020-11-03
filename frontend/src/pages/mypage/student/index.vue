<template>
  <div>
    <div>{{ user }}</div>
  </div>
</template>
<script>
export default {
  name: 'teacher-detail-page',
  data: () => ({
    user: {},
  }),
  methods: {},
  async created() {
    console.log(this.$store.state.config);
    try {
      this.user = await this.$api.getMe(this.$store.state.config);
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>
