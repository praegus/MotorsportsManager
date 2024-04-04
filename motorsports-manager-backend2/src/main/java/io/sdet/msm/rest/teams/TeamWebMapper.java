package io.sdet.msm.rest.teams;

import io.sdet.msm.domain.teams.Team;
import io.sdet.msm.model.TeamRequest;
import io.sdet.msm.model.TeamResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TeamWebMapper {
    Team map(TeamRequest teamRequest);
    List<TeamResponse> map(List<Team> team);
}
