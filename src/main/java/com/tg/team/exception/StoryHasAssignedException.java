package com.tg.team.exception;

public class StoryHasAssignedException extends RuntimeException{
    public StoryHasAssignedException() {
        super("该任务已分配，无法再次分配");
    }
}
