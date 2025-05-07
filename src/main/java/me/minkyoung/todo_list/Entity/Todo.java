package me.minkyoung.todo_list.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.minkyoung.todo_list.Domain.Status;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가 ID
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING) // Enum을 문자열로 저장
    @Column(nullable = false)
    private Status status;

    @Column(updatable = false)// 값이 바뀌지 않도록 설정
    private LocalDateTime createdAt; // 생성시 자동 저장

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /*public Todo(TodoRequestDto dto) {
        this.title = dto.getTitle();
        this.description = dto.getDescription();
    }*/ //세터 없애고 싶으면 사용. 나중에 없어질 경우 통일성을 위해 싹 다 바꿔야함
}
