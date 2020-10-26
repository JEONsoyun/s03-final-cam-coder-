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
  }),
  async beforeCreate() {
    // try {
    //   this.isLoggedIn = await this.$api.isLoggedIn();
    //   this.$store.commit('ISLOGGEDIN', this.isLoggedIn);
    // } catch (e) {
    //   this.isLoggedIn = false;
    //   this.$store.commit('ISLOGGEDIN', false);
    // }
    // if (this.isLoggedIn) {
    //   try {
    //     let {
    //       user: [user],
    //     } = await this.$api.getMe();
    //     this.$store.commit('USER', user);
    //   } catch (e) {
    //     if (!e || !e.response || e.response.status != 400) {
    //       console.error(e);
    //     }
    //     this.$store.commit('USER', {});
    //   }
    // }

    // window.$root = this;
  },
};
</script>

<style>
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
