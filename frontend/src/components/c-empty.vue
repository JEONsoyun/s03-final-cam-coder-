<template>
  <div class="d-flex flex-column justify-center align-center c-empty">
    <img class="c-empty__image" src="/static/images/empty.png" />
    <div class="c-empty__text">{{ content }}가 없습니다.</div>
  </div>
</template>

<script>
export default {
  name: 'c-empty',
  props: {
    content: { type: String, default: '데이터' },
  },
};
</script>

<style>
.c-empty {
    padding: 32px 0;
}

.c-empty__image {
  width: 220px;
  opacity: 0.4;
}

.c-empty__text {
  margin-top: 40px;
  letter-spacing: -0.48px;
  font-size: 18px;
  font-weight: 600;
  color: #666;
}
</style>