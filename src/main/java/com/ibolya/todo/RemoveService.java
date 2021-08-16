package com.ibolya.todo;

import org.springframework.stereotype.Service;

@Service
public class RemoveService {

    TodoDao todoDao;
    public RemoveService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public void remove(Long id) {
        todoDao.remove(id);
    }
}
