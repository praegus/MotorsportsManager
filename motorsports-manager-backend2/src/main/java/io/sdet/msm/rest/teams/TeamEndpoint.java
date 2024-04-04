package io.sdet.msm.rest.teams;

import io.sdet.msm.api.TeamsApi;
import io.sdet.msm.domain.teams.TeamService;
import io.sdet.msm.model.TeamRequest;
import io.sdet.msm.model.TeamResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TeamEndpoint implements TeamsApi {

    private final TeamService teamService;
    private final TeamWebMapper teamWebMapper;

    @Override
    public ResponseEntity<Void> createTeam(TeamRequest teamRequest) {
        teamService.createTeam(teamWebMapper.map(teamRequest));
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(teamRequest.getName()).toUri())
                .build();
    }

    @Override
    public ResponseEntity<List<TeamResponse>> getTeams() {
        return ResponseEntity.ok(teamWebMapper.map(teamService.getTeams()));
    }
}
