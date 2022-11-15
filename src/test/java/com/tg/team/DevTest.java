package com.tg.team;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DevTest {

    @Test
    void shouldAcceptStory_givenFreeDevAndAssignableStory_whenDevAcceptStory() {
        Dev dev = new Dev();
        Story story = new Story();

        dev.accept(story);

        assertEquals(StoryStatus.ASSIGNED, story.getStatus());
    }

    @Test
    void shouldThrowDevNotAvailableException_givenBusyDevAndAssignableStory_whenDevAcceptStory() {
        Dev dev = new Dev();
        Story story1 = new Story();
        dev.accept(story1);
        Story story2 = new Story();

        Exception exception = assertThrows(DevNotAvailableException.class, () -> dev.accept(story2));

        assertTrue(exception.getMessage().contains("带宽不足，无法分配新任务"));
    }

    @Test
    void shouldThrowStoryHasAssignedException_givenFreeDevAndAssignedStory_whenDevAcceptStory() {
        Dev dev = new Dev();
        Story story = new Story();
        story.nextStatus();

        Exception exception = assertThrows(StoryHasAssignedException.class, () -> dev.accept(story));

        assertTrue(exception.getMessage().contains("该任务已分配，无法再次分配"));
    }

    @Test
    void shouldImplementStory_givenBusyDev_whenDevImplementStory() {
        Dev dev = new Dev();
        Story story = new Story();
        dev.accept(story);

        dev.coding();

        assertEquals(StoryStatus.IMPLEMENTED, story.getStatus());
    }

    @Test
    void shouldThrowNotAssignStoryException_givenFreeDev_whenDevImplementStory() {
        Dev dev = new Dev();

        Exception exception = assertThrows(NotAssignStoryException.class, dev::coding);

        assertTrue(exception.getMessage().contains("未分配任务"));
    }
}
