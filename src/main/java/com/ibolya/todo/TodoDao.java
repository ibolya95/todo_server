package com.ibolya.todo;

import java.util.List;

public interface TodoDao {
    void add(TodoItem todoItem);
    List<TodoItem> list();
}
