package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.ProfileRepository;
import io.sdet.msm.exception.ProfileDuplicatedException;
import io.sdet.msm.exception.ProfileNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProfileRepositoryImpl implements ProfileRepository {

    private final ProfileRepositoryJPA profileRepositoryJPA;
    private final ProfileDataMapper profileDataMapper;

    @Override
    public Profile getProfile(String name) {
        return profileDataMapper.map(profileRepositoryJPA
                .findByNameIgnoreCase(name)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with name '" + name + "' not found")));
    }

    @Override
    public Profile createProfile(Profile profile) {
        if (profileRepositoryJPA.findByNameIgnoreCase(profile.getName()).isPresent()) {
            throw new ProfileDuplicatedException("Profile with name '" + profile.getName() + "' already exists");
        }

        return profileDataMapper.map(profileRepositoryJPA.save(profileDataMapper.map(profile)));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepositoryJPA.findAll()
                .stream().map(profileDataMapper::map)
                .toList();
    }

    @Override
    public void updateProfile(Profile updatedProfile) {
        Optional<ProfileEntity> existingProfile = profileRepositoryJPA.findByNameIgnoreCase(updatedProfile.getName());
        if (existingProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile with name '" + updatedProfile.getName() + "' not found");
        }
        ProfileEntity existingProfileEntity = existingProfile.get();
        profileRepositoryJPA.delete(existingProfileEntity);

        // dirty fix to make hibernate understand that the old seasonRegistration should be removed
//        existingProfileEntity.getSeasonRegistrations().getFirst().setProfile(null);
//        existingProfileEntity.setSeasonRegistrations(List.of());
//        profileRepositoryJPA.save(existingProfileEntity);

        // update season with new season
        var newProfile = profileDataMapper.map(updatedProfile);
//        newProfile.getSeasonRegistrations().getFirst().setCurrentPosition(updatedProfile.getSeasonRegistrations().getFirst().getCurrentPosition());
//        existingProfileEntity.setSeasonRegistrations(newProfile.getSeasonRegistrations());

        profileRepositoryJPA.save(newProfile);
        log.info("Profile: {} is updated", updatedProfile);
    }
}
