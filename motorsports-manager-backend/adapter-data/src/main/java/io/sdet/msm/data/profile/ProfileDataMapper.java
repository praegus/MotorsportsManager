package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.*;
import io.sdet.msm.enums.TrackStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
    ProfileEntity map(Profile profile);
    VehicleEntity map(Vehicle vehicle);
    TrackInfoEntity map(TrackInfo value);
    String map(TrackStatus status);
    SeasonRegistrationEntity map(SeasonRegistration value);

    Profile map(ProfileEntity profileEntity);
    Vehicle map(VehicleEntity vehicle);
    TrackInfo map(TrackInfoEntity trackInfoEntity);
    TrackStatus map(String status);
    SeasonRegistration map(SeasonRegistrationEntity seasonRegistrationEntity);
}
