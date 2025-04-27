package me.minkyoung.todo_list.Service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoDeleteService {

    private final TodoRepository todoRepository;

    public void deleteTodo(Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID는 존재하지 않습니다"));

        todoRepository.delete(todo);
    }
}
