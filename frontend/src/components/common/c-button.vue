<template>
  <div
    @click="onButtonClick"
    class="d-flex align-center justify-center c-button"
    :class="{
      'c-button__white': type == 'white',
      'c-button__gray': type == 'gray',
      'c-button__gradient': type == 'gradient',
      'c-button__small': size =='small',
      
    }"
  >
    <slot />
  </div>
</template>

<script>
export default {
  props: {
    text: '',
    type: '',
    size: '',
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
  background: #d2d2d2;
  color: #fff;
  font-weight: 800;
  letter-spacing: -0.16px;
  font-size: 16px;
  padding: 0 16px;
}

.c-button__gradient {
  height: 42px;
  border-radius: 6px;
  background: linear-gradient(to right, #EEA849, #F46B45);
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
</style>