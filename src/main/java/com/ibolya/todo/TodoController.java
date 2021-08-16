package com.ibolya.todo;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
   private AddService addService;
   private FindService findService;
   private RemoveService removeService;
   private UpdateService updateService;

    public TodoController(AddService addService, FindService findService, RemoveService removeService, UpdateService updateService) {
        this.addService = addService;
        this.findService = findService;
        this.removeService = removeService;
        this.updateService = updateService;
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

    @DeleteMapping("/todo")
    ResponseEntity<Void> removeItem(@RequestBody String requestBody) {
        Gson gson = new Gson();
        TodoItem item = gson.fromJson(requestBody, TodoItem.class);
        removeService.remove(item.getId());
        return ResponseEntity.ok(null);
    }

    @PutMapping("/todo")
    ResponseEntity<Void> updateItem(@RequestBody String requestBody) {
        Gson gson = new Gson();
        TodoItem todoItem = gson.fromJson(requestBody, TodoItem.class);
        updateService.update(todoItem.getId(), todoItem.getName());
        return ResponseEntity.ok(null);
    }

}
