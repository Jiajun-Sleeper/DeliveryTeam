package com.tg.team;

public class NotAssignStoryException extends RuntimeException{
    public NotAssignStoryException() {
        super("未分配任务");
    }
}
