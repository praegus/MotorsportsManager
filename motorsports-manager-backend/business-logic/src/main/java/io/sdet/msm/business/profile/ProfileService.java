package io.sdet.msm.business.profile;

import io.sdet.msm.enums.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {
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
                .name(Season.DEFAULT.getName())
                .racingClass(Season.DEFAULT.getRacingClass())
                .vehicle(defaultVehicle)
                .trackInfo(Season.DEFAULT.getTracks().stream().findFirst().stream()
                        .map(t -> TrackInfo.builder()
                                .name(t.name())
                                .status(TrackStatus.UPCOMING)
                                .build())
                        .toList())
                .build();

        profile.setSeasonRegistrations(List.of(defaultSeason));

        return profileRepository.createProfile(profile);

    }
}
