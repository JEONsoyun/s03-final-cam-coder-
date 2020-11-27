### helm 3을 기준으로 진행
### 참고사이트
- [https://artifacthub.io/packages/helm/ingress-nginx/ingress-nginx](https://artifacthub.io/packages/helm/ingress-nginx/ingress-nginx)
- [https://labs.septeni-technology.jp/devops/kubernetes-gitlab-webpack-vuejs-deploy-your-app-completely/](https://labs.septeni-technology.jp/devops/kubernetes-gitlab-webpack-vuejs-deploy-your-app-completely/)
- [https://twofootdog.tistory.com/23?category=845779](https://twofootdog.tistory.com/23?category=845779)
- [https://github.com/kubernetes/ingress-nginx/blob/master/docs/deploy/index.md#aws](https://github.com/kubernetes/ingress-nginx/blob/master/docs/deploy/index.md#aws)
- [https://github.com/TwoFootDog/batch-visualizer/blob/master/batch-visualizer-auth/src/main/resources/application.yml](https://github.com/TwoFootDog/batch-visualizer/blob/master/batch-visualizer-auth/src/main/resources/application.yml)

# nginx-ingress 설치
```bash
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
```

```bash
helm install nginx-ingress ingress-nginx/ingress-nginx
helm ls
```
<br><br>

# frontend ingress 설정
```yaml
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: frontend-ingress
  namespace: ns-frontend
  annotations:
    nginx.ingress.kubernetes.io/rewrite-targte: /
    kubernetes.io/ingress.class: "nginx"
spec:
  rules:
  - host: k3a110.p.ssafy.io
    http:
      paths:
      - path: /
        backend:
          serviceName: frontend-svc
          servicePort: 80
```

frontend pod이 떠있고 그거에 연결된 service name은 frontend-svc  
frontend-svc의 80으로 연결하면 endpoint가 frontend로 되어있음  
즉 [k3a110.p.ssafy.io/로](http://k3a110.p.ssafy.io/로) 들어오면 frontend pod으로 연결된다.  

```bash
curl http://k3a110.p.ssafy.io
```