package io.sdet.msm.data.teams;

import io.sdet.msm.business.teams.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamDataMapper {
    List<Team> map(List<TeamEntity> teams);

    @Mapping(target = "id", ignore = true)
    TeamEntity map(Team team);
}
