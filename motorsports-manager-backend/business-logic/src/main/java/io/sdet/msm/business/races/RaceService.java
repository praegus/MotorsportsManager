package io.sdet.msm.business.races;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.ProfileRepository;
import io.sdet.msm.business.profile.TrackInfo;
import io.sdet.msm.enums.TrackStatus;
import io.sdet.msm.exception.RaceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static io.sdet.msm.enums.Track.TUTORIAL;
import static io.sdet.msm.enums.Track.WINDY_ROAD;
import static io.sdet.msm.enums.TrackStatus.COMPLETED;

@Service
@Slf4j
@AllArgsConstructor
public class RaceService {

    private final ProfileRepository profileRepository;

    public void startRace(String raceId) {
        //raceid is nu trackid. dit moet los race object worden
        if (!Objects.equals(raceId, TUTORIAL.name())) {
            throw new RaceNotFoundException();
        }

        List<Profile> allProfiles = profileRepository.getAllProfiles();

        allProfiles.forEach(profile -> {
            profile.getSeasonRegistrations().forEach(seasonRegistration -> {
                // set current position to 3
                seasonRegistration.setCurrentPosition(3);
                // add 10k to account balance
                seasonRegistration.setAccountBalance(seasonRegistration.getAccountBalance() + 10000);
                // update tutorial track data
                seasonRegistration.getTrackInfo().forEach(trackInfo -> {
                    if (trackInfo.getName().equals(TUTORIAL.name())) {
                        trackInfo.setStatus(COMPLETED);
                        trackInfo.setPrizeMoney(10000);
                        trackInfo.setPoints(15);
                        trackInfo.setMessage("You have completed the tutorial race and came in third place. You have earned $10,000 and 15 points.");
                    }
                });
                // add windy road track
                seasonRegistration.getTrackInfo().add(TrackInfo.builder()
                        .name(WINDY_ROAD.name())
                        .status(TrackStatus.UPCOMING)
                        .build());
            });
            profileRepository.updateProfile(profile);
        });
    }
}
