gitlab webhook plugin을 먼저 설치한다

# Jenkins webhook 설정
![jenkins build triggers](../../img/jenkins/12.png)
<br> <br>

# 고급 설정
포함시킬 branch 설정. develop branch를 추가하였다.
<br>

![branch 추가](../../img/jenkins/13.png)
<br> <br>

# token 생성
![secret token 생성](../../img/jenkins/14.png) <br>
secret token 아래의 Generate 버튼을 클릭하여 token을 생성한다.  
그러면 자동으로 생성된다.  
이는 Gitlab의 webhook에 등록하여 사용할 것이다.
<br> <br>

# gitlab webhook 설정
secret token 아래의 Generate 버튼을 클릭하여 token을 생성한다.  
그러면 자동으로 생성된다.  
이는 Gitlab의 webhook에 등록하여 사용할 것이다.  
![gitlab webhook 설정](../../img/jenkins/15.png) <br><br>

# webhook 추가
- add webhook 버튼 클릭 -> webhook 등록
![webhokk 추가](../../img/jenkins/16.png) <br><br>
- Test-> push events 클릭
![webhook Test](../../img/jenkins/17.png) <br><br>