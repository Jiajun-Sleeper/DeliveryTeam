package com.tg.team;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BA {
    public List<Story> createStories() {
        return IntStream.range(0, ThreadLocalRandom.current().nextInt(1, 4)).mapToObj(i -> new Story()).collect(toList());
    }

    public void assign(List<Dev> devs, List<Story> stories) {
        List<Dev> freeDevs = devs.stream().filter(Dev::isFree).toList();
        List<Story> assignableStories = stories.stream().filter(story -> StoryStatus.ASSIGNABLE.equals(story.getStatus())).toList();

        int canAssignedStoriesNumber = Math.abs(freeDevs.size() - assignableStories.size());

        IntStream.range(0, canAssignedStoriesNumber).forEach(i -> freeDevs.get(i).accept(assignableStories.get(i)));
    }
}
