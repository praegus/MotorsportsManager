package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.profile.SeasonRegistration;
import io.sdet.msm.business.profile.TrackRecord;
import io.sdet.msm.business.profile.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
    ProfileEntity map(Profile profile);
    VehicleEntity map(Vehicle vehicle);
    TrackRecordEntity map(TrackRecord value);
    SeasonRegistrationEntity map(SeasonRegistration value);

    Profile map(ProfileEntity profileEntity);
    Vehicle map(VehicleEntity vehicle);
    TrackRecord map(TrackRecordEntity value);
    SeasonRegistration map(SeasonRegistrationEntity value);
}
