package toy.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.com.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
