package com.tg.team;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BATest {

    @Test
    void shouldCreateLessOrEqualToThreeStories_givenBA_whenCreateStories() {
        BA ba = new BA();

        List<Story> assignedStories = ba.createStories();

        assertTrue(assignedStories.size() <= 3);
        assertTrue(assignedStories.size() > 0);
        assignedStories.forEach(story -> assertEquals(StoryStatus.ASSIGNABLE, story.getStatus()));
    }

    @Test
    void shouldAssignStoriesToEveryFreeDev_givenBAAndAssignableStoryNumberMoreThanFreeDevNumber_whenAssignStories() {
        BA ba = new BA();
        Story story1 = new Story();
        Story story2 = new Story();
        Dev dev = new Dev();

        ba.assign(List.of(dev), List.of(story1, story2));


        assertFalse(dev.isFree());
        assertEquals(StoryStatus.ASSIGNED, story1.getStatus());
        assertEquals(StoryStatus.ASSIGNABLE, story2.getStatus());
    }

    @Test
    void shouldAssignStoriesToEveryFreeDev_givenBAAndAssignableStoryNumberLessThanFreeDevNumber_whenAssignStories() {
        BA ba = new BA();
        Story story = new Story();
        Dev dev1 = new Dev();
        Dev dev2 = new Dev();

        ba.assign(List.of(dev1, dev2), List.of(story));

        assertFalse(dev1.isFree());
        assertTrue(dev2.isFree());
        assertEquals(StoryStatus.ASSIGNED, story.getStatus());
    }
}
