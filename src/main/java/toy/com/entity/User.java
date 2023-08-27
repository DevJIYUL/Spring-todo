package toy.com.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//NoArgsConstructor
@Entity
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
    @Column(name = "stric")
    private Long stric;
    @Column(name = "created_time")
    private String createdTime;
}
