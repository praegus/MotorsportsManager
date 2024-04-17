package io.sdet.msm.client;

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
    io.sdet.msm.client.Team map(io.sdet.msm.business.teams.Team team);

    List<io.sdet.msm.client.Team> map(List<io.sdet.msm.business.teams.Team> teams);

    io.sdet.msm.business.teams.Team mapToDTO(TeamInput team);

    io.sdet.msm.client.Team map(TeamInput team);
}
