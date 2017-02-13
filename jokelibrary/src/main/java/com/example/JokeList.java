package com.example;

import java.util.Random;

public class JokeList {
    public String getJoke() {
        String jokes[]={
                "I had ask you to use your brain but I am afraid I would get a Null Pointer Exception",
                "There are 10 kinds of people in the world: Those that know binary & those that dont",
                "A SQL query goes into a bar, walks up to two tables and asks, “Can I join you?",
                "To understand what recursion is, you must first understand recursion.",
                 "Unix is user friendly. It’s just very particular about who its friends are."
        };

        int idx = new Random().nextInt(jokes.length);
        return jokes[idx];
    }
}
