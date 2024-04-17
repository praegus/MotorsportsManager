package io.sdet.msm.business.teams;

import java.util.List;

public interface TeamRepository {

    List<Team> getTeams();

    void createTeam(Team team);
}
