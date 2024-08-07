package io.sdet.msm.data.vehicle;

import io.sdet.msm.business.vehicle.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleDataMapper {
    VehicleEntity map(Vehicle vehicle);

    Vehicle map(VehicleEntity vehicleEntity);
}
