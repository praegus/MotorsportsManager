package io.sdet.msm.business.profile;

public interface ProfileRepository {

    Profile getProfile(String name);

    void createProfile(Profile profile);
}
