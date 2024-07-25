package io.sdet.msm.data.organization;

import io.sdet.msm.business.organization.Organization;
import io.sdet.msm.business.organization.OrganizationRepository;
import io.sdet.msm.business.profile.Profile;
import io.sdet.msm.exception.OrganizationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationRepositoryJPA organizationRepositoryJPA;
    private final OrganizationDataMapper organizationDataMapper;

    @Override
    public Organization getOrganizationsByProfile(Profile profile) {
        return null;
//        return organizationDataMapper.map(organizationRepositoryJPA
//                .findByProfileIgnoreCase(profile.getName())
//                .orElseThrow(() -> new OrganizationNotFoundException("Organization with name '" + profile.getName() + "' not found")));
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationDataMapper.map(organizationRepositoryJPA.save(organizationDataMapper.map(organization)));
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepositoryJPA.findAll()
                .stream().map(organizationDataMapper::map)
                .toList();
    }
}
