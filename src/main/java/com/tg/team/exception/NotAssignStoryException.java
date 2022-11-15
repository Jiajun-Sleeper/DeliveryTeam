package com.tg.team.exception;

public class NotAssignStoryException extends RuntimeException{
    public NotAssignStoryException() {
        super("未分配任务");
    }
}
