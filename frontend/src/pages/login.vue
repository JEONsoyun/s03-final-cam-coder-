<template>
  <c-main-layout>
    <div class="d-flex flex-column">
      <div class="login-page-top">
        <div class="login-page-text1">로그인이 필요합니다</div>
        <div class="login-page-text2">
          로그인을 통해 CamCoder의 과외 서비스를 이용해보세요!
        </div>
      </div>
      <div class="login-page-content">
        <div class="login-page-container">
          <div class="login-page-id">
            <v-text-field
              label="이메일 입력"
              v-model="data.id"
              single-line
              solo
              flat
              height="44px"
              hide-details
            ></v-text-field>
          </div>
          <div class="login-page-pwd">
            <v-text-field
              label="비밀번호 입력"
              v-model="data.pw"
              single-line
              solo
              flat
              height="44px"
              type="password"
              class="login-page-password"
              hide-details
            ></v-text-field>
          </div>
        </div>
        <c-button style="margin-top: 24px" @click="onLoginClick"
          >로그인</c-button
        >
        <c-button style="margin-top: 8px" type="white" @click="onSignupClick"
          >회원가입</c-button
        >
      </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {
  name: 'login-page',
  data: () => ({
    data: {
      id: '',
      pw: '',
    },
    user: {},
  }),
  methods: {
    async onLoginClick() {
      try {
        console.log(this.data);
        console.log(this.data.id);
        await this.$api.login(this.data).then((res) => {
          console.log(res.data);
          //console.log(res.data.token);
          this.$store.commit('SET_AUTHTOKEN', res.data.token);
          console.log(this.$store.state.AUTHTOKEN);
          console.log(this.$store.state.config);
          uploadUser();
        });

        // //this.$router.push('/user');
        // this.user = await this.$api.getMe(this.$store.state.config);
        // console.log(this.user);
        // this.$store.commit('USER', this.user);
        // this.$store.commit('ISLOGGEDIN', true);
        // alert('로그인 성공');
        // location.href = '/';
      } catch (e) {
        alert('아이디 또는 비밀번호를 확인해주세요.');
      }
    },
    onSignupClick() {
      this.$router.push('/signup');
    },
    async uploadUser() {
      console.log('UploadUser');
      try {
        this.user = await this.$api.getMe(this.$store.state.config);
        console.log(this.user);
        this.$store.commit('USER', this.user);
        this.$store.commit('ISLOGGEDIN', true);
        alert('로그인 성공');
        location.href = '/';
      } catch (e) {
        alert('유저부르기 실패');
      }
    },
  },
};
</script>

<style>
.login-page-top {
  width: 100%;
  height: 120px;
  padding-top: 1px;
  background-color: #e9e9e9;
}

.login-page-text1 {
  width: 100%;
  height: 20px;
  margin-top: 34px;
  font-size: 18px;
  font-weight: 800;
  line-height: 1;
  letter-spacing: -0.5px;
  text-align: center;
  color: #585858;
}
.login-page-text2 {
  width: 100%;
  height: 16px;
  margin-top: 16px;
  font-size: 14px;
  font-weight: 400;
  line-height: 1.29;
  letter-spacing: -0.28px;
  text-align: center;
  color: #585858;
}

.login-page-content {
  width: 420px;
  margin: 0 auto;
  padding: 0 16px;
}

.login-page-enter {
  height: 134px;
  width: 100%;
  margin-top: 24px;
}

.login-page-id {
  margin-bottom: 6px;
}

.login-page-pwd {
  margin-bottom: 24px;
}

.login-page-container .v-input__slot {
  height: 44px;
  width: 100% !important;
  padding-left: 12px;
  padding-right: 12px;
  padding-top: 0px;
  padding-bottom: 0px;
  border-radius: 6px;
  border: solid 1px #e1e1e1;
  background-color: #ffffff;
}

.login-page-container {
  padding-top: 24px;
  width: 100%;
}

.login-page-enter .v-text-field {
  font-weight: 400;
  font-size: 14px;
  letter-spacing: -0.39px;
  color: #c5c5c5;
}

.login-page-content .v-col .v-row {
  border-radius: 6px;
  border: solid 1px #e1e1e1;
  background-color: #ffffff;
}

.login-page-btns {
  margin-top: 0px;
}

.login-page-button {
  width: 100%;
  height: 44px;
  border-radius: 6px;
  border: solid 1px #ffd501;
  background-color: #ffd501;
  text-align: center;
  line-height: 44px;
  font-size: 16px;
  font-weight: 700;
  letter-spacing: -0.45px;
  color: #fff;
}

.login-page-create {
  width: 100%;
  height: 44px;
  border-radius: 6px;
  border: solid 1px #ffd501;
  background-color: #ffffff;
  margin-top: 6px;
  text-align: center;
  line-height: 44px;
  font-size: 16px;
  font-weight: 700;
  letter-spacing: -0.45px;
  color: #ffd501;
}

.login-page-find {
  margin-top: 16px;
  width: 100%;
  height: 16px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  flex-wrap: wrap;
}

.login-page-findid {
  width: 66px;
  height: 16px;
  font-size: 14px;
  font-weight: 700;
  line-height: 1.29;
  letter-spacing: -0.28px;
  text-align: left;
  color: #616161;
}

.login-page-findline {
  width: 2px;
  height: 16px;
  background-color: #e9e9e9;
  margin-left: 59px;
}

.login-page-findpwd {
  width: 78px;
  height: 16px;
  font-size: 14px;
  font-weight: 700;
  line-height: 1.29;
  letter-spacing: -0.28px;
  text-align: left;
  color: #616161;
  margin-left: 55px;
}

.s-header-layout-content {
  padding-top: 40px;
}

.login-page-password * {
  font-family: Arial, Helvetica, sans-serif !important;
}
</style>