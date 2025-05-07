package me.minkyoung.todo_list.Service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.TodoRequestDto;
import me.minkyoung.todo_list.Dto.TodoResponseDto;
import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Entity.User;
import me.minkyoung.todo_list.Repository.TodoRepository;
import me.minkyoung.todo_list.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        Todo todo = new Todo();
        todo.setTitle(todoRequestDto.getTitle());
        todo.setDescription(todoRequestDto.getDescription());
        todo.setStatus(todoRequestDto.getStatus());
        todo.setCreatedAt(java.time.LocalDateTime.now());
        todo.setUser(user);

        Todo savedTodo = todoRepository.save(todo); //DB 저장
        return new TodoResponseDto(savedTodo);
    }


}
