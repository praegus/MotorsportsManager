package io.sdet.msm.data.teams;

import io.sdet.msm.business.teams.TeamDTO;
import io.sdet.msm.business.teams.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamRepositoryImpl implements TeamRepository {

    private final TeamRepositoryJPA teamRepositoryJPA;
    private final TeamDataMapper teamDataMapper;

    @Override
    public List<TeamDTO> getTeams() {
        return teamDataMapper.map(teamRepositoryJPA.findAll());
    }

    @Override
    public void createTeam(TeamDTO teamDTO) {
        teamRepositoryJPA.save(teamDataMapper.map(teamDTO));
    }
}
