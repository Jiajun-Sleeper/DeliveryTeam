package com.tg.team;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QATest {

    @Test
    void shouldTestOneStories_givenOneImplementedStoryAndOneAssignableStory_whenTestStories() {
        QA qa = new QA();
        Story story1 = new Story();
        Story story2 = new Story();
        story2.nextStatus();
        story2.nextStatus();
        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);

        qa.test(stories);
        int remainingStoryNumber = stories.size();

        assertEquals(1, remainingStoryNumber);
        assertEquals(story1, stories.get(0));

        assertEquals(StoryStatus.ASSIGNABLE, story1.getStatus());
        assertEquals(StoryStatus.UNDERTEST, story2.getStatus());
    }

    @Test
    void shouldTestTwoStories_givenTwoImplementedStories_whenTestStories() {
        QA qa = new QA();
        Story story1 = new Story();
        story1.nextStatus();
        story1.nextStatus();
        Story story2 = new Story();
        story2.nextStatus();
        story2.nextStatus();
        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);

        qa.test(stories);
        int remainingStoryNumber = stories.size();

        assertEquals(0, remainingStoryNumber);

        assertEquals(StoryStatus.UNDERTEST, story1.getStatus());
        assertEquals(StoryStatus.UNDERTEST, story2.getStatus());
    }

    @Test
    void shouldTestTwoStories_givenThreeImplementedStories_whenTestStories() {
        QA qa = new QA();
        Story story1 = new Story();
        story1.nextStatus();
        story1.nextStatus();
        Story story2 = new Story();
        story2.nextStatus();
        story2.nextStatus();
        Story story3 = new Story();
        story3.nextStatus();
        story3.nextStatus();
        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);
        stories.add(story3);

        qa.test(stories);
        int remainingStoryNumber = stories.size();

        assertEquals(1, remainingStoryNumber);
        assertEquals(story3, stories.get(0));
        
        assertEquals(StoryStatus.UNDERTEST, story1.getStatus());
        assertEquals(StoryStatus.UNDERTEST, story2.getStatus());
        assertEquals(StoryStatus.IMPLEMENTED, story3.getStatus());
    }
}
