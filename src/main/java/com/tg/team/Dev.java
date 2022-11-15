package com.tg.team;

import java.util.Objects;

public class Dev {
    private Story story;

    public void accept(Story story) {
        if (Objects.nonNull(this.story)) {
            throw new DevNotAvailableException();
        }
        if (!Objects.equals(StoryStatus.ASSIGNABLE, story.getStatus())) {
            throw new StoryHasAssignedException();
        }

        this.story = story;
        story.nextStatus();
    }

    public void coding() {
        if (Objects.isNull(this.story)) {
            throw new NotAssignStoryException();
        }
        this.story.nextStatus();
        this.story = null;
    }

    public boolean isFree() {
        return Objects.isNull(this.story);
    }
}
