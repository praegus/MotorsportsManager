package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.ProfileRepository;
import io.sdet.msm.business.profile.TrackInfo;
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

        // currently only updates single season
        var seasonToUpdate = updatedProfile.getSeasonRegistrations().getFirst();

        existingProfile.ifPresent(existingProfileEntity -> {
            existingProfileEntity.getSeasonRegistrations()
                    .stream()
                    .filter(sr -> sr.getName().equalsIgnoreCase(seasonToUpdate.getName()))
                    .findFirst()
                    .ifPresent(seasonEntity -> {
                        seasonEntity.setCurrentPosition(seasonToUpdate.getCurrentPosition());
                        seasonEntity.setAccountBalance(seasonToUpdate.getAccountBalance());
                        seasonToUpdate.getTrackInfo().forEach(trackInfoToUpdate -> updateTrackInfoInSeason(seasonEntity, trackInfoToUpdate));
                    });
            profileRepositoryJPA.save(existingProfileEntity);
        });

        log.info("Profile: {} is updated", updatedProfile);
    }

    private void updateTrackInfoInSeason(SeasonRegistrationEntity seasonEntity, TrackInfo trackInfoToUpdate) {
        seasonEntity.getTrackInfo()
                .stream()
                .filter(trackEntity -> trackEntity.getName().equalsIgnoreCase(trackInfoToUpdate.getName()))
                .findFirst()
                .ifPresentOrElse(
                    trackEntity -> {
                        // update existing track
                        trackEntity.setStatus(trackInfoToUpdate.getStatus().name());
                        trackEntity.setPrizeMoney(trackInfoToUpdate.getPrizeMoney());
                    },
                    () -> {
                        // add new track
                        var newTrackEntity = profileDataMapper.map(trackInfoToUpdate);
                        newTrackEntity.setSeasonRegistration(seasonEntity);
                        seasonEntity.getTrackInfo().add(newTrackEntity);
                    }
                );
    }
}
