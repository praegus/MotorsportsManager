package io.sdet.msm.business.profile;

public interface ProfileRepository {

    Profile getProfile(String name);

    Profile createProfile(Profile profile);
}
