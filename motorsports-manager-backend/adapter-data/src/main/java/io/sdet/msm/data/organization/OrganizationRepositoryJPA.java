package io.sdet.msm.data.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepositoryJPA extends JpaRepository<OrganizationEntity, Long> {
//    Optional<OrganizationEntity> findByProfileIgnoreCase(String profile);
}
