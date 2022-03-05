## 이커머스 도메인 구현 토이프로젝트 

### Skill stack 

- Java 11
- Spring Boot
- Gradle
- Mysql
- Redis
- Spring Data JPA 
- QueryDSL
- Spring Security(Optional)
- AWS EC2
- AWS S3
- AWS RDS
- AWS CodeDeploy
- Github actions
- Nginx
- Swagger API 

### 현재까지 구현 사항 

- 로그인 구현 
- 게시글 페이징 쿼리 구현 
- 세션 레디스 보관 
- 로그인한 유저별로 게시글 저장 
- 로그인한 유저 프로필 내 연관 게시글 및 유저 주문 목록 조회
- 조건에 따른 전체 주문 목록 페이징 조회 기능 추가 
- 주문 취소 및 재고 수량 원복 기능 추가 
- github actions와 codeDeploy 사용한 무중단 배포 
- 등급에 따른 할인 비율 조정 및 누적 구매 금액에 따른 자동 등급 변동
### 트러블 슈팅

📌 @Builder를 엔티티 클래스 레벨에 붙이면 에러 발생한다. 
- @Builder 어노테이션을 클래스 레벨에 작성시 AutoIncrement되는 Id값 까지 builder에 포함이 되서 오류 발생한다. 생성자에 어노테이션 붙이기 
- querydsl 동적쿼리 시 enum 값 처리하는 방법 공부 -> controller의 타입 컨버터 문제 먼저 해결 필요 
