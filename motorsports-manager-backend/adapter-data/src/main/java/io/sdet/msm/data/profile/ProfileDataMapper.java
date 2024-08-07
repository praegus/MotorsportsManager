package io.sdet.msm.data.profile;

import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.business.vehicle.Vehicle;
import io.sdet.msm.data.vehicle.VehicleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
    ProfileEntity map(Profile profile);

    Profile map(ProfileEntity profileEntity);

    String map(Vehicle vehicle);

    Vehicle map(String value);
}
