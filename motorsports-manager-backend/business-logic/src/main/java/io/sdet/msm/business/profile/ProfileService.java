package io.sdet.msm.business.profile;

import io.sdet.msm.business.season.Season;
import io.sdet.msm.business.season.SeasonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final SeasonService seasonService;

    public List<Profile> getAllProfiles() {
        return profileRepository.getAllProfiles();
    }

    public Profile getProfileByName(String profile) {
        return profileRepository.getProfile(profile);
    }

    public Profile createProfile(Profile profile) {
        profile.setSeasons(Set.of(seasonService.createSeason(Season.builder().name("2024-2025").build())));
        return profileRepository.createProfile(profile);
    }
}
