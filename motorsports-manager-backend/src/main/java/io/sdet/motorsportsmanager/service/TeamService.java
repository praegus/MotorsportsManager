package io.sdet.motorsportsmanager.service;

import io.sdet.motorsportsmanager.dao.TeamDao;
import io.sdet.motorsportsmanager.dao.TeamEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    @SneakyThrows
    public TeamEntity getTeam(String teamName) {
        return teamDao.findByNameIgnoreCase(teamName).orElseThrow();
    }
}
