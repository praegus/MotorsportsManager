package io.sdet.msm.domain.teams;

import java.util.List;

public interface TeamRepository {

    List<Team> getTeams();

    void createTeam(Team team);
}
