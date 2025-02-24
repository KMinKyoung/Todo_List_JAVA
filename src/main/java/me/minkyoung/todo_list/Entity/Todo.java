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

}
