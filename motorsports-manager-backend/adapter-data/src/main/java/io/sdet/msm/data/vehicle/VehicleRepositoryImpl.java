package io.sdet.msm.data.vehicle;

import io.sdet.msm.business.vehicle.Vehicle;
import io.sdet.msm.business.vehicle.VehicleRepository;
import io.sdet.msm.exception.ProfileDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepository {

    private final VehicleRepositoryJPA vehicleRepositoryJPA;
    private final VehicleDataMapper vehicleDataMapper;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        if (vehicleRepositoryJPA.findByNameIgnoreCase(vehicle.getName()).isPresent()) {
            throw new ProfileDuplicatedException("Vehicle with name '" + vehicle.getName() + "' already exists");
        }

        return vehicleDataMapper.map
                (vehicleRepositoryJPA.save(vehicleDataMapper.map(vehicle)));
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return null;
    }
}
