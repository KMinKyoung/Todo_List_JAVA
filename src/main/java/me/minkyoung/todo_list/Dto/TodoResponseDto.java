package me.minkyoung.todo_list.Dto;

import me.minkyoung.todo_list.Entity.Todo;

import java.time.LocalDateTime;

public class TodoResponseDto {//응답 DTO
    //할 일 정보를 조회할 때 반환할 데이터 포함
    private Long id;
    private String title;
    private String description;
    private Enum status;
    private LocalDateTime created_at;

    // 엔티티에서 데이터를 변환하여 전달
    // 엔티티(todo)에서 받아온 값을 DTO에 저장
    public TodoResponseDto(Todo todo){
        this.id = todo.getId();
        this.title= todo.getTitle();
        this.description = todo.getDescription();
        this.status= todo.getStatus();
        this.created_at=todo.getCreatedAt();
    }
}
