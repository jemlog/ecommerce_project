# 🎮 이커머스 도메인 구현 토이프로젝트 

### 프로젝트 기간 
- 2022.02.20 ~ 2022.03.13


### 🛠 Skill stack 

- Java 11
- Spring Boot 2.6.3
- Gradle
- Mysql
- Vue.js  
- Spring Data JPA 
- QueryDSL
- Spring Security(JWT Login)
- Github actions


### 📚 Application Structure
![mystructure3](https://user-images.githubusercontent.com/82302520/158058559-969d63ed-6418-42b4-8c1c-b7e1b29cb233.png)

### 현재까지 구현 사항 

- 로그인 구현 
- 게시글 페이징 쿼리 구현 
- spring security를 사용한 jwt 로그인 방식 사용
- vue.js에 jwt 인증 로직 추가  
- 조건에 따른 전체 주문 목록 페이징 조회 기능 추가 
- 주문 취소 및 재고 수량 원복 기능 추가 
- github actions와 codeDeploy 사용한 무중단 배포 
- 등급에 따른 할인 비율 조정 및 누적 구매 금액에 따른 자동 등급 변동
- s3를 통한 이미지 업로드 구현
### 트러블 슈팅

📌 @Builder를 엔티티 클래스 레벨에 붙이면 에러 발생한다. 
- @Builder 어노테이션을 클래스 레벨에 작성시 AutoIncrement되는 Id값 까지 builder에 포함이 되서 오류 발생한다. 생성자에 어노테이션 붙이기 
- querydsl 동적쿼리 시 enum 값 처리하는 방법 공부 -> controller의 타입 컨버터 문제 먼저 해결 필요 

