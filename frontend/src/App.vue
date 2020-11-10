<template>
  <!-- <div id="app" v-if="isLoggedIn != null"> -->
  <div id="app">
    <router-view />
  </div>
</template>

<script>
// Login check
const prohibitedContextsBeforeLoggedIn = [/^\/info/];

export default {
  name: 'App',
  data: () => ({
    isLoggedIn: null,
    allowedBeforeLoggedInContext: [],
    user: {},
  }),
  async beforeCreate() {
    try {
      console.log('이거 실행되나?');
      this.user = await this.$api.getMe(this.$store.state.config);
      console.log('***', this.user);
      this.$store.commit('USER', this.user);
      this.$store.commit('ISLOGGEDIN', true);
    } catch (e) {
      this.isLoggedIn = null;
      this.$store.commit('ISLOGGEDIN', null);
      this.$store.commit('LOGOUT', null);
      if (!e || !e.response || e.response.status != 400) {
        console.error(e);
      }
      this.$store.commit('USER', {});
    }
    // window.$root = this;
  },
};
</script>

<style>
* {
  font-family: 'NanumSquareRound';
}

.v-overlay__scrim {
  z-index: 1000 !important;
}

span {
  margin: 0 !important;
}

.mobile-layout-container {
  width: 100%;
  background: #fbfbfb;
}

.mobile-layout {
  max-width: 640px;
  margin: 0 auto;
}
</style>
