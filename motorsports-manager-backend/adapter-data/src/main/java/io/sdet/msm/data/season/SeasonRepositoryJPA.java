package io.sdet.msm.data.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepositoryJPA extends JpaRepository<SeasonEntity, Long> {
    Optional<SeasonEntity> findByNameIgnoreCase(String name);
}
