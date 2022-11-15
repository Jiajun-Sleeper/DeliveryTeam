package com.tg.team;

public class Story {

    private StoryStatus storyStatus;

    public Story() {
        this.storyStatus = StoryStatus.ASSIGNABLE;
    }

    public StoryStatus nextStatus() {
        switch (this.storyStatus) {
            case ASSIGNABLE -> this.storyStatus = StoryStatus.ASSIGNED;
            case ASSIGNED -> this.storyStatus = StoryStatus.IMPLEMENTED;
            case IMPLEMENTED -> this.storyStatus = StoryStatus.UNDERTEST;
            case UNDERTEST -> this.storyStatus = StoryStatus.COMPLETED;
            default -> throw new StoryHasCompletedException("任务已完成，状态无法更新");
        }
        return this.storyStatus;
    }

    public StoryStatus getStatus() {
        return this.storyStatus;
    }
}
