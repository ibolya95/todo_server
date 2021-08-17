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

    @Override
    public void remove(Integer id) {
        TodoItem todoItem = null;

      for(int i = 0 ; i < items.size() ; i++) {
          if(items.get(i).getId().equals(id)) {
              todoItem = items.get(i);
          }
      }
        if(todoItem != null) {
            items.remove(todoItem);
        }
    }

    @Override
    public void update(Integer id, String name) {

        TodoItem todoItem = null;
        int index = 0;

        for(int i = 0 ; i < items.size() ; i++) {
            if(items.get(i).getId().equals(id)) {
                todoItem = items.get(i);
                index = i;
            }
        }
        if(todoItem != null) {
            todoItem.setName(name);
            items.set(index,todoItem);
        }
    }


}
