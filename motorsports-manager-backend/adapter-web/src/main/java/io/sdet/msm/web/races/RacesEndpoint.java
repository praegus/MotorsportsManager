package io.sdet.msm.web.races;

import io.sdet.msm.api.RacesApi;
import io.sdet.msm.business.profile.ProfileService;
import io.sdet.msm.business.races.RaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RacesEndpoint implements RacesApi {

    private final RaceService raceService;

    @Override
    public ResponseEntity<Void> startRace(String raceId) {
        raceService.startRace(raceId);
        return ResponseEntity.noContent().build();
    }
}
