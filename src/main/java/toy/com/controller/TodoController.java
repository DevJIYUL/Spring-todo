package toy.com.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.com.entity.Todo;
import toy.com.entity.User;
import toy.com.serviceImpl.TodoServiceImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TodoController {
    private final TodoServiceImpl todoServiceImpl;
    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        log.info("TODO ITEM : ",todo.toString());
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
        Todo newTodo = Todo.builder()
                .user(todo.getUser())
                .createdTime(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .done(true)
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
}