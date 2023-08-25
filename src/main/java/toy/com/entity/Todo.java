package toy.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "todo")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    private String text;
    private boolean done;
    private Date createdTime;
}
