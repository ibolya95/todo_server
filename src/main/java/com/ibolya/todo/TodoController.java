package com.ibolya.todo;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
   private AddService addService;
   private FindService findService;
    public TodoController(AddService addService, FindService findService) {
        this.addService = addService;
        this.findService = findService;
    }

    @GetMapping("/todo")
    ResponseEntity<List<TodoItem>> getItems() {
        return ResponseEntity.ok(findService.findItems());
    }

    @PostMapping("/todo")
    ResponseEntity<TodoItem> addItem(@RequestBody String requestBody) {
        Gson gson = new Gson();
        TodoItem item = gson.fromJson(requestBody, TodoItem.class);
        return ResponseEntity.ok(addService.add(item.getName()));
    }

}
