package me.minkyoung.todo_list.Repository;

import me.minkyoung.todo_list.Entity.Todo;
import me.minkyoung.todo_list.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByUser(User user);
}
