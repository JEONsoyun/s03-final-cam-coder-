<div align=center>
![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https://lab.ssafy.com/s03-final/s03p31a110/tree/master)
![SamSung Badge](https://img.shields.io/badge/-Samsung-blue?style=flat-square&logo=Samsung) <br>

# SSAFY 3기 2학기 서울 1반 10팀 자율 프로젝트
## 📹 Cam-Coder
![image](https://user-images.githubusercontent.com/50106311/99208341-7f425a80-2803-11eb-813b-145646083c65.png)

</div>

# 목차
- [프로젝트 소개](#cam-coder-소개)
- [진행 기간](#프로-젝트-진행-기간)
- [멤버](#Developer)
- [ERD](#ERD)
- [API](#API) 
- [개발 스택](#기술스택)
- [기능소개](#기능소개)
- [서비스 배포](#서비스-배포)

# 📹 Cam Coder 소개
[개발자 과외 플랫폼]
개발중에 너무 어려운 문제를 마주쳤지만, 구글링을 아무리 해봐도 해결할 수 없을 때, 
캠코더를 이용해 과외선생님을 찾아보세요.

<br>


# 🗓프로 젝트 진행 기간
- 2020.10.12 ~ 2020.11.27 (약 7주)

- 2020.10.13 ~ 2020.10.16
    - 2020.10.15 세부 기능 계획
    기획서 작성 : https://www.notion.so/SSAFY-PJT-8c8a35904ca7490da92db0ea44a23f27
    - 2020.10.16 ERD & 쿼리
    구성 : https://www.notion.so/SSAFY-PJT-8c8a35904ca7490da92db0ea44a23f27
    - 2020.10.20 와이어 프레임
    구성 : https://docs.google.com/presentation/d/1ZRkNElEq_4RqCXx84PFv2ZG2fIW1xKlzgGjxolAzEbo/edit?usp=sharing


# Developer

- 🙋[임진희](https://lab.ssafy.com/jinhee6340)
- 🙆[김채은](https://lab.ssafy.com/fairy037)
- 🧑[박지호](https://lab.ssafy.com/wlgh325)
- 🙎[서승희](https://lab.ssafy.com/pucca94)
- 💁️[전소윤](https://lab.ssafy.com/twoposition)

<br>

# [기능소개](./doc/explain-function.md)
- [공통](./doc/explain-function.md#공통)
- [학생](./doc/explain-function.md#학생)
- [선생님](./doc/explain-function.md#선생님)
- [1대1 화상과외](./doc/explain-function.md#1대1-화상-과외)

<!--# ERD -->
<!--![image](https://user-images.githubusercontent.com/50106311/96872564-c19ba480-14ae-11eb-994b-dfb4969d5e86.png)-->

<!--# API-->
<!--![image](https://user-images.githubusercontent.com/50106311/96872899-2ce57680-14af-11eb-8561-fb05ed1855c1.png)-->

# INSTALLATION

```
git clone https://lab.ssafy.com/s03-final/s03p31a110.git
```

# FRONTEND

```sh
cd frontend
npm install
npm run dev
```
# BACKEND

```sh
mvnw spring-boot:run
```

# 💻기술스택

## Front
![Vuetify Badge](https://img.shields.io/badge/-Vuetify-black?style=flat-square&logo=Vuetify)
![Vue.js Badge](https://img.shields.io/badge/-Vue.js-green?style=flat-square&logo=Vue.js)
![JavaScript Badge](https://img.shields.io/badge/-JavaScript-yellow?style=flat-square&logo=JavaScript)
![WebRTC Badge](https://img.shields.io/badge/-WebRTC-important?style=flat-square&logo=WebRTC)

## Back
![Java Badge](https://img.shields.io/badge/-Java-orange?style=flat-square&logo=Java)
![Spring Badge](https://img.shields.io/badge/-SpringBoot3.0.6-brightgreen?style=flat-square&logo=Spring)
![JSON Web Tokens Badge](https://img.shields.io/badge/-JWT-black?style=flat-square&logo=Json-Web-Tokens)

## Server
![Kubernetes Badge](https://img.shields.io/badge/-Kubernetes-black?style=flat-square&logo=Kubernetes)
![AWS Badge](https://img.shields.io/badge/-aws-blue?style=flat-square&logo=Amazon-AWS)
![Docker Badge](https://img.shields.io/badge/-Docker-lightblue?style=flat-square&logo=Docker)
![Mysql Badge](https://img.shields.io/badge/-Mysql-9cf?style=flat-square&logo=Mysql)

## Team Collaboration Tool
![Notion Badge](https://img.shields.io/badge/-Notion-informational?style=flat-square&logo=Notion)
![GitLab Badge](https://img.shields.io/badge/-GitLab-black?style=flat-square&logo=GitLab)
![Jira Badge](https://img.shields.io/badge/-Jira-lightgray?style=flat-square&logo=Jira)
![Mattermost Badge](https://img.shields.io/badge/-Mattermost-blue?style=flat-square&logo=Mattermost)
![Webex](https://img.shields.io/badge/-Webex-blueviolet?style=flat-square)



# 서비스 배포
- [01 - Docker 설치](./doc/deploy/docker-설치.md)
- [02 - Kubernetes 설치](./doc/deploy/k8s-설치.md)
- [03 - metalLB 설치](./doc/deploy/metalLB-설치.md)
- [04 - helm3 설치](./doc/deploy/helm-설치.md)
- [05 - 백엔드 서버 배포](./doc/deploy/spring-배포.md)
- [06 - Jenkins 서버 설치](./doc/deploy/jenkins-설치.md)
- [07 - front 배포(vue.js)](./doc/deploy/front-배포.md)
- [08 - ingress-nginx 설치](./doc/deploy/ingress-nginx-설치.md)
- [09 - webRTC server 배포](./doc/deploy/webRTC-server-배포.md)
- [10 - build server 배포](./doc/deploy/build-server-배포.md)