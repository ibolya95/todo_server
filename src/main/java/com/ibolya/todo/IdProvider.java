package com.ibolya.todo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IdProvider {
    private Random random = new Random();

    public long provideId() {
       return random.nextLong();
    }

}
