<template>
  <c-main-layout background="white">
    <div class="teacher-detail-page__container">
      <div class="teacher-detail-page">
        <div class="teacher-detail-page__right">
          <div class="d-flex teacher-detail-page__right-content">
            <div class="d-flex" />
            <div
              class="d-flex flex-column flex-grow-0 flex-shrink-0 teacher-detail-page__right-box"
            >
              <div
                class="d-flex flex-column flex-grow-1 justify-center align-center"
              >
                <div>
                  <span style="color: #fb8805; font-weight: 800">{{
                    teacher.user && teacher.user.userName
                  }}</span>
                  <span>선생님에게</span>
                </div>
                <div>원하는 수업에 대해 문의해보세요!</div>
              </div>
              <c-button
                @click="onMessageClick"
                class="flex-grow-0"
                type="gradient"
                style="margin-bottom: 8px"
                >문의하기</c-button
              >
              <c-button
                @click="onTutoringClick"
                @click2="isFormVisible = false"
                class="flex-grow-0"
                type="white"
                >과외 신청하기</c-button
              >
              <v-dialog
                style="z-index: 9999"
                content-class="teacher-detail-page__dialog"
                v-model="isFormVisible"
                :overlay-opacity="0.75"
                width="500"
                @click:outside="isFormVisible = false"
              >
                <v-card>
                  <div
                    class="d-flex justify-center teacher-detail-page__dialog-content"
                  >
                    {{ teacher.user && teacher.user.userName }} 선생님에게 과외
                    신청합니다.
                  </div>
                  <div class="d-flex justify-center" style="margin-top: 32px">
                    <v-date-picker
                      class="s-tour-search-date-picker"
                      v-model="dates"
                      range
                      no-title
                      :day-format="(d) => $moment(d).format('D')"
                    >
                      <v-spacer></v-spacer>
                    </v-date-picker>
                  </div>
                  <div
                    class="d-flex justify-center"
                    style="
                      padding: 32px 0 8px 0;
                      font-size: 18px;
                      border-top: solid 1px #fb8805;
                    "
                  ></div>
                  <div
                    class="d-flex justify-center"
                    style="
                      margin-bottom: 32px;
                      font-weight: 800;
                      font-size: 18px;
                    "
                  >
                    {{ dates[0] ? dates[0] : '과외 날짜를 선택해주세요.'
                    }}{{ dates[1] ? ' ~ ' + dates[1] : '' }}
                  </div>
                  <v-card-actions>
                    <c-button @click="onCancelClick" type="white"
                      >취소</c-button
                    >
                    <c-button @click="onPostClick" style="margin-left: 8px"
                      >신청</c-button
                    >
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </div>
          </div>
        </div>
        <div class="d-flex teacher-detail-page__box">
          <div
            v-if="teacher.profile != null"
            class="d-flex flex-grow-0 flex-shrink-0 teacher-detail-page__profile"
            :style="`background-image:url(${teacher.profile})`"
          />
          <div
            v-else
            class="d-flex flex-grow-0 flex-shrink-0 teacher-detail-page__profile"
            :style="`background-image:url('/static/images/user.png')`"
          />
          <div class="d-flex flex-column teacher-detail-page__intro">
            <div class="d-flex">
              <div style="font-weight: 800; font-size: 24px">
                {{ teacher.user && teacher.user.userName }}
              </div>
              <div class="d-flex" />
              <div @click="onFavoriteClick" style="cursor: pointer">
                <v-icon v-if="isSelected" size="36" color="#fb8805"
                  >favorite</v-icon
                >
                <v-icon v-else size="36" color="#fb8805"
                  >favorite_border</v-icon
                >
              </div>
            </div>
            <div class="d-flex">{{ teacher.expertise }}</div>
            <div class="d-flex" v-html="teacher.avaliableTime"></div>
            <div class="d-flex flex-grow-0" style="font-weight: 800">
              <div class="d-flex flex-grow-0 align-center">
                <v-icon color="#ff4a62" style="margin-right: 2px"
                  >favorite</v-icon
                >
                {{ teacher.likeCnt }}
              </div>
              <div class="d-flex" />
              <div class="d-flex flex-grow-0 align-center">
                <v-icon color="#4e41ff" style="margin-right: 2px"
                  >account_circle</v-icon
                >
                {{ teacher.studentCnt }}
              </div>
            </div>
          </div>
        </div>
        <div class="teacher-detail-page__content">
          <div style="font-weight: 800; font-size: 18px">선생님 소개</div>
          <div
            class="teacher-detail-page__content-box"
            v-html="teacher.intro"
          ></div>
          <div style="font-weight: 800; font-size: 18px; margin: 40px 0 20px 0">
            선생님 리뷰
          </div>
          <template v-if="reviews != null && reviews.length != 0">
            <div
              class="teacher-detail-page__review"
              v-for="(item, ri) in reviews"
              :key="`review-${ri}`"
            >
              <div class="d-flex align-center">
                <div
                  v-if="teacher"
                  class="d-flex flex-grow-0 flex-shrink-0 teacher-detail-page__review-profile"
                  :style="`background-image:url(${item.student.userProfile})`"
                />
                <div style="font-weight: 800; font-size: 18px">
                  {{ item.student.userId }}
                </div>
                <div class="d-flex" />
                <div style="color: #666; font-size: 14px">
                  {{ $moment(item.evaluationDate).format('YYYY.MM.DD hh:mm') }}
                </div>
              </div>
              <div class="teacher-detail-page__review-text">
                {{ item.evaluationContent }}
              </div>
            </div>
          </template>
          <template v-else>
            <c-empty content="작성된 리뷰" />
          </template>
        </div>
      </div>
    </div>
  </c-main-layout>
</template>

<script>
export default {
  name: 'teacher-detail-page',
  data: () => ({
    teacherId: 0,
    teacher: {},
    reviews: [],
    isSelected: false,
    isFormVisible: false,
    formdata: {},
    dates: [],
    tutoringData: {
      start: '',
      end: '',
      teacher_code: this.teacherId,
    },
  }),
  methods: {
    async onFavoriteClick() {
      try {
        let data = {
          teacher: this.teacher.teacherCode,
        };
        let result = await this.$api.postLike(data, this.$store.state.config);

        this.isSelected = !this.isSelected;
        if (this.isSelected) {
          this.teacher.likeCnt += 1;
        } else {
          this.teacher.likeCnt -= 1;
        }
      } catch (e) {
        alert('잘못된 접근입니다.');
      }
    },
    onMessageClick() {
      this.$router.push(`/teacher/send-message/${this.teacherId}`);
    },
    onTutoringClick() {
      this.isFormVisible = true;
    },
    onCancelClick() {
      this.isFormVisible = false;
      this.dates = [];
    },
    async onPostClick() {
      this.isFormVisible = false;
      // TODO: 과외 신청 보내는 api
      this.tutoringData.start = this.dates[0];
      this.tutoringData.end = this.dates[1];
      this.tutoringData.teacher_code = this.teacherId;
      try {
        await this.$api.postTutoring(
          this.tutoringData,
          this.$store.state.config
        );
        alert('과외를 신청했습니다.');
        this.$router.push('/mypage/student/tutoring');
      } catch (e) {
        alert('과외 요청을 실패했습니다.');
      }
      this.dates = [];
    },
  },
  async created() {
    this.teacherId = this.$route.params.id;
    if (this.teacherId == 0) {
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }
    console.dir(this.$store.state.config);
    try {
      this.teacher = await this.$api.getTeacher(
        this.teacherId,
        this.$store.state.config
      );
    } catch (e) {
      console.error(e);
      alert('잘못된 접근입니다.');
      this.$router.push('/');
    }

    try {
      this.isSelected = await this.$api.isLike(
        this.teacherId,
        this.$store.state.config
      );
    } catch (e) {
      console.error(e);
    }
    try {
      this.reviews = await this.$api.getTeacherReview(
        this.teacherId,
        this.$store.state.config
      );
    } catch (e) {
      console.error(e);
    }
  },
};
</script>

<style>
.teacher-detail-page__container {
  padding: 32px 0;
  width: 1024px;
  margin: 0 auto;
}

.teacher-detail-page {
  width: 700px;
}

.teacher-detail-page__box {
  width: 100%;
  height: 246px;
}

.teacher-detail-page__profile {
  width: 246px;
  height: 100%;
  background-size: cover;
  background-position: center center;
}

.teacher-detail-page__intro {
  width: 100%;
  padding: 32px;
  border: solid 1px #eaeaea;
}

.teacher-detail-page__right {
  height: 246px;
  width: 100%;
  position: fixed;
  top: 107px;
  left: 0;
  font-size: 16px;
  color: #333;
  font-weight: 600;
  letter-spacing: -0.48px;
}

.teacher-detail-page__right-content {
  width: 1024px;
  height: 100%;
  margin: 0 auto;
}

.teacher-detail-page__right-box {
  padding: 16px;
  width: 300px;
  height: 100%;
  border: solid 1px #eaeaea;
  z-index: 2;
  background: #fff;
}

.teacher-detail-page__content {
  padding-top: 40px;
  letter-spacing: -0.38px;
}

.teacher-detail-page__content-box {
  margin-top: 16px;
  padding: 32px;
  background: rgb(250, 250, 250);
}

.teacher-detail-page__review {
  margin-bottom: 16px;
  padding: 32px;
  letter-spacing: -0.48px;
  border-radius: 10px;
  background: #fff1e2;
}

.teacher-detail-page__review-profile {
  width: 36px;
  height: 36px;
  margin-right: 12px;
  border-radius: 50%;
  background-size: cover;
  background-position: center center;
  border: solid 1px #ccc;
}

.teacher-detail-page__review-text {
  margin-top: 12px;
  padding: 0 47px;
}

.teacher-detail-page__dialog {
  font-size: 14px;
  font-weight: 600;
  color: #333 !important;
}

.teacher-detail-page__dialog-content {
  padding: 32px 16px;
  font-size: 18px;
  letter-spacing: -0.48px;
}

.teacher-detail-page__dialog-headline {
  color: #fb8805;
  font-size: 18px;
  margin-left: 4px;
}
</style>
