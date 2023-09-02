package toy.com.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.com.entity.Todo;
import toy.com.entity.User;
import toy.com.repository.TodoRepository;
import toy.com.service.TodoService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    @Override
    public Todo createTodo(Todo todo) {

        return todoRepository.save(todo);
    }

    @Override
    public Long deleteTodo(Todo todo) {
        todoRepository.deleteById(todo.getTodoId());
        return 0l;
    }

    @Override
    public List<Todo> selectAllTodo(User user) {
        return todoRepository.findByUser(user);
    }
}
