<template>
  <v-dialog
    content-class="c-dialog"
    v-model="active"
    :overlay-opacity="0.75"
    width="500"
    @click:outside="onClick(false)"
  >
    <v-card>
      <v-card-text>

      </v-card-text>
      <v-card-actions>
        <c-button @click="onClick(false)" type="white">취소</c-button>
        <c-button @click="onPostClick" style="margin-left: 8px;">신청</c-button>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'c-dialog',
  props: {
    type: { type: String, default: 'alert' },
    content: String,
  },
  data: () => ({
    active: true,
  }),
  methods: {
    onClick(e) {
      this.active = false;
      this.$emit('click2', e);
    },
    onPostClick() {
      // TODO: axios
    },
  },
};
</script>

<style scoped>
.c-dialog {
}

</style>
