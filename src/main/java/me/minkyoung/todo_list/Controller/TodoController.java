package me.minkyoung.todo_list.Controller;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.TodoRequestDto;
import me.minkyoung.todo_list.Dto.TodoResponseDto;
import me.minkyoung.todo_list.Entity.User;
import me.minkyoung.todo_list.Service.TodoDeleteService;
import me.minkyoung.todo_list.Service.TodoReadService;
import me.minkyoung.todo_list.Service.TodoService;
import me.minkyoung.todo_list.Service.TodoUpdateService;
import me.minkyoung.todo_list.security.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoReadService todoReadService;
    private final TodoUpdateService todoUpdateService;
    private final TodoDeleteService todoDeleteService;

    @PostMapping()
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto todoRequestDto,
                                                      @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        TodoResponseDto todoResponseDto = todoService.createTodo(todoRequestDto, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponseDto);
    }

    @GetMapping("/todos_Lookup")
    public ResponseEntity<List<TodoResponseDto>> getAllTodos(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return ResponseEntity.ok(todoReadService.getAllTodos(user));
    }

    @GetMapping("todos_Lookup/{id}")
    public ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long id,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        TodoResponseDto responseDto = todoReadService.getTodoById(id,user); //현재 로그인한 사용자
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long id,
                                                      @RequestBody TodoRequestDto todoRequestDto) {
        TodoResponseDto updatedTodo = todoUpdateService.updateTodo(id, todoRequestDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoResponseDto> deleteTodo(@PathVariable Long id) {
        todoDeleteService.deleteTodo(id); //반환할 필요가 없기에 객체 형태가 아닌 그냥 호출
        return ResponseEntity.noContent().build();
    }

}
