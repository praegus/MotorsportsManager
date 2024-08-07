package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.ProfileRepository;
import io.sdet.msm.exception.ProfileDuplicatedException;
import io.sdet.msm.exception.ProfileNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepository {

    private final ProfileRepositoryJPA profileRepositoryJPA;
    private final ProfileDataMapper profileDataMapper;

    @Override
    public Profile getProfile(String name) {
        return profileDataMapper.map(profileRepositoryJPA
                .findByNameIgnoreCase(name)
                .orElseThrow(() -> new ProfileNotFoundException("Season with name '" + name + "' not found")));
    }

    @Override
    public Profile createProfile(Profile profile) {

/*
       The repository save method creates when profile doesn't exist and update when a
       profile already exists! So we check if a profile already exists first in order
       to throw an exception if this is the case.
*/
        if (profileRepositoryJPA.findByNameIgnoreCase(profile.getName()).isPresent()) {
            throw new ProfileDuplicatedException("Season with name '" + profile.getName() + "' already exists");
        }

        return profileDataMapper.map
                (profileRepositoryJPA.save(profileDataMapper.map(profile)));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepositoryJPA.findAll()
                .stream().map(profileDataMapper::map)
                .toList();
    }
}
