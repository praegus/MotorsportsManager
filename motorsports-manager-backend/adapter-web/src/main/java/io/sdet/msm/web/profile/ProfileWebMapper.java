package io.sdet.msm.web.profile;

import io.sdet.msm.business.profile.*;
import io.sdet.msm.model.*;
import org.mapstruct.Mapper;


@Mapper
public interface ProfileWebMapper {
    Profile map(CreateProfileRequest createProfileRequest);

    ProfileResponse map(Profile profile);

    SeasonRegistrationResponse map(SeasonRegistration profile);

    TrackRecordResponse map(TrackRecord profile);

    String map(TrackStatus profile);

    VehicleResponse map(Vehicle profile);
}
