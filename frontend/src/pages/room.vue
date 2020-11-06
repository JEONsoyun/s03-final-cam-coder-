<template>
  <div class="d-flex flex-column" style="width: 100%;height:100%">
      <div class="d-flex">
          <div class="d-flex room-page__contents-share"></div>
          <div class="d-flex flex-column flex-grow-1">
            <div class="d-flex flex-grow-1 flex-column room-page__code-editor">
                <div class="d-flex flex-grow-0">
                    <div class="d-flex"/>
                    <div>언어</div>
                </div>
                <div class="d-flex">editor</div>
                <div class="d-flex flex-grow-0">
                    <div class="d-flex"/>
                    <c-button class="flex-grow-0">run</c-button>
                </div>
            </div>
            <div class="d-flex flex-grow-1 room-page__console"></div>
          </div>
      </div>
      <div class="d-flex flex-grow-0 align-center justify-center room-page__footer">
          <template>
            <c-button v-if="true" class="flex-grow-0">콘텐츠 공유</c-button>
            <c-button v-if="false" class="flex-grow-0">콘텐츠 공유 종료</c-button>
          </template>
          <div class="d-flex" />
          <template>
              <div class="d-flex justify-center align-center flex-grow-0 room-page__circle">
                <v-icon v-if="true" color="white" size="28">mic_off</v-icon>
                <v-icon v-if="false" color="white" size="28">mic</v-icon>
              </div>
          </template>
          <div class="d-flex" />
          <div class="d-flex justify-center align-center flex-grow-0 room-page__circle">
            <v-icon color="white" size="28">close</v-icon>
          </div>

      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.room-page__contents-share {
    background: #eaeaea;
}

.room-page__code-editor {
    background:rgb(49, 35, 29);
    height:70%;
    padding: 16px;
    color: white;
    border-bottom: solid 1px #fff;
}

.room-page__console {
    background:rgb(49, 35, 29);
    height:30%;
    padding: 16px;
}

.room-page__footer {
    background:#eaeaea;
    height:70px;
    padding: 0 32px;
    border-top: solid 1px rgb(49, 35, 29);
}

.room-page__circle {
    width: 45px;
    height: 45px;
    border-radius: 50%;
    background: rgb(231, 0, 39);
    cursor: pointer;
}
</style>