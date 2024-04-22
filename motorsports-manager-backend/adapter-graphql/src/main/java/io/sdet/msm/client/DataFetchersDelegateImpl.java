package io.sdet.msm.client;

import graphql.schema.DataFetchingEnvironment;
import io.sdet.msm.business.teams.TeamService;
import io.sdet.msm.client.util.DataFetchersDelegateMutation;
import io.sdet.msm.client.util.DataFetchersDelegateQuery;
import io.sdet.msm.client.util.DataFetchersDelegateTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataFetchersDelegateImpl implements DataFetchersDelegateTeam, DataFetchersDelegateQuery, DataFetchersDelegateMutation {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamClientMapper mapper;

    @Override
    public Team teamByName(DataFetchingEnvironment dataFetchingEnvironment, String name) {
        return mapper.map(teamService.getTeams().stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().orElseThrow());
    }

    @Override
    public List<Team> getAllTeams(DataFetchingEnvironment dataFetchingEnvironment) {
        return mapper.map(teamService.getTeams());
    }

    @Override
    public Team createTeam(DataFetchingEnvironment dataFetchingEnvironment, TeamInput team) {
        teamService.createTeam(mapper.mapToDTO(team));
        return mapper.map(team);
    }
}
