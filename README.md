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
