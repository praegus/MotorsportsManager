package io.sdet.motorsportsmanager.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface TeamDao extends JpaRepository<TeamEntity, String> {

    Optional<TeamEntity> findByNameIgnoreCase(String name);
}
