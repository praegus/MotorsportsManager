package io.sdet.msm.data.teams;

import io.sdet.msm.business.teams.TeamDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamDataMapper {
    List<TeamDTO> map(List<TeamEntity> teams);

    TeamEntity map(TeamDTO teamDTO);
}
