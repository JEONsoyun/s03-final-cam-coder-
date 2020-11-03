<template>
  <div>
    <button style="margin-top: 24px" @click="onSendClick">메시지 보내기</button>
    <div>{{ teacher }}</div>
  </div>
</template>
<script>
export default {
  name: 'send-message-page',
  data: () => ({
    teacherId: 0,
    teacher: {},
    data: {
      content: 'hello',
      receiver: 'teacher0',
    },
  }),
  methods: {
    async onSendClick() {
      try {
        console.log(this.data);
        console.log(storagelocal);
        await this.$api.sendMessage(this.data, this.$store.state.config);
        alert('메시지 전송 성공');
      } catch (e) {
        alert('메시지 전송 실패.');
      }
    },
  },
  async created() {
    console.log(this.$store.storagelocal);
    this.teacherId = this.$route.params.userid;
    console.log(this.teacherId);
    if (this.teacherId == 0) {
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }
    console.dir(this.$store.state.config);
    try {
      console.log(this.teacherId);
      console.dir(this.$store.state.config);
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