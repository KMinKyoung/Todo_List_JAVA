 Todo_List_JAVA 

현재 구현 중인 것
X

구현 완료
● Data Grip과 DB(MySQL) 연동

● 할 일 추가(Create) 
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

● 할 일 조회(Read)
1. Service
   TodoReadService를 만들어 전체 할 일 목록 조회 및 단일 할 일 조회에 대한 비즈니스 로직 처리
2. Controller
   기존에 만들었던 TodoController을 이용하여 Get 요청을 처리하는 할 일 조회 API 구현
3. DTO
   기존에 만들었던TodoResponseDto를 이용하여 클라이언트에 전달할 응답 데이터 형식 정의
4. Repository
   findAll(), findById(id) 등을 활용하여 데이터를 가져옴

● 할 일 수정(UPDATE)
1. Todo 엔티티 수정
   기존 필드들 수정
2. DTO 수정
   수정 요청용 DTO 및 수정 응답용 DTO
3. Service
   UpdateTodo 메서드 추가하여, TodoRepository와 연결하여 데이터 수정 및 반환
4. Controller
   Put 메서드로 수정 요청 받아 Service에서 처리된 결과 반환
5. Repository
   JpaRepository를 상속하기에 별도 수정이 필요 없음

● 할 일 삭제(Delete)
1. 엔티티
   수정 필요 없음
2. DTO
   수정 필요 없음
3. Service
   TodoRepository를 이용하여 삭제할 id 기반으로 Todo를 찾아서 삭제
4. Controller
   Delete 메서드로 삭제 요청 받아 Service에서 처리된 결과 반환

● 유저 인증 및 인가(JWT)

● 필터 정렬 및 추가