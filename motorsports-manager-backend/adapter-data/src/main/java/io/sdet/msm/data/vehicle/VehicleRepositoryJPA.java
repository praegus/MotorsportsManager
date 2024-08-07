package io.sdet.msm.data.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepositoryJPA extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findById(Long id);

    Optional<VehicleEntity> findByNameIgnoreCase(String name);
}