package com.tg.team.domain;

import com.tg.team.exception.DevNotAvailableException;
import com.tg.team.exception.NotAssignStoryException;
import com.tg.team.exception.StoryHasAssignedException;

import java.util.Objects;

public class Dev implements Member{
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
