<template>
  <c-mypage-layout title="쪽지함">
    <div class="mypage-message-page">
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
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-message-page',
  data: () => ({
    me: 15,
    messages: [],
    SAMPLE_DATA: [
      {
        messageCode: 13,
        sendDate: '2020-10-28T05:46:00.000+00:00',
        content: 'hello',
        sender: 15,
        profile: '/static/images/user.png',
        receiver: 3,
        isRead: 0,
      },
      {
        messageCode: 12,
        sendDate: '2020-10-28T05:45:02.000+00:00',
        content: 'byebye',
        sender: 15,
        profile: '/static/images/user.png',
        receiver: 14,
        isRead: 0,
      },
    ],
  }),
  methods: {
    onMessageClick(item) {
      let user;
      if (this.$store.state.USER.userCode == item.sender.userCode) {
        user = item.receiver;
      } else {
        user = item.sender;
      }
      console.log(user);
      this.$router.push(`/mypage/message/${user.userCode}`);
    },
  },
  async created() {
    //console.log(this.$store.state.config);
    try {
      let tmp = await this.$api.getMessage(this.$store.state.config);
      this.messages = tmp;
      console.log(this.messages);
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
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
  width: 48px;
  height: 48px;
  margin-right: 28px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
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