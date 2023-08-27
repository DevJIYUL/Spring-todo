package toy.com.service;

import toy.com.entity.Todo;
import toy.com.entity.User;

import java.util.List;

public interface TodoService {
    Todo createTodo(Todo todo);
    Long deleteTodo(Todo todo);
    List<Todo> selectAllTodo(User user);
}
