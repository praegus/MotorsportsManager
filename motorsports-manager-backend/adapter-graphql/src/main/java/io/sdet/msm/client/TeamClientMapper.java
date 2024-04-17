package io.sdet.msm.client;

import io.sdet.msm.business.teams.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TeamClientMapper {

    /**
     * graphql generated pojos have builders that use the prefix "with"
     * so we need to specify that here
     */
    @Mapping(target = "withName", source = "name")
    @Mapping(target = "withSlogan", source = "slogan")
    Team map(TeamDTO team);

    List<Team> map(List<TeamDTO> teams);

    TeamDTO mapToDTO(TeamInput team);

    Team map(TeamInput team);
}
