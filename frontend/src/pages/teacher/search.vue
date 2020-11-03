<template>
  <div>
    <div v-for="(teacher, ti) in teachers" :key="`teacher-${ti}`">
      <div>{{ teachers }}</div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'teacher-search-page',
  data: () => ({
    teachers: [],
    searchKey: {
      avaliableTime: '',
      expertise: '',
      intro: '',
      keywords: '',
      price: null,
      profile: '',
      sorttype: null,
    },
  }),
  methods: {
    async onSearchClick() {
      try {
        this.teachers = await this.$api.searchTeacher(this.searchKey);
      } catch (e) {
        console.log('선생님 로딩 실패');
      }
    },
  },
  async created() {
    try {
      this.teachers = await this.$api.searchTeacher(this.searchKey);
    } catch (e) {
      console.log('선생님 로딩 실패');
    }
  },
};
</script>