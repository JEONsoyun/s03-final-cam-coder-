# 리눅스에 도커 설치

```bash
curl -fsSL https://get.docker.com/ | sudo sh
```
<br>

# Sudo 없이 사용하기

docker는 기본적으로 루트 권한을 필요로 함

root가 아닌 사용자가 sudo 없이 사용하려면 해당 사용자를 docker 그룹에 추가

```bash
sudo usermod -aG docker $USER # 현재 접속중인 사용자에게 권한주기
sudo usermod -aG docker your-user # your-user 사용자에게 권한주기
```

사용자가 로그인 중이라면 다시 로그인 후 권한 적용 (도커를 실행하기 위한 kernel 버전은 3.10.x 이상)
<br> <br>

# Docker-compose 설치

```bash
$ sudo apt install docker-compose -y
```### 리눅스에 도커 설치

```bash
curl -fsSL https://get.docker.com/ | sudo sh
```
<br>