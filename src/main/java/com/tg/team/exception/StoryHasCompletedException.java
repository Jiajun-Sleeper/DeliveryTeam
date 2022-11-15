package com.tg.team.exception;

public class StoryHasCompletedException extends RuntimeException{

    public StoryHasCompletedException() {
        super("任务已完成，状态无法更新");
    }
}
