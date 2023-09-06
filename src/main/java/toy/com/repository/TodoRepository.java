package toy.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.com.entity.Todo;
import toy.com.entity.User;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByUser(User user);

    List<Todo> findByUserAndCreatedTime(User user, String date);
}
