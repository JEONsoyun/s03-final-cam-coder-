<template>
  <c-mypage-layout title="회원정보 수정">
    <div class="mypage-edit-page">
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">아이디</div>
        {{ data.userId }}
      </div>
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">비밀번호</div>
        <v-text-field
          class="mypage-edit-page-input"
          v-model="data.pw"
          type="password"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">비밀번호 확인</div>
        <v-text-field
          class="mypage-edit-page-input"
          v-model="data.pw_verification"
          type="password"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">이름</div>
        <v-text-field
          class="mypage-edit-page-input"
          v-model="data.userName"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">가입일자</div>
        {{ $moment(data.joinDate).format('YYYY-MM-DD hh:mm') }}
      </div>
      <c-button
        class="flex-grow-0"
        style="margin-top: 60px"
        @click="onUpdateUser"
        >수정하기</c-button
      >
    </div>
  </c-mypage-layout>
</template>
<script>
export default {
  name: 'mypage-edit-page',
  data: () => ({
    data: {},
  }),
  methods: {
    async getMe() {
      try {
        let user = await this.$api.getMe(this.$store.state.config);
        this.data = user;
      } catch (e) {
        console.error(e);
      }
    },
    async onUpdateUser() {
      if (this.data.pw != this.data.pw_verification) {
        alert('비밀번호가 일치하지 않습니다.');
        this.data.pw = null;
        this.data.pw_verification = null;
        return;
      }

      try {
        console.log(this.$store.state.config);
        let user = {};
        if (this.data.pw != null) {
          user.pw = this.data.pw;
        }
        user.name = this.data.userName;
        console.log(user);
        await this.$api.updateUser(user, this.$store.state.config);
        alert('회원 정보를 변경했습니다.');
      } catch (e) {
        alert('정보 수정 중 오류가 발생했습니다.');
      }

      location.reload();
    },
  },
  async created() {
    await this.getMe();
    console.log(this.data);
  },
};
</script>
<style>
.mypage-edit-page {
  width: 400px;
  margin: 0 auto;
}
.mypage-edit-page-input input {
  padding: 0 !important;
}
.mypage-edit-page-input .v-input__control {
  height: 42px !important;
}

.mypage-edit-page-input .v-text-field__slot {
  height: 42px;
  font-size: 14px;
  color: #8a8a8a !important;
}
.mypage-edit-page-input fieldset {
  border-color: #fb8805 !important;
  height: 46px;
}

.mypage-edit-page__row {
  margin-bottom: 16px;
}

.mypage-edit-page__label {
  margin-right: 16px;
  width: 104px;
}
</style>