package io.sdet.msm.business.teams;

import java.util.List;

public interface TeamRepository {

    List<TeamDTO> getTeams();

    void createTeam(TeamDTO teamDTO);
}
