package com.ibolya.todo;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:5500/")
    @GetMapping("/todo")
    ResponseEntity<List<TodoItem>> getItems() {
        return ResponseEntity.ok(findService.findItems());
    }

    @CrossOrigin(origins = "http://localhost:5500/")
    @PostMapping("/todo")
    ResponseEntity<TodoItem> addItem(@RequestBody String requestBody) {
        Gson gson = new Gson();
        TodoItem item = gson.fromJson(requestBody, TodoItem.class);
        return ResponseEntity.ok(addService.add(item.getName()));
    }

    @CrossOrigin(origins = "http://localhost:5500/")
    @DeleteMapping("/todo")
    ResponseEntity<Void> removeItem(@RequestBody String requestBody) {
        Gson gson = new Gson();
        TodoItem item = gson.fromJson(requestBody, TodoItem.class);
        removeService.remove(item.getId());
        return ResponseEntity.ok(null);
    }

    @CrossOrigin(origins = "http://localhost:5500/")
    @PutMapping("/todo")
    ResponseEntity<Void> updateItem(@RequestBody String requestBody) {
        Gson gson = new Gson();
        TodoItem todoItem = gson.fromJson(requestBody, TodoItem.class);
        updateService.update(todoItem.getId(), todoItem.getName());
        return ResponseEntity.ok(null);
    }
}
