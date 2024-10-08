package io.sdet.msm.web.profile;

import io.sdet.msm.business.profile.*;
import io.sdet.msm.enums.TrackStatus;
import io.sdet.msm.model.*;
import org.mapstruct.Mapper;


@Mapper
public interface ProfileWebMapper {
    Profile map(CreateProfileRequest createProfileRequest);

    ProfileResponse map(Profile profile);

    SeasonRegistrationResponse map(SeasonRegistration seasonRegistration);

    TrackInfoResponse map(TrackInfo trackInfo);

    String map(TrackStatus trackStatus);

    VehicleResponse map(Vehicle profile);
}
