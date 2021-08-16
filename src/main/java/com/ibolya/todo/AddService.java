package com.ibolya.todo;

import org.springframework.stereotype.Service;

@Service
public class AddService {
   private IdProvider idProvider;
   private TodoDao todoDao;
    public AddService(IdProvider idProvider, TodoDao todoDao) {
        this.idProvider = idProvider;
        this.todoDao = todoDao;
    }

   public TodoItem add(String name) {
        TodoItem item = new TodoItem(idProvider.provideId(), name);
        todoDao.add(item);
        return item;
    }

}
