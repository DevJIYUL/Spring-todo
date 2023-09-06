package toy.com.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toy.com.entity.User;
import toy.com.serviceImpl.UserServiceImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserController {
    private final UserServiceImpl userServiceImpl;


    @PostMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody User user){
        System.out.println(user.getUserId()+" "+user.getPassword());
        User loginedUser = userServiceImpl.logIn(user);
        System.out.println(loginedUser);
        return ResponseEntity.ok(loginedUser);
    }
    @PostMapping("/user")
    public ResponseEntity<User> insertUser(@RequestBody User user){
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println(now);
        User newUser = User.builder()
                .stric(0L)
                .password("1234")
                .email("email@***.com")
                .createdTime(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
        return ResponseEntity.ok(userServiceImpl.insertUser(newUser));
    }
}
