package toy.com.service;

import toy.com.entity.Todo;

public interface TodoService {
    Todo createTodo(Todo todo);
    Long deleteTodo(Todo todo);
}
