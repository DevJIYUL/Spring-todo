package toy.com.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.com.entity.Todo;
import toy.com.entity.User;
import toy.com.serviceImpl.TodoServiceImpl;
import toy.com.serviceImpl.UserServiceImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TodoController {
    private final TodoServiceImpl todoServiceImpl;
    private final UserServiceImpl userServiceImpl;
    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        log.info("TODO ITEM : ",todo.toString());
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
        Todo newTodo = Todo.builder()
                .user(userServiceImpl.selectUser(todo.getUser()))
                .createdTime(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .done(todo.isDone())
                .text(todo.getText())
                .build();
        Todo createdTodo = todoServiceImpl.createTodo(newTodo);
        return ResponseEntity.ok(createdTodo);
    }
    @GetMapping("/todo/{userId}")
    public ResponseEntity<List<Todo>> selectAllTodo(@PathVariable("userId")Long userId){
        List<Todo> todoList = todoServiceImpl.selectAllTodo(User.builder().userId(userId).build());
        return ResponseEntity.ok(todoList);
    }
    @GetMapping("/todo/{userId}/{createdDate}")
    public ResponseEntity<List<Todo>> selectDailyTodo(@PathVariable("userId")Long userId, @PathVariable("createdDate") String date){
        List<Todo> todoList = todoServiceImpl.selectDailyTodo(User.builder().userId(userId).build(),date);
        return ResponseEntity.ok(todoList);
    }
    @ResponseStatus(HttpStatus.SEE_OTHER)
    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<Long> deleteTodo(@PathVariable Long todoId){
        System.out.println(todoId);
        return ResponseEntity.ok(todoServiceImpl.deleteTodo(Todo.builder().todoId(todoId).build()));
    }
}
