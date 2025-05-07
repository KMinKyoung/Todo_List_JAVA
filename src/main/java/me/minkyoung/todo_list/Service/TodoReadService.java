package me.minkyoung.todo_list.Service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.TodoResponseDto;
import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Entity.User;
import me.minkyoung.todo_list.Repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoReadService {
    private final TodoRepository todoRepository;

    public List<TodoResponseDto> getAllTodos(User user) {
        List<Todo> todos = todoRepository.findAllByUser(user);

        return todos.stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());

    }

    public TodoResponseDto getTodoById(Long id, User user) {
        //id로 DB 에서 Todo를 조회
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 ID는 찾을 수 없습니다: "+ id));

        //조회한 todo를 responseDto로 변환하여 반환
        return new TodoResponseDto(todo);
    }
}
