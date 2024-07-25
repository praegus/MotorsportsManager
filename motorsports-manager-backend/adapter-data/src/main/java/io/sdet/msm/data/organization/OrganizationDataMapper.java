package io.sdet.msm.data.organization;

import io.sdet.msm.business.organization.Organization;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationDataMapper {
    OrganizationEntity map(Organization organization);

    Organization map(OrganizationEntity organizationEntity);
}
