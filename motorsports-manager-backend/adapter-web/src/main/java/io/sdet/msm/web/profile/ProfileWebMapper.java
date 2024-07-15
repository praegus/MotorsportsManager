package io.sdet.msm.web.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.model.ProfileRequest;
import io.sdet.msm.model.ProfileResponse;
import org.mapstruct.Mapper;


@Mapper
public interface ProfileWebMapper {
    Profile map(ProfileRequest profileRequest);
    ProfileResponse map(Profile profile);
}
