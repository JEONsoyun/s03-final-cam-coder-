<template>
  <c-mypage-layout title="나의 수업 현황">
    <div class="mypage-teacher-tutoring-page">
      <template v-if="tutorings != null && tutorings != 0">
        <div
          class="d-flex mypage-teacher-tutoring-page__box"
          v-for="(item, mi) in tutorings"
          :key="`item-${mi}`"
        >
          <div
            v-if="item.student.userProfile != null"
            class="d-flex flex-grow-0 flex-shrink-0 mypage-teacher-tutoring-page__profile"
            :style="`background-image:url(${item.student.userProfile})`"
          />
          <div
            v-else
            class="d-flex flex-grow-0 flex-shrink-0 mypage-teacher-tutoring-page__profile"
            :style="`background-image:url('/static/images/user.png')`"
          />
          <div class="d-flex flex-column" style="width: 100%; height: 100%">
            <div class="d-flex">
              <div>
                <div
                  v-if="item.status == 0"
                  class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-0"
                >
                  수락
                </div>
                <div
                  v-if="item.status == 1"
                  class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-1"
                >
                  요청
                </div>
                <div
                  v-if="item.status == 2"
                  class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-2"
                >
                  완료
                </div>
                <div
                  v-if="item.status == 3"
                  class="mypage-teacher-tutoring-page__tag mypage-teacher-tutoring-page__tag-3"
                >
                  취소
                </div>
              </div>
              <div class="d-flex" />
            </div>
            <div class="d-flex flex-grow-0">
              <div class="d-flex mypage-teacher-tutoring-page__name">
                {{ item.student.userName }}
              </div>
              <div
                class="d-flex flex-grow-0 mypage-teacher-tutoring-page__date"
              >
                {{ $moment(item.requestDate).format('YYYY.MM.DD hh:mm') }}
              </div>
            </div>
            <div
              class="d-flex mypage-teacher-tutoring-page__content"
              style="margin-top: 4px"
            >
              과외 날짜:
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
              <c-button
                @click="onStateClick(item, 'cancel')"
                v-if="item.status == 1"
                type="cancel"
                class="flex-grow-0"
                style="margin-left: 8px"
              />
            </div>
          </div>
        </div>
      </template>
      <template v-else>
        <c-empty content="수업 데이터" />
      </template>
    </div>
  </c-mypage-layout>
</template>

<script>
export default {
  name: 'mypage-teacher-tutoring-page',
  data: () => ({
    user: {},
    tutorings: [],
  }),
  methods: {
    getType(item) {
      if (item.status == 1) {
        return 'accept';
      } else if (item.status == 0) {
        // TODO: 현재 날짜가 과외 날짜 안에 포함될 때 조건 걸기
        // 현재는 그냥 수락하면 다 방 입장하는걸로 되어있음
        return 'enter';
      } else {
        return '';
      }
    },
    async onStateClick(item, type) {
      console.log(item)
      if (item.status == 1) {
        if (type == 'cancel') {
          let data = {
            status: 3,
          };
          try {
            await this.$api.updateTutoring(
              item.tutoringCode,
              data,
              this.$store.state.config
            );
            alert('취소되었습니다');
            // console.log(this.$store.state.config);
            try {
              //this.user = await this.$api.getMe(this.$store.state.config);
              this.tutorings = await this.$api.getTeacherTutoring(
                this.$store.state.config
              );
            } catch (e) {
              console.log('잘못된 접근입니다. 로딩 실패');
            }
          } catch (e) {
            alert('취소 실패 ');
          }
        } else {
          let data = {
            status: 0,
          };
          try {
            await this.$api.updateTutoring(
              item.tutoringCode,
              data,
              this.$store.state.config
            );
            alert('수락되었습니다');
            try {
              this.tutorings = await this.$api.getTeacherTutoring(
                this.$store.state.config
              );
            } catch (e) {
              console.log('잘못된 접근입니다. 로딩 실패');
            }
          } catch (e) {
            alert('수락 실패 ');
          }
        }
      } else if (item.status == 0) {
        confirm('입장하시겠습니까?');
        window.open(`/room?tutoringCode=${item.tutoringCode}`);
      }
    },
  },
  async created() {
    try {
      this.tutorings = await this.$api.getTeacherTutoring(
        this.$store.state.config
      );
    } catch (e) {
      console.log('잘못된 접근입니다. 로딩 실패');
    }
  },
};
</script>

<style>
.mypage-teacher-tutoring-page {
}

.mypage-teacher-tutoring-page__box {
  padding: 16px;
  border: solid 1px #eaeaea;
  border-bottom: none;
}

.mypage-teacher-tutoring-page__box:last-child {
  border-bottom: solid 1px #eaeaea;
}

.mypage-teacher-tutoring-page__profile {
  margin: 12px;
  width: 48px;
  height: 48px;
  margin-right: 28px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
}

.mypage-teacher-tutoring-page__tag {
  padding: 0 6px;
  font-size: 12px;
  letter-spacing: -0.32px;
  border-radius: 2px;
  border: solid 1px #333;
  margin-bottom: 8px;
  font-weight: 800;
}

.mypage-teacher-tutoring-page__tag-0 {
  color: rgb(18, 211, 0);
  border-color: rgb(18, 211, 0);
}

.mypage-teacher-tutoring-page__tag-1 {
  color: rgb(231, 189, 0);
  border-color: rgb(231, 189, 0);
}

.mypage-teacher-tutoring-page__tag-2 {
  color: rgb(0, 89, 255);
  border-color: rgb(0, 89, 255);
}

.mypage-teacher-tutoring-page__tag-3 {
  color: rgb(129, 129, 129);
  border-color: rgb(129, 129, 129);
}

.mypage-teacher-tutoring-page__name {
  font-weight: 800;
  font-size: 14px;
  color: #333;
}

.mypage-teacher-tutoring-page__date {
  font-size: 12px;
  color: #999;
}

.mypage-teacher-tutoring-page__content {
  letter-spacing: -0.32px;
  color: #555;
}
</style>