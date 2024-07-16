package io.sdet.msm.business.profile;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile getProfileByName(String profile) {
        return profileRepository.getProfile(profile);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.createProfile(profile);
    }
}
