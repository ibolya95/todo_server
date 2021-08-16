package com.ibolya.todo;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindService {
    private TodoDao todoDao;
    public FindService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    List<TodoItem> findItems() {
        return todoDao.list();
    }
}
