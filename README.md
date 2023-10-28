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



그래서 위의 그림과 같은 관계를 가지고 동작합니다.

1. SpringBoot 에서 3305Port로 DB관련 요청을 보냅니다.
2. Docker Engine이  3305Port 요청을 받습니다.
3. 설정에 딸라 Docker Engine이 3305Port 요청을 MySQL의 포트인 3306Port로 전달해줌으로서 동작하게 됩니다.


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
<br>![GET all Trip Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/2273f0c4-83dc-4a3c-83bb-64409a3aa9ff)
* **응답**
<br>![GET all Trip Response 01 png](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/9a7abdde-1f68-4f76-955e-2567f4c4270c)
<br>![GET all Trip Response 02 png png](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/121ab98b-1042-4191-8947-39189b5f1783)

### 2. 여행 단건 조회
* **요청**
<br>![GET Trip Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/6f18da69-98c8-43e5-a470-06042f6182d3)
* **응답**
<br>![GET Trip Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/0b712cc0-07cc-46a0-a095-2995922463f2)

### 3. 여행 등록
* **요청**
<br>![POST Trip Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/34cf1c24-85c4-49fb-9df8-a0c858569e10)
* **응답**
<br>![POST Trip Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/1431a9e4-117b-46a8-a6da-f7f8d192c409)

### 4. 여행 정보 일부 수정
* **요청**
<br>![PATCH Trip Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/1add29f8-5f9d-41b6-a47c-b5ab82a6cd62)
* **응답**
<br>![PATCH Trip Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/cec007d0-b4f9-4ef4-92bc-aa4bc3b2e412)

### 5. 여행 정보 전체 수정
* **요청**
<br>![PUT Trip Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/8955707c-bcf3-43b1-b296-fc60729beea5)
* **응답**
<br>![PUT Trip Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/eb93a4ad-55a1-479d-9eda-866fd0b167af)

### 6. 여정 등록
* **요청**
<br>![POST Journey Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/6198243d-ad5a-4bbc-9894-4a758f9a476f)
* **응답**
<br>![POST Journey Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/f990c558-a9fa-4a34-b8c9-52acf4e910b1)

### 7. 여정 정보 수정
### 7-1. 이동정보
* **요청**
<br>![PUT MoveJourney Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/76535a9d-7654-42f1-aa11-12b1a6c794eb)
* **응답**
<br>![PUT MoveJourney Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/1f075665-ed1e-4ce2-911c-c48dc101a891)
### 7-2. 숙박정보
* **요청**
<br>![PUT LodgmentJourney Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/32866547-6e13-4af0-8724-0851d359a712)
* **응답**
<br>![PUT LodgmentJourney Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/85037782-482c-4ebc-93f9-7937565b5324)
### 7-3. 방문정보
* **요청**
<br>![PUT VisitJourney Request](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/a8e441fc-56ca-40a8-a086-b3bac63077c2)
* **응답**
<br>![PUT VisitJourney Response](https://github.com/Group5-toy/KDT_Y_BE_Toy_Project2/assets/81563920/679b3eca-64db-4e9b-9c70-78a124380e0f)
