package io.sdet.msm.business.vehicle;

public interface VehicleRepository {
    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(String id);
}
