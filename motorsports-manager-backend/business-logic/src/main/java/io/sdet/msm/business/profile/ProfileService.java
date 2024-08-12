package io.sdet.msm.business.profile;

import io.sdet.msm.enums.Chassis;
import io.sdet.msm.enums.Engine;
import io.sdet.msm.enums.RacingClass;
import io.sdet.msm.enums.Wheels;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {
    public static final String INITIAL_SEASON_NAME = "2024-2025";
    private final ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.getAllProfiles();
    }

    public Profile getProfileByName(String profile) {
        return profileRepository.getProfile(profile);
    }

    public Profile createProfile(Profile profile) {
        var defaultVehicle = Vehicle.builder()
                .chassis(Chassis.STOCK)
                .engine(Engine.STOCK)
                .wheels(Wheels.STOCK)
                .build();

        var defaultSeason = SeasonRegistration.builder()
                .accountBalance(0)
                .name(INITIAL_SEASON_NAME)
                .racingClass(RacingClass.GO_KART)
                .vehicle(defaultVehicle)
                .trackRecords(new ArrayList<>())
                .build();

        profile.setSeasonRegistrations(List.of(defaultSeason));

        return profileRepository.createProfile(profile);

    }
}
