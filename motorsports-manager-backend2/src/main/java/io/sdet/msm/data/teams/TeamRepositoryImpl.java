package io.sdet.msm.data.teams;

import io.sdet.msm.domain.teams.Team;
import io.sdet.msm.domain.teams.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamRepositoryImpl implements TeamRepository {

    private final TeamRepositoryJPA teamRepositoryJPA;
    private final TeamDataMapper teamDataMapper;

    @Override
    public List<Team> getTeams() {
        return teamDataMapper.map(teamRepositoryJPA.findAll());
    }

    @Override
    public void createTeam(Team team) {
        teamRepositoryJPA.save(teamDataMapper.map(team));
    }
}
