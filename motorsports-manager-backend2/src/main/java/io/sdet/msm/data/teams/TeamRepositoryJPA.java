package io.sdet.msm.data.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepositoryJPA extends JpaRepository<TeamEntity, String> {

    Optional<TeamEntity> findByNameIgnoreCase(String name);
}
