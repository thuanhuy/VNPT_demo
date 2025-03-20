package com.example.demo.controller;

import com.example.demo.model.UserToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class userRestApiController {
    private List<UserToDo> todoList = new ArrayList<>();
    @GetMapping("/user")
    public List<UserToDo> getTodoList() {
        return todoList;
    }

    @GetMapping("/user/{todoId}")
    public UserToDo getTodo(@PathVariable(name = "todoId") Integer todoId){
        return todoList.get(todoId);
    }

    @PutMapping("/user/{todoId}")
    public UserToDo editTodo(@PathVariable(name = "todoId") Integer todoId,
                         @RequestBody UserToDo todo){
        todoList.set(todoId, todo);
        return todo;    }

    @DeleteMapping("/user/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId){
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    public ResponseEntity addTodo(@RequestBody UserToDo todo) {
        todoList.add(todo);
        return ResponseEntity.ok().body(todo);
    }
}
