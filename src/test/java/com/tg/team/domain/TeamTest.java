package com.tg.team.domain;

import com.tg.team.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {

    @Test
    void shouldAssignBASuccessful_givenOneBA_whenAssignMember() {
        Team team = new Team();
        Member member = new BA();

        assertTrue(team.assignMember(member));
    }

    @Test
    void shouldAssignDevSuccessful_givenOneBA_whenAssignMember() {
        Team team = new Team();
        Member member = new Dev();

        assertTrue(team.assignMember(member));
    }

    @Test
    void shouldAssignQASuccessful_givenOneBA_whenAssignMember() {
        Team team = new Team();
        Member member = new QA();

        assertTrue(team.assignMember(member));
    }

    @Test
    void shouldAssignStorySuccessful_givenOneStory_whenAssignStory() {
        Team team = new Team();
        Story story = new Story();

        assertTrue(team.assignStory(story));
    }
}
