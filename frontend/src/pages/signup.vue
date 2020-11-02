<template>
  <c-main-layout title="회원가입" noArrow>
    <div class="signup-page">
        <div class="signup-page-top">
            <div class="signup-page-text1">회원가입</div>
            <div class="signup-page-text2">간단한 회원가입을 통해 CamCoder의 과외 서비스를 이용해보세요!</div>
        </div>
        <div class="signup-page__container">
        <div class="signup-page-title">이름</div>
            <v-text-field
                v-model="data.user_name"
                placeholder="이름 입력"
                class="signup-page-box"
                dense
                required
                hide-details
                outlined
            ></v-text-field>
            <div class="signup-page-title">이메일 (ID)</div>
            <v-text-field
                v-model="data.user_email"
                placeholder="이메일 입력 (예: introdogs@introdogs.com)"
                class="signup-page-box"
                dense
                required
                hide-details
                outlined
            ></v-text-field>
            <div class="signup-page-title">비밀번호</div>
            <v-text-field
                type="password"
                class="signup-page-box"
                v-model="data.user_password"
                dense
                hide-details
                required
                placeholder="비밀번호 입력 (8자 이상의 영문,특수문자를 조합)"
                counter
                outlined
            ></v-text-field>
            <div class="signup-page-title">비밀번호 확인</div>
            <v-text-field
                class="signup-page-box"
                type="password"
                placeholder="비밀번호 확인"
                v-model="data.user_password_verification"
                dense
                required
                hide-details
                outlined
            ></v-text-field>

            <c-button style="margin-top: 24px" @click="onSignupClick"
                >완료</c-button
            >
        </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {
  name: 'signup-page',
  data: () => ({
    data: {},
  }),
  methods: {
    async onSignupClick() {
    //   try {
    //     const user_name = this.data.user_name;
    //     const user_email = this.data.user_email;
    //     const user_password = this.data.user_password;
    //     const user_password_verification = this.data.user_password_verification;

    //     // 0. 이름 체크
    //     if (!user_name || user_name.trim().length == 0) {
    //       return alert('이름을 입력해주세요.');
    //     }

    //     // 1. 이메일 체크
    //     if (!user_email || user_email.trim().length == 0) {
    //       return alert('이메일 주소를 입력해주세요.');
    //     }

    //     // 2. 이름 체크
    //     if (!user_name || user_name.trim().length == 0) {
    //       return alert('이름을 입력해주세요.');
    //     }

    //     // 3. 비밀번호 체크
    //     if (!user_password || user_password.trim().length == 0) {
    //       return alert('비밀번호를 입력해주세요.');
    //     }

    //     if (user_password != user_password_verification) {
    //       return alert('비밀번호가 일치하지 않습니다.');
    //     }

    //     await this.$api.signup({
    //       user_email,
    //       user_password,
    //       user_name,
    //       user_profile: "",
    //       match_dog: "",
    //       same_dog: ""
    //     });

    //     alert("회원가입이 완료되었습니다.");
    //     this.$router.push('/login');
    //   } catch (e) {
    //     console.error(e);
    //     alert('회원가입 중 문제가 발생하였습니다.');
    //   }
    },
  },
};
</script>

<style>
.signup-page {
    width: 100%;
}

.signup-page-top {
  width: 100%;
  height: 120px;
  padding-top: 1px;
  background-color: #e9e9e9;
}

.signup-page-text1 {
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

.signup-page-text2 {
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

.signup-page__container {
    width: 420px;
    margin: 0 auto;
}

.signup-page-title {
  width: 80%;
  height: 16px;
  font-size: 14px;
  font-weight: 400;
  letter-spacing: -0.39px;
  color: #616161;
  margin-bottom: 10px;
  margin-top: 25px;
  margin-left: 8px;
}

.signup-page .v-text-field input {
  font-family: Binggrae;
}

.signup-page-password {
  width: 100%;
  height: 44px;
  border-radius: 4px;
  border: solid 1px #e1e1e1;
  background-color: #ffffff;
  margin-bottom: 18px;
  padding-left: 12px;
  font-size: 14px;
  letter-spacing: -0.39px;
  text-align: left;
  color: #1e1e1e;
}
.signup-page .v-label theme--light {
  font-size: 14px;
  color: #616161;
  font-weight: 400;
}

.signup-page-box input {
  padding: 0 !important;
}

.signup-page-box .v-input__control {
  height: 44px !important;
}

.signup-page-box .v-text-field__slot {
  height: 44px;
  font-size: 14px;
  color: #8a8a8a !important;
}
.signup-page-box fieldset {
  border-color: #e1e1e1 !important;
  height: 48px;
  background: #fff;
}
</style>
