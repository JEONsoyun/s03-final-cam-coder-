<template>
  <c-mypage-layout title="나의 과외 현황">
    <div class="mypage-student-tutoring-page">
      <template v-if="tutorings != null && tutorings.length != 0">
        <div
          class="d-flex mypage-student-tutoring-page__box"
          v-for="(item, mi) in tutorings"
          :key="`item-${mi}`"
        >
          <div
            class="d-flex flex-grow-0 flex-shrink-0 mypage-student-tutoring-page__profile"
            :style="`background-image:url(${item.teacher.profile})`"
          />
          <div class="d-flex flex-column" style="width: 100%; height: 100%">
            <div class="d-flex">
              <div>
                <div
                  v-if="item.status == 0"
                  class="mypage-student-tutoring-page__tag mypage-student-tutoring-page__tag-0"
                >
                  수락
                </div>
                <div
                  v-if="item.status == 1"
                  class="mypage-student-tutoring-page__tag mypage-student-tutoring-page__tag-1"
                >
                  요청
                </div>
                <div
                  v-if="item.status == 2"
                  class="mypage-student-tutoring-page__tag mypage-student-tutoring-page__tag-2"
                >
                  완료
                </div>
                <div
                  v-if="item.status == 3"
                  class="mypage-student-tutoring-page__tag mypage-student-tutoring-page__tag-3"
                >
                  취소
                </div>
              </div>
              <div class="d-flex" />
            </div>
            <div class="d-flex flex-grow-0">
              <div class="d-flex mypage-student-tutoring-page__name">
                {{ item.teacher.user.userName }}
              </div>
              <div
                class="d-flex flex-grow-0 mypage-student-tutoring-page__date"
              >
                {{ $moment(item.requestDate).format('YYYY.MM.DD hh:mm') }}
              </div>
            </div>
            <div
              class="d-flex mypage-student-tutoring-page__content"
              style="margin-top: 4px"
            >
              과외 일자:
              {{ $moment(item.startDate).format('YYYY.MM.DD hh:mm') }} ~
              {{ $moment(item.endDate).format('YYYY.MM.DD hh:mm') }}
            </div>
            <div class="d-flex">
              <div class="d-flex" />
              <c-button
                @click="onStateClick(item)"
                v-if="getType(item)"
                :type="getType(item)"
                class="flex-grow-0"
              />
            </div>
          </div>
        </div>
      </template>
      <template v-else>
        <c-empty content="과외 데이터" />
      </template>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-student-tutoring-page',
  data: () => ({
    user: {},
    tutorings: [],
  }),
  methods: {
    getType(item) {
      if (item.status == 1) {
        return 'cancel';
      } else if (item.status == 0) {
        // TODO: 현재 날짜가 과외 날짜 안에 포함될 때 조건 걸기
        // 현재는 그냥 수락하면 다 방 입장하는걸로 되어있음
        return 'enter';
      } else {
        return '';
      }
    },
    async getTutoring() {
      try {
        this.tutorings = await this.$api.getStudentTutoring(
          this.$store.state.config
        );
      } catch (e) {
        console.error(e);
      }
    },
    async updateStatus(tutoringCode, data) {
      try {
        await this.$api.updateTutoring(
          tutoringCode,
          data,
          this.$store.state.config
        );
      } catch (e) {
        console.error(e);
      }
    },
    onStateClick(item) {
      if (item.status == 1) {
        if (!confirm('취소하시겠습니까?')) {
          return;
        }
        let data = {
          status: 3,
        };
        this.updateStatus(item.tutoringCode, data);
        this.getTutoring();
      } else if (item.status == 0) {
        if (confirm('입장하시겠습니까?')) {
          window.open(`/room?tutoringCode=${item.tutoringCode}`);
        }
      }
    },
  },
  async created() {
    await this.getTutoring();
    let today = this.$moment();
    for (let tutoring of this.tutorings) {
      if (tutoring.status == 2 || tutoring.status == 3) {
        continue;
      }
      if (
        today.isAfter(tutoring.endDate) &&
        today.isAfter(tutoring.startDate)
      ) {
        let data = {};
        if (tutoring.status == 1) {
          data.status = 3;
        } else if (tutoring.status == 0) {
          data.status = 2;
        }
        await this.updateStatus(tutoring.tutoringCode, data);
      }
    }
    this.getTutoring();
  },
};
</script>

<style>
.mypage-student-tutoring-page {
}

.mypage-student-tutoring-page__box {
  padding: 16px;
  border: solid 1px #eaeaea;
  border-bottom: none;
}

.mypage-student-tutoring-page__box:last-child {
  border-bottom: solid 1px #eaeaea;
}

.mypage-student-tutoring-page__profile {
  margin: 12px;
  width: 48px;
  height: 48px;
  margin-right: 28px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
}

.mypage-student-tutoring-page__tag {
  padding: 0 6px;
  font-size: 12px;
  letter-spacing: -0.32px;
  border-radius: 2px;
  border: solid 1px #333;
  margin-bottom: 8px;
  font-weight: 800;
}

.mypage-student-tutoring-page__tag-0 {
  color: rgb(18, 211, 0);
  border-color: rgb(18, 211, 0);
}

.mypage-student-tutoring-page__tag-1 {
  color: rgb(231, 189, 0);
  border-color: rgb(231, 189, 0);
}

.mypage-student-tutoring-page__tag-2 {
  color: rgb(0, 89, 255);
  border-color: rgb(0, 89, 255);
}

.mypage-student-tutoring-page__tag-3 {
  color: rgb(129, 129, 129);
  border-color: rgb(129, 129, 129);
}

.mypage-student-tutoring-page__name {
  font-weight: 800;
  font-size: 14px;
  color: #333;
}

.mypage-student-tutoring-page__date {
  font-size: 12px;
  color: #999;
}

.mypage-student-tutoring-page__content {
  letter-spacing: -0.32px;
  color: #555;
}
</style>