package com.tg.team.domain;

import java.util.List;

public class QA implements Member{
    public void test(List<Story> stories) {
        List<Story> implementedStories = stories.stream()
                .filter(story -> StoryStatus.IMPLEMENTED.equals(story.getStatus()))
                .limit(2)
                .toList();

        stories.removeAll(implementedStories);
        implementedStories.forEach(Story::nextStatus);
    }
}
