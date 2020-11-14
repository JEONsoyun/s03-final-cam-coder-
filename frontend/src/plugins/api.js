import axios from 'axios'


const baseURL = '/api'

export default {
    async login(data) {
        return (await axios.post(`${baseURL}/users/login`, data))
    },
    async logout(config) {
        return (await axios.post(`${baseURL}/users/logout`, config))
    },
    async isLoggedIn() {
        return (await axios.get(`${baseURL}/users/islogin`)).data
    },
    async getMe(config) {
        return (await axios.get(`${baseURL}/users`, config)).data
    },
    async signup(data) {
        return (await axios.post(`${baseURL}/users/signup`, data))
    },
    async updateUser(data, config) {
        return (await axios.put(`${baseURL}/users`, data, config))
    },
    // teacher api 
    async updateTeacher(data, config) {
        return (await axios.put(`${baseURL}/teachers`, data, config))
    },
    async deleteTeacher(data) {
        return (await axios.delete(`${baseURL}/teachers/${data.user_id}`))
    },
    async postTeacher(data, config) {
        return (await axios.post(`${baseURL}/teachers`, data, config))
    },
    async getTeacher(teacher_code, config) {
        return (await axios.get(`${baseURL}/teachers/${teacher_code}`, config)).data
    },
    async sortTeacher(data, config) {
        return (await axios.post(`${baseURL}/teachers/sorted`, data, config)).data
    },
    async searchTeacher(data, config) {
        return (await axios.post(`${baseURL}/teachers/search`, data, config))
    },
    async teacherAll() {
        return (await axios.get(`${baseURL}/teachers/all`)).data
    },
    async getTeacherMe(config) {
        return (await axios.get(`${baseURL}/teachers/me`, config)).data
    },
    // Tutorings api
    async postTutoring(data, config) {
        return (await axios.post(`${baseURL}/tutorings`, data, config))
    },
    async getTeacherTutoring(config) {
        return (await axios.get(`${baseURL}/tutorings/0/teacher`, config)).data
    },
    async getStudentTutoring(config) {
        return (await axios.get(`${baseURL}/tutorings/0/student`, config)).data
    },
    async getTutoring(tutorings_id, config) {
        return (await axios.get(`${baseURL}/tutorings/${tutorings_id}`, config)).data
    },
    async updateTutoring(tutoring_code, data, config) {
        return (await axios.put(`${baseURL}/tutorings/${tutoring_code}`, data, config))
    },
    // like api 
    async postLike(data, config) {
        return (await axios.post(`${baseURL}/likes`, data, config)).data
    },
    async getLike(config) {
        return (await axios.get(`${baseURL}/likes`, config)).data
    },
    async deleteLike(like_id) {
        return (await axios.delete(`${baseURL}/likes/${like_id}`))
    },
    async isLike(teacherCode, config) {
        return (await axios.get(`${baseURL}/likes/${teacherCode}`, config)).data
    },
    // review api
    async postReview(data, config) {
        return (await axios.post(`${baseURL}/reviews`, data, config))
    },
    async getTeacherReview(data, config) {
        return (await axios.get(`${baseURL}/reviews/${data}`, config)).data;
    },
    async getReview() {
        return (await axios.get(`${baseURL}/reviews`)).data
    },
    async deleteReview(review_id) {
        return (await axios.delete(`${baseURL}/reviews/${review_id}`))
    },
    async updateReview(data) {
        return (await axios.delete(`${baseURL}/reviews`, data))
    },
    //mesage api
    async sendMessage(data, config) {
        return (await axios.post(`${baseURL}/message`, data, config))
    },
    async getMessage(config) {
        return (await axios.get(`${baseURL}/message`, config)).data
    },
    async getUserMessage(user_code, config) {
        return (await axios.get(`${baseURL}/message/${user_code}`, config)).data
    },
}