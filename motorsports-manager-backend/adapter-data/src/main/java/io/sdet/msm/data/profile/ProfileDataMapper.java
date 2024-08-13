package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
    ProfileEntity map(Profile profile);
    VehicleEntity map(Vehicle vehicle);
    TrackRecordEntity map(TrackRecord value);
    String map(TrackStatus status);
    SeasonRegistrationEntity map(SeasonRegistration value);

    Profile map(ProfileEntity profileEntity);
    Vehicle map(VehicleEntity vehicle);
    TrackRecord map(TrackRecordEntity value);
    TrackStatus map(String status);
    SeasonRegistration map(SeasonRegistrationEntity value);
}
