package io.sdet.msm.business.profile;

import java.util.List;

public interface ProfileRepository {

    Profile getProfile(String name);

    Profile createProfile(Profile profile);

    List<Profile> getAllProfiles();
}
