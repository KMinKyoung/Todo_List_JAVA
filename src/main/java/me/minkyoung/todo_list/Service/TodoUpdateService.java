package me.minkyoung.todo_list.Service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.todo_list.Dto.TodoRequestDto;
import me.minkyoung.todo_list.Dto.TodoResponseDto;
import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //생성자 없이 롬복을 이용해서
public class TodoUpdateService {

    private final TodoRepository todoRepository;

    public TodoResponseDto updateTodo(Long id,TodoRequestDto todoRequestDto) {


        Todo todo = todoRepository.findById(id) //Id로 기존 할 일 조회
                .orElseThrow(()-> new IllegalArgumentException("해당 ID는 존재하지 않습니다."));

        //조회된 TOdo 객체의 필드를 RequestDto의 값으로 수정
        todo.setTitle(todoRequestDto.getTitle());
        todo.setDescription(todoRequestDto.getDescription());
        todo.setStatus(todoRequestDto.getStatus());

        // 수정된 Todo 객체 저장
        Todo updatedTodo = todoRepository.save(todo);

        // 저장된 Todo를 ResponseDto로 변환해 반환
        return new TodoResponseDto(updatedTodo);

    }

}
