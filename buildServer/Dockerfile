FROM node:lts-alpine

MAINTAINER Jiho Park <wlgh325@naver.com>

RUN mkdir -p /app

WORKDIR /app

ADD . /app

RUN npm install

ENV NODE_ENV development

EXPOSE 3000 80

CMD ["npm", "start"]