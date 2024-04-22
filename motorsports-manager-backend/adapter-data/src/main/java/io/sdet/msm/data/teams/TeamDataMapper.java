package io.sdet.msm.data.teams;

import io.sdet.msm.business.teams.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamDataMapper {
    @Mapping(target = "id", ignore = true)
    List<Team> map(List<TeamEntity> teams);

    TeamEntity map(Team team);
}
