package toy.com.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "todo")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Builder
@ToString
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    private String text;
    private boolean done;
    private String createdTime;
}
