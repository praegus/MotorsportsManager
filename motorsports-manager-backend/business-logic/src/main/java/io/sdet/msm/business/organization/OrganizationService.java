package io.sdet.msm.business.organization;


import io.sdet.msm.business.profile.Profile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.getAllOrganizations();
    }

    public Organization getOrganizationsForProfile(Profile profile) {
        return null;
    }

    public Organization createOrganization(Organization organization) {
        return organizationRepository.createOrganization(organization);
    }
}
