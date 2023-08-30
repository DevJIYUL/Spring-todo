package toy.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.com.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserIdAndPassword(Long userid, String password);

}
