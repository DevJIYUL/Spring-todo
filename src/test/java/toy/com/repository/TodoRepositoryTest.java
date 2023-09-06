package toy.com.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import toy.com.entity.Todo;
import toy.com.entity.User;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UserRepository userRepository;

    private User user;
    private Todo todo;
    private LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
    @BeforeEach
    void setUp() {
        System.out.println("## setup ##");
        user = userRepository.save(User.builder()
                .userId(1l)
                .stric(0l)
                .email("***@***.***")
                .createdTime(String.valueOf(now))
                .build());
        todo = Todo.builder()
                .user(user)
                .todoId(1l)
                .text("todo")
                .createdTime(String.valueOf(now))
                .build();
    }
    @Test
    @Transactional
    void createTodo() {
        System.out.println("## createtodo ##");
        /* given */
        System.out.println(todo);
        /* when */
        Todo result = todoRepository.save(todo);
        /* then */
        assertThat(todo.getText()).isEqualTo(result.getText());
    }

    @Test
    @Transactional
    void deleteTodo() {
        System.out.println("## deletetodo ##");
        /* given */
        Todo result = todoRepository.save(todo);
        /* when */
        todoRepository.deleteById(result.getTodoId());
        /* then */
        assertThat(true);
    }

    @Test
    void selectAllTodo() {

        System.out.println("## selectall ##");

    }

    @Test
    @Transactional
    void selectDailyTodo() {
        System.out.println("## selectday ##");
        /* given */
        Todo given = todoRepository.save(todo);
        /* when */

        now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Todo> result = todoRepository.findByUserAndCreatedTime(given.getUser(), String.valueOf(now));
        /* then */
        assertThat(result.get(0).getCreatedTime()).isEqualTo(String.valueOf(now));
    }
}
