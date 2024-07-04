package io.sdet.msm.data.profile;


import io.sdet.msm.business.profile.Profile;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
    ProfileEntity map(Profile profile);

    Profile map(Optional<ProfileEntity> byNameIgnoreCase);
}
