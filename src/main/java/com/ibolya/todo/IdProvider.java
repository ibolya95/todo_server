package com.ibolya.todo;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class IdProvider {

    public int provideId() {
        return ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
    }

}
