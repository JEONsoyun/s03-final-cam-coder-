<template>
  <c-mypage-layout title="쪽지함">
    <div class="mypage-message-page">
      <div
        class="d-flex align-center mypage-message-page__box"
        v-for="(item, mi) in SAMPLE_DATA"
        :key="`item-${mi}`"
      >
        <div
          class="d-flex flex-grow-0 flex-shrink-0 mypage-message-page__profile"
          :style="`background-image:url(${item.profile})`"
        />
        <div class="d-flex flex-column" style="width:100%;height: 100%;">
          <div class="d-flex flex-grow-0">
            <div class="d-flex mypage-message-page__name">사용자이름</div>
            <div class="d-flex flex-grow-0 mypage-message-page__date">{{ item.sendDate }}</div>
          </div>
          <div class="d-flex mypage-message-page__content" style="margin-top: 4px;">
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
        content:
          'byebye',
        sender: 15,
        profile: '/static/images/user.png',
        receiver: 14,
        isRead: 0,
      },
    ],
  }),
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