<template>
  <c-mypage-layout title="쪽지함">
    <div class="mypage-message-page">
      <template v-if="messages != null && messages.length != 0">
        <div
          @click="onMessageClick(item)"
          class="d-flex align-center mypage-message-page__box"
          v-for="(item, mi) in messages"
          :key="`item-${mi}`"
        >
          <div
            v-if="$store.state.USER.userCode == item.sender.userCode"
            class="d-flex flex-grow-0 flex-shrink-0 mypage-message-page__profile"
            :style="`background-image:url(${item.receiver.userProfile})`"
          />
          <div
            v-else
            class="d-flex flex-grow-0 flex-shrink-0 mypage-message-page__profile"
            :style="`background-image:url(${item.sender.userProfile})`"
          />
          <div class="d-flex flex-column" style="width: 100%; height: 100%">
            <div class="d-flex flex-grow-0">
              <div
                v-if="$store.state.USER.userCode == item.sender.userCode"
                class="d-flex mypage-message-page__name"
              >
                {{ item.receiver.userName }}
              </div>
              <div v-else class="d-flex mypage-message-page__name">
                {{ item.sender.userName }}
              </div>
              <div class="d-flex flex-grow-0 mypage-message-page__date">
                {{ $moment(item.sendDate).format('YYYY.MM.DD hh:mm') }}
              </div>
            </div>
            <div
              class="d-flex mypage-message-page__content"
              style="margin-top: 4px"
            >
              {{ item.content }}
            </div>
          </div>
        </div>
      </template>
      <template v-else>
        <c-empty content='받은 쪽지' />
      </template>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-message-page',
  data: () => ({
    me: 15,
    messages: [],
  }),
  methods: {
    onMessageClick(item) {
      let user;
      if (this.$store.state.USER.userCode == item.sender.userCode) {
        user = item.receiver;
      } else {
        user = item.sender;
      }
      this.$router.push(`/mypage/message/${user.userCode}`);
    },
  },
  async created() {
    try {
      let tmp = await this.$api.getMessage(this.$store.state.config);
      this.messages = tmp;
    } catch (e) {
      console.error(e);
    }
  },
};
</script>

<style>
.mypage-message-page {
}

.mypage-message-page__box {
  height: 110px;
  padding: 16px;
  border: solid 1px #eaeaea;
  border-bottom: none;
  cursor: pointer;
}

.mypage-message-page__box:last-child {
  border-bottom: solid 1px #eaeaea;
}

.mypage-message-page__profile {
  margin: 12px;
  height: 76px;
  width: 76px;
  margin-right: 16px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
  border: solid 1px #aaa;
}

.mypage-message-page__name {
  font-weight: 800;
  font-size: 14px;
  color: #333;
}

.mypage-message-page__date {
  font-size: 12px;
  color: #999;
}

.mypage-message-page__content {
}
</style>