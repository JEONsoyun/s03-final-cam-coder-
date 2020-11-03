<template>
  <div>
    <div>{{ teacher }}</div>
  </div>
</template>
<script>
export default {
  name: 'teacher-detail-page',
  data: () => ({
    teacherId: 0,
    teacher: {},
  }),
  methods: {},
  async created() {
    this.teacherId = this.$route.params.id;
    console.log(this.teacherId);
    if (this.teacherId == 0) {
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }
    console.dir(this.$store.state.config);
    try {
      this.teacher = await this.$api.getTeacher(
        this.teacherId,
        this.$store.state.config
      );
    } catch (e) {
      console.log('선생님 로딩 실패');
    }
  },
};
</script>