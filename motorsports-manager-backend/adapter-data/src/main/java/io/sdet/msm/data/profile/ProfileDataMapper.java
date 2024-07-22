package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
    ProfileEntity map(Profile profile);

    Profile map(ProfileEntity profileEntity);
}
