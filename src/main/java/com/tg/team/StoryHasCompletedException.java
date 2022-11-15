package com.tg.team;

public class StoryHasCompletedException extends RuntimeException{

    public StoryHasCompletedException(String message) {
        super(message);
    }
}
