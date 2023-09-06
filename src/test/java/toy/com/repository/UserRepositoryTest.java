package toy.com.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.com.entity.User;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    private User user;
    private LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
    @BeforeEach
    void setUp() {
        System.out.println("## setup ##");
        user = userRepository.save(User.builder()
                .userId(1l)
                .stric(0l)
                .password("password")
                .email("***@***.***")
                .createdTime(String.valueOf(now))
                .build());
    }
    @Test
    @Transactional
    void insertUser(){
        System.out.println("## insertUser ##");
        /* given */
        System.out.println(user);
        /* when */
        User result = userRepository.save(user);
        /* then */
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
    }
    @Test
    @Transactional
    void selectUser(){
        System.out.println("## selectUser ##");
        /* given */
        User given = userRepository.save(user);
        /* when */
        User result = userRepository.findById(given.getUserId()).orElseThrow();
        /* then */
        assertNotNull(result);
    }
    @Test
    @Transactional
    void logIn(){
        System.out.println("## logIn ##");
        /* given */
        User given = userRepository.save(user);
        /* when */
        User result = userRepository.findByUserIdAndPassword(given.getUserId(),given.getPassword());
        /* then */
        assertNotNull(result);
    }
}
