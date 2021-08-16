package com.ibolya.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryTodoDao implements TodoDao {

    List<TodoItem> items = new ArrayList<>();
    @Override
    public void add(TodoItem todoItem) {
        items.add(todoItem);
    }

    @Override
    public List<TodoItem>  list() {
        return items;
    }
}
