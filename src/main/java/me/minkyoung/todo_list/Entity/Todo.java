package me.minkyoung.todo_list.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
   // private Status status;

    @Column(updatable = false)// 값이 바뀌지 않도록 설정
    @CreatedDate //자동 생성 날짜
    private LocalDateTime createdAt;

}
