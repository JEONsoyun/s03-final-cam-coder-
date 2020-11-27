# Dockerfile
nodejs 서버의 build를 위한 Dockerfile이다.
```docker
FROM node:lts-alpine

MAINTAINER Jiho Park <wlgh325@naver.com>

RUN mkdir -p /app

WORKDIR /app

ADD . /app

RUN npm install

ENV NODE_ENV development

EXPOSE 3000 80

CMD ["npm", "start"]
```
<br><br>

# dockerize
nodejs 서버를 docker 이미지로 빌드
```bash
docker build -t camcoder-node .
```
<br>

# docker hub
docker hub에 업로드
```bash
docker login
docker tag camcoder-node wlgh325/camcoder-node:0.1
docker push wlgh325/camcoder-node:0.1
```
<br>

# create namespace
```bash
k create namespace ns-node
```

## deploy

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: rtc
  namespace: ns-node
spec:
  selector:
    matchLabels:
      app: rtc
  replicas: 1
  revisionHistoryLimit: 5
  template:
    metadata:
      labels:
        app: rtc
    spec:
      containers:
        - name: rtc
          image: wlgh325/camcoder-node:0.53
          resources:
            requests:
              cpu: 100m
              memory: 300Mi
          imagePullPolicy: Always
          ports:
            - name: node-port
              containerPort: 3000
---
apiVersion: v1
kind: Service
metadata:
  name: node-svc
  namespace: ns-node
spec:
  type: ClusterIP
  ports:
    - protocol: TCP
      port: 3000
      targetPort: node-port
  selector:
    app: rtc
```
<br><br>

# ingress 설정
```yaml
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  annotations:
    kubernetes.io/ingress.class: nginx
    cert-manager.io/cluster-issuer: letsencrypt-prod
  name: node-ingress
  namespace: ns-node
spec:
  rules:
  - host: k3a110.p.ssafy.io
    http:
      paths:
      - backend:
          serviceName: node-svc
          servicePort: 3000
        path: /displayMedia
        pathType: ImplementationSpecific
      - backend:
          serviceName: node-svc
          servicePort: 3000
        path: /userMedia
        pathType: ImplementationSpecific
      - backend:
          serviceName: node-svc
          servicePort: 3000
        path: /socket.io/
        pathType: ImplementationSpecific
      - backend:
          serviceName: node-svc
          servicePort: 3000
        path: /realtime
        pathType: ImplementationSpecific
  tls:
  - hosts:
    - k3a110.p.ssafy.io
    secretName: k3a110.p.ssafy.io

```