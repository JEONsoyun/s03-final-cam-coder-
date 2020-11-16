# Dockerfile
```docker
# Dockerfile
# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN yarn install
COPY . .

#RUN npm install @vue/cli-service
#build stage
RUN yarn build

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```
<br><br>

# image 생성
```bash
docker build -t camcoder-vuejs . 
```
<br>

# docker hub

```bash
docker login
docker tag camcoder-vuejs wlgh325/camcoder-vuejs:0.1
docker push wlgh325/camcoder-vuejs:0.1
```
<br>

# create namespace

```docker
# namespace 없을 경우
k create namespace ns-frontend
```
<br>

# deploy

```java
k apply -f front-deploy.yaml
```
<br>

# k8s deploy
- image는 위에서 만든 이미지를 사용
- front pod의 nginx 설정을 위해 volume 연결
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: frontend
  namespace: ns-frontend
spec:
  selector:
    matchLabels:
      app: frontend
  replicas: 1
  revisionHistoryLimit: 5
  template:
    metadata:
      labels:
        app: frontend
    spec:
      containers:
        - name: frontend
          image: wlgh325/camcoder-vuejs:0.45
          resources:
            requests:
              cpu: 100m
              memory: 300Mi
          imagePullPolicy: Always
          ports:
          - name: frontend-port
            containerPort: 80
          volumeMounts:
          - name: front-persistent-storage
            mountPath: /etc/nginx/conf.d
      volumes:
      - name: front-persistent-storage
        persistentVolumeClaim:
          claimName: front-pv-claim
---
apiVersion: v1
kind: Service
metadata:
  name: frontend-svc
  namespace: ns-frontend
spec:
  type: ClusterIP
  ports:
    - protocol: TCP
      port: 80
      targetPort: frontend-port
  selector:
    app: frontend
```
<br><br>

# pvc
```yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: front-pv-volume
  labels:
    type: local
spec:
  storageClassName: manual
  capacity:
    storage: 1Gi
  accessModes:
    - ReadOnlyMany
  hostPath:
    path: "/home/ubuntu/k8s/frontend/conf" # local machine path
---
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: front-pv-claim
  namespace: ns-frontend
spec:
  storageClassName: manual
  accessModes:
    - ReadOnlyMany
  resources:
    requests:
      storage: 1Gi
  selector:
    matchLabels:
      type: local
```
<br><br>

# 배포 자동화 스크립트
- front는 jenkins 설정안하고 배포 스크립트만 만들었다.

```python
#!/bin/bash
app_name='vuejs-app'
image_name='camcoder-vuejs'
tag='0.61'
branch_name='develop'
repository_name='s03p31a110'
dockerhub_id='wlgh325'

if [ -d ${repository_name} ]; then
        rm -rf ${repository_name}
fi

git clone -b ${branch_name} --single-branch https://lab.ssafy.com/s03-final/${repository_name}.git && cd ${repository_name}/frontend
docker build -t ${image_name} . && docker tag ${image_name} ${dockerhub_id}/${image_name}:${tag} && docker push ${dockerhub_id}/${image_name}:${tag} && k apply -f front-deploy.yaml
```