<template>
  <c-mypage-layout title="회원정보 수정">
    <div class="mypage-edit-page">
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">아이디</div>
        <v-text-field
          class="mypage-edit-page-input"
          v-model="user.userId"
          dense
          hide-details
          solo
          flat
          outlined
          readonly
        ></v-text-field>
      </div>
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">비밀번호</div>
        <v-text-field
          class="mypage-edit-page-input"
          v-model="user.pw"
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
          v-model="user.pw_verification"
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
          v-model="user.userName"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>
      <div class="d-flex align-center mypage-edit-page__row">
        <div class="mypage-edit-page__label">가입일자</div>
        <v-text-field
          class="mypage-edit-page-input"
          v-model="user.joinDate"
          dense
          hide-details
          solo
          flat
          outlined
        ></v-text-field>
      </div>      
      <c-button class="flex-grow-0" style="margin-top: 60px;" @click="onUpdateUser">수정하기</c-button>
    </div>
  </c-mypage-layout>
</template>
<script>
export default {
  data: () => ({
    name: "mypage-edit-page",
    user: {},
    data: {
      id: '',
      pw: '',
      name: '',
      profile: '',
      pw_verification: '',
    },
    "user": {
        "userCode": 3,
        "userId": "teacher0",
        "userPw": "1234",
        "userName": "야근이싫은개발자",
        "userProfile": null,
        "joinDate": "2020-10-27T01:46:43.000+00:00"
    },
  }),
  methods: {
    async onUpdateUser() {
      // try {
      //   console.log(this.$store.state.config);
      //   await this.$api.updateUser(this.data, this.$store.state.config);
      //   alert('정보변경 성공');
      // } catch (e) {
      //   alert('정보변경 실패.');
      // }
    },
  },
  async created() {
    // console.log(this.$store.state.config);
    // try {
    //   this.user = await this.$api.getMe(this.$store.state.config);
    //   this.user = await this.$api.getMe(this.$store.state.config);
    //   this.data.id = this.user.userId;
    //   this.data.name = this.user.userName;
    //   this.data.profile = this.user.userProfile;
    // } catch (e) {
    //   console.log('잘못된 접근입니다. 로딩 실패');
    // }
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
  border-color:  #fb8805 !important;
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