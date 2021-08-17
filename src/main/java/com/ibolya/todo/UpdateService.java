package com.ibolya.todo;

import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    TodoDao todoDao;
    public UpdateService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

   public void update(Integer id, String name) {
       todoDao.update(id, name);


   }
}
