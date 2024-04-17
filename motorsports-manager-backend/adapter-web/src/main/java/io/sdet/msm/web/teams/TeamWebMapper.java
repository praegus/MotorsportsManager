package io.sdet.msm.web.teams;

import io.sdet.msm.business.teams.TeamDTO;
import io.sdet.msm.model.TeamRequest;
import io.sdet.msm.model.TeamResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TeamWebMapper {
    TeamDTO map(TeamRequest teamRequest);
    List<TeamResponse> map(List<TeamDTO> teamDTO);
}
