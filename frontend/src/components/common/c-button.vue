<template>
  <div
    @click="onButtonClick"
    class="d-flex align-center justify-center c-button"
    :class="{
      'c-button__white': type == 'white',
      'c-button__gray': type == 'gray',
      'c-button__gradient': type == 'gradient',
      'c-button__small': size == 'small',
      'c-button__cancel': type == 'cancel',
      'c-button__accept': type == 'accept',
      'c-button__enter': type == 'enter',
    }"
  >
    <template v-if="type == 'cancel'">취소하기</template>
    <template v-if="type == 'accept'">수락하기</template>
    <template v-if="type == 'enter'">입장하기</template>
    <slot />
  </div>
</template>

<script>
export default {
  props: {
    type: { type: String, default: '' },
    size: { type: String, default: '' },
  },
  methods: {
    onButtonClick() {
      this.$emit('click');
    },
  },
};
</script>

<style>
.c-button {
  height: 42px;
  border-radius: 6px;
  background: #fb8805;
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
  cursor: pointer;
}

.c-button__white {
  height: 42px;
  border-radius: 6px;
  background: #fff;
  color: #fb8805;
  font-weight: 800;
  border: solid 1px #fb8805;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}

.c-button__gray {
  height: 42px;
  border-radius: 6px;
  background: #dfdfdf;
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}

.c-button__gradient {
  height: 42px;
  border-radius: 6px;
  background: linear-gradient(to right, #eea849, #f46b45);
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}

.c-button__small {
  height: 30px;
  font-size: 12px;
  padding: 0 12px;
}

.c-button__cancel {
  height: 42px;
  border-radius: 6px;
  background: #ff4040;
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}

.c-button__accept {
  height: 42px;
  border-radius: 6px;
  background: #11b849;
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}

.c-button__enter {
  height: 42px;
  border-radius: 6px;
  background: #4053ff;
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}
</style>