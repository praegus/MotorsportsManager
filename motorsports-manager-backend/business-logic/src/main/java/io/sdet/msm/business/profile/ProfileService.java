package io.sdet.msm.business.profile;

import io.sdet.msm.business.season.SeasonRepository;
import io.sdet.msm.business.season.SeasonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {
    public static final String INITIAL_SEASON_NAME = "2024-2025";
    private final ProfileRepository profileRepository;
    private final SeasonService seasonService;
    private final SeasonRepository seasonRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.getAllProfiles();
    }

    public Profile getProfileByName(String profile) {
        return profileRepository.getProfile(profile);
    }

    public Profile createProfile(Profile profile) {
        //Season with name "2024-2025" has been loaded on application start up through the DataLoader class.
        //So we can retrieve and use it.
        profile.setSeasons(List.of(seasonRepository.getSeasonById(INITIAL_SEASON_NAME)));

        seasonRepository.getSeasonById(INITIAL_SEASON_NAME);

        return profileRepository.createProfile(profile);

    }
}
