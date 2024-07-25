package io.sdet.msm.business.organization;

import io.sdet.msm.business.profile.Profile;

import java.util.List;

public interface OrganizationRepository {
    Organization getOrganizationsByProfile(Profile profile);

    Organization createOrganization(Organization organization);

    List<Organization> getAllOrganizations();
}
