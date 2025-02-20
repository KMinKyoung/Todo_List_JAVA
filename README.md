 Todo_List_JAVA
구현해야할 것
 CRUD
 유저 인증 및 인가
 할 일 완료 여부 체크 및 정렬/ 필터 기능
 

현재 구현 중인 것
할 일 추가(Create)
1. Todo 엔티티 생성
   id, title, description, status, createdAt 같은 필드를 포함
2. DTO 생성
   클라이언트가 보낼 요청 데이터를 담을 TodoRequestDto
   응답을 위한 TodoResponseDto
3. Repository 생성
   JpaRepository<Todo, Long>을 상속받아 데이터베이스와 연결
4. Service 계층
   TodoService를 만들어 비즈니스 로직 처리 (할 일 저장)
5. Controller 생성
   @PostMapping("/todos")를 사용해 할 일을 추가하는 API 구현
 