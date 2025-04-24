package me.minkyoung.todo_list.Repository;

import me.minkyoung.todo_list.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
