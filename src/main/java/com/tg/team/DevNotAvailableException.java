package com.tg.team;

public class DevNotAvailableException extends RuntimeException{
    public DevNotAvailableException() {
        super("带宽不足，无法分配新任务");
    }
}
