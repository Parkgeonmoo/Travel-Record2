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
