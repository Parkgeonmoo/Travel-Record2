# 💡 Topic

- **여행 여정을 기록과 관리하는 SNS 서비스**
- 사용자가 여행 기록과 여행에 따른 여정을 기록할 수 있게 하는 서비스

# 📝 Summary

실제 많은 사람들은 여행을 다녀올 때 한 곳만을 다녀오지 않고 여러 개의 장소를 다녀오며 포스팅을 한다. 이런 점을 본따 사용자가 한 개의 여행을 기록하고 한 개의 여행 안에 여러 개의 여정(이동,숙박,체류)타입들을 기록할 수 있다.
단 건의 여행 조회(여행에 포함된 다 건의 여정도 조회) 및 다 건의 여행(여행에 포함된 여정의 이름도 조회)을 조회할 수 있으며 여행과 여정 각각을 등록,수정할 수 있다.

# ⭐️ Key Function

- 여행
    - 여행에 속해있는 여행 이름,시작 시간,종료 시간,국내 외 여부를 저장할 수 있다.
    - 여행에 속해있는 여행 이름,시작 시간,종료 시간,국내 외 여부 전부를 수정할 수 있다.
    - 여행에 속해있는 여행 이름,시작 시간,종료 시간,국내 외 여부 중 일부를 수정할 수 있다.
    - 여행 단 건을 조회하면서 여행에 포함된 여정들도 같이 조회할 수 있다.
    - 여행 다 건을 조회하면서 여행들에 포함된 여정들의 이름을 같이 조회할 수 있다.
- 여정
    - 여행 ID를 통해 해당하는 여행에 여정의 타입(이동,숙박,체류)등을 지정해 저장할 수 있다.

# 🛠 Tech Stack

`Spring Boot`, `Github` ,`Git` `MySQL` ,`Docker`

# ⚙️ Architecture

`Domain-Driven Design Architecture`

# 🧑🏻‍💻 Team

- 백엔드 개발자 4명

# 🤚🏻 Part

- 공통 예외 처리
- 여행의 POST,PUT,PATCH API 개발
- 공통 API RESPONSE 처리
- DB ERD 설계

# 🤔 Learned

- Exception Handler를 통한 공통 예외 처리를 직접 해봄으로써 예외 처리의 집중화 및 @Valid를 통한 유효성 체크에 대한 흐름을 알게 되었다.
- ERRORCODE 및 VALIDATIONCODE를 ENUM 타입으로 관리하여 유지보수를 편하게 할 수 있다는 것을 알게 되었다.
- API를 호출하였을때 공통 API RESPONSE를 적용하여 공통적으로 결과값을 받을 수 있도록 처리할 수 있게 되었다.
- 직접 DB 설계를 해봄으로써 DB에 대해서 어떻게 설계를 해야되는지에 대해 이해하게 되었다.
- Docker 이미지에 MySQL 서버를 올림으로써 Docker에 대한 사용법을 좀 더 이해하게 되었다.

# 🔌 프로젝트 실행방법 


- 이 프로젝트에서는 코드 다운으로만 실행이 불가하고 DB가 Docker에 이미지 파일로 올라가 있기에 Docker 실행 방법이 필요하다. 
프로젝트를 실행해보기 위해서는 아래의 설정과 파일들이 필요하다.
<img width="649" alt="Untitled" src="https://github.com/Parkgeonmoo/Travel-Record2/assets/50697545/8c12f1cb-f58a-4796-89c1-b5f390b088a6">

그래서 위의 그림과 같은 관계를 가지고 동작한다.

1. SpringBoot 에서 3305Port로 DB관련 요청을 보낸다.
2. Docker Engine이  3305Port 요청을 받는다.
3. 설정에 따라 Docker Engine이 3305Port 요청을 MySQL의 포트인 3306Port로 전달해줌으로서 동작하게 된다.

## DB 연결 방법

### Docker 설치

도커를 실행시키기 위해서는 실행환경에 Docker가 설치되어있어야 한다.

Window의 경우 **WSL**이라는 Windows 운영체제에서 경량화된 가상화 기술을 사용하여 Linux 운영 체제를 구동할 수 있도록 해 주는 프로그램을 깐 후, DockerDesktop을 설치하면 된다.

아래 잘 정리된 설치 관련 블로그 글이다.

**WSL 설치**

[WSL2 사용 설정(윈도우에서 Ubuntu 사용하는 방법)](https://axce.tistory.com/110?category=1030982)

Docker Desktop 설치

[[Docker] 윈도우 도커 설치방법(window 11)](https://axce.tistory.com/121)

### 실행

Docker 설치를 마쳤으면 이제 Docker Conmtainer을 실행시킬 수 있다.

<img width="179" alt="스크린샷 2023-10-28 151421" src="https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/97028441/6e236e2f-870f-448e-aee5-42190a926fba">

docker-compose.yml 파일에서 빨간상자로 표시된 실행버튼을 클릭하면 자동으로 MySQL 컨테이너를 생성하여 동작시킨다.

그렇게 되면 3305 포트로 연결되는 MySQL 서버가 동작하여 SpringBoot와 연결되어 동작하게 된다.

- 필요한 파일 리스트
1. MySQL의 DockerFile 
2. MySQL 초기설정을 위한 init.sql
3. MySQL 컨테이너 실행을 위한 docker-compose.yml 파일

### DockerFile

- docker_database라는 폴더안에 MySQL 도커 이미지 설정에 대한 파일들을 담아 두었다. 
그 중 하나인 DockerFile 이다.

```tsx
FROM mysql:latest

MAINTAINER team_five

COPY init.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD=root

VOLUME /mysql_data

EXPOSE 3306
```

### init.sql

- docker_database 폴더 안에 있는 MySQL 초기설정을 위한 init.sql 파일이다.

```tsx
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
flush privileges;

create database if not exists trip_record;

use trip_record;
```

### docker-compose.yml

- MySQL 컨테이너 실행을 위한 docker-compose.yml 파일이다. 
앞서 작성한 이미지, 초기 설정 파일들을 기반으로 생성된 이미지를 컨테이너화 해서 동작시킨다.

```tsx
version: '3'
services:
  mysql-server:
    container_name: trip-mysql-server
    build:
      context: ./docker_database
      dockerfile: Dockerfile
    ports:
      - "3305:3306"
```

해당 파일을 실행시킴으로서 독립적인 MySQL 서버가 생성되며 연결이 되어 프로젝트를 테스트해볼 수 있다.


# 📷 Screenshot
### 1. 여행 전체 조회
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fm8Ski%2FbtszjugafGi%2FCvYNEkTauXRmkDbTFSESO1%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbNjOP1%2FbtszjzuRy0K%2FIBuqwyZgOx5sK3RsZHPee0%2Fimg.png)
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FTEAHH%2FbtsziQju6Tp%2F5n5k1LgVuELhdVuaItKN7k%2Fimg.png)

### 2. 여행 단건 조회
### 2-1. Pathvariable
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdcFJfc%2FbtsznAltvWa%2FTkIpJG4DY1MBWu8QuJCyPK%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbLoov1%2FbtszlvEW8dZ%2FPbuV7HFtvldB9xsnfsSvlk%2Fimg.png)
### 2-2. QueryParam
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FRdwUg%2FbtszmAzalCB%2Fpj4cZShknL3eeajeoYnde0%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FlzCJt%2Fbtszlj5KKft%2F5KgvBjhDefeKw3XRWKyjA0%2Fimg.png)


### 3. 여행 등록
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbVswVr%2FbtszjFV8u5n%2F6lZI1L2cRUXSn42IwEKTNk%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbWt52p%2Fbtszj33IwMb%2FPyFB4OOY5kp8vko7VtbDN1%2Fimg.png)

### 4. 여행 정보 일부 수정
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbl21JV%2FbtszhunlRnB%2FGSE27lixfOQ9Sji8kLJKM0%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F09Mc2%2FbtszlHZBRDo%2FHkGplxldXpzPJYPYyuug7K%2Fimg.png)

### 5. 여행 정보 전체 수정
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdlQYLd%2Fbtszk3aSEba%2FmE9u3IPc2exUzoalINBeR0%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F1VUrj%2FbtszkyCdtMN%2FjqNIrIiq9KkCKak6oDGXn1%2Fimg.png)

### 6. 여정 등록
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbxhb9C%2Fbtszln8aA9j%2FgYEjoaqkzUYCy0qgBRniI0%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FMlcLc%2FbtsziQw4dfe%2FSR29K5JPx8ZzViZIYQ3jVk%2Fimg.png)

### 7. 여정 정보 수정
### 7-1. 숙박정보
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FszjHW%2FbtszoikHMBb%2FOmlUhxbBw5WgkQMlmO1ke0%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F0s7Td%2FbtszlIEdAht%2FFmTPlJK0IGyPQZnvpBVFk1%2Fimg.png)
### 7-2. 이동정보
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcOUIGy%2Fbtszmy2ptC1%2FwdVoenBVqhlrPaYFaM3XCK%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Foy2ro%2FbtsznCKmt0m%2FLYWu63TKfHqTXMk0Ua0hH0%2Fimg.png)
### 7-3. 방문정보
* **요청**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FPh3Wl%2Fbtszj4nZ7cD%2FuYdjdgDRk9ekjKKUBkPwb0%2Fimg.png)
* **응답**
<br>![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcuGZNK%2Fbtszl0Sgqgw%2F2uQTDYe9TdIGMcq29JP07k%2Fimg.png)
