package me.minkyoung.todo_list.Service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.TodoRequestDto;
import me.minkyoung.todo_list.Dto.TodoResponseDto;
import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto) {
        Todo todo = new Todo();
        todo.setTitle(todoRequestDto.getTitle());
        todo.setDescription(todoRequestDto.getDescription());
        todo.setStatus(todoRequestDto.getStatus());
        todo.setCreatedAt(java.time.LocalDateTime.now());

        Todo savedTodo = todoRepository.save(todo); //DB 저장
        return new TodoResponseDto(savedTodo);
    }


}
