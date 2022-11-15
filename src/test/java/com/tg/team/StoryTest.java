package com.tg.team;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoryTest {

    @Test
    void shouldCreateAssignableStory_whenNewStory() {
        Story story = new Story();

        StoryStatus storyStatus = story.getStatus();

        assertEquals(StoryStatus.ASSIGNABLE, storyStatus);
    }

    @Test
    void shouldChangeStatusToAssigned_givenNewStory_whenStoryChangeToNextStatus() {
        Story story = new Story();

        StoryStatus storyStatus = story.nextStatus();

        assertEquals(StoryStatus.ASSIGNED, storyStatus);
    }

    @Test
    void shouldChangeStatusToImplemented_givenAssignedStory_whenStoryChangeToNextStatus() {
        Story story = new Story();
        story.nextStatus();

        StoryStatus storyStatus = story.nextStatus();

        assertEquals(StoryStatus.IMPLEMENTED, storyStatus);
    }

    @Test
    void shouldChangeStatusToUnderTest_givenImplementedStory_whenStoryChangeToNextStatus() {
        Story story = new Story();
        story.nextStatus();
        story.nextStatus();

        StoryStatus storyStatus = story.nextStatus();

        assertEquals(StoryStatus.UNDERTEST, storyStatus);
    }

    @Test
    void shouldChangeStatusToCompleted_givenUndertestStory_whenStoryChangeToNextStatus() {
        Story story = new Story();
        story.nextStatus();
        story.nextStatus();
        story.nextStatus();
        
        StoryStatus storyStatus = story.nextStatus();

        assertEquals(StoryStatus.COMPLETED, storyStatus);
    }

    @Test
    void shouldThrowStoryHasCompletedException_givenCompletedStory_whenStoryChangeToNextStatus() {
        Story story = new Story();
        story.nextStatus();
        story.nextStatus();
        story.nextStatus();
        story.nextStatus();

        Exception exception = assertThrows(StoryHasCompletedException.class, () -> {
            story.nextStatus();
        });

        assertTrue(exception.getMessage().contains("任务已完成，状态无法更新"));
    }
}
