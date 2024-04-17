package io.sdet.msm.business.teams;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    public void createTeam(Team team) {
        teamRepository.createTeam(team);
    }
}
