import axios from 'axios'

const baseURL = '/api'

export default {
    async login(data) {
        
        return (await axios.post(`${baseURL}/users/login/`, data))
    },
    async logout() {
        return (await axios.post(`${baseURL}/users/logout/`))
    },
    async isLoggedIn() {
        return (await axios.get(`${baseURL}/users/islogin/`)).data
    },
    async getMe() {
        return (await axios.get(`${baseURL}/users/mypage/`)).data
    },
    async signup(data) {
        return (await axios.post(`${baseURL}/users/signup/`, data))
    },
    //이거 accounts 붙이는 건가 아닌건가 모르겠네
    // teacher api 
    async updateTeacher(data){
        return (await axios.update(`${baseURL}/teachers/${data.user_id}`),data)
    },
    async deleteTeacher(user_id){
        return (await axios.delete(`${baseURL}/teachers/${data.user_id}`))
    },
    async postTeacher(data){
        return (await axios.post(`${baseURL}/teachers`, data))
    },
    async getTeacher(teacher_code) {
        return (await axios.get(`${baseURL}/teachers/${teacher_code}`)).data
    },
    async sortTeacher(data){
        return (await axios.post(`${baseURL}/teachers/sorted`, data)).data
    },
    async searchTeacher(data){
        return (await axios.post(`${baseURL}/teachers/search`, data)).data
    },
    // Tutorings api
    async postTutoring(data){
        return (await axios.post(`${baseURL}/tutorings`, data))
    },
    async getUserTutoring(){
        return (await axios.get(`${baseURL}/tutorings`)).data
    },
    async getTutoring(tutorings_id){
        return  (await axios.get(`${baseURL}/tutorings/${tutorings_id}`)).data
    },
    async updateTutoring(data){
        return  (await axios.update(`${baseURL}/tutorings/${data.tutorings_id}`)).data
    },
    // like api 
    async postLike(data){
        return  (await axios.post(`${baseURL}/likes`,data))
    },
    async getLike(){
        return  (await axios.get(`${baseURL}/likes`)).data
    },
    async deleteLike(like_id){
        return  (await axios.delete(`${baseURL}/likes/${like_id}`))
    },
    // review api
    async postReview(data){
        return  (await axios.post(`${baseURL}/reviews`,data))
    },
    async getReview(){
        return  (await axios.get(`${baseURL}/reviews`)).data
    },
    async deleteReview(review_id){
        return  (await axios.delete(`${baseURL}/reviews/${review_id}`))
    },
    async updateReview(data){
        return  (await axios.delete(`${baseURL}/reviews`,data))
    },
    //mesage api
    async sendMessage(data){
        return  (await axios.post(`${baseURL}/messages`,data))
    },
    async getMessage(){
        return  (await axios.get(`${baseURL}/messages`)).data
    },
    async getUserMessage(user_id){
        return  (await axios.get(`${baseURL}/messages/${user_id}`)).data
    },
}