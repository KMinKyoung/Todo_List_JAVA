package me.minkyoung.todo_list.Controller;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.TodoRequestDto;
import me.minkyoung.todo_list.Dto.TodoResponseDto;
import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Repository.TodoRepository;
import me.minkyoung.todo_list.Service.TodoReadService;
import me.minkyoung.todo_list.Service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoReadService todoReadService;

    @PostMapping()
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        TodoResponseDto todoResponseDto = todoService.createTodo(todoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponseDto);
    }

    @GetMapping("/todos_Lookup")
    public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
        List<TodoResponseDto> response = todoReadService.getAllTodos(); // 서비스 계층 호출
        return ResponseEntity.ok(response);
    }

    @GetMapping("todos_Lookup/{id}")
    public ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long id) {
        TodoResponseDto response = todoReadService.getTodoById(id); // 서비스 계층 호출
        return ResponseEntity.ok(response);
    }
}
