package io.sdet.msm.data.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepositoryJPA extends JpaRepository<ProfileEntity, String> {

    Optional<ProfileEntity> findByNameIgnoreCase(String name);
}
