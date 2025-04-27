package me.minkyoung.todo_list.Dto;

import lombok.Getter;
import me.minkyoung.todo_list.Domain.Status;

@Getter
public class TodoRequestDto { //요청 DTO, 엔티티와의 분리되어 클라이언트와 서버 간 데이터를 주고 받음
    //클라이언트가 할 일을 추가할 때 보낼 데이터만 포함
    private String title;
    private String description;
    private Status status; //PENDING 또는 COMPLETED 또는 IN_PROGRESS

}
