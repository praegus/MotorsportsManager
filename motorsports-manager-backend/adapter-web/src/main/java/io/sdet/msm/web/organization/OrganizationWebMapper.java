package io.sdet.msm.web.organization;

import io.sdet.msm.business.organization.Organization;
import io.sdet.msm.model.OrganizationRequest;
import io.sdet.msm.model.OrganizationResponse;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationWebMapper {
    Organization map(OrganizationRequest organizationRequest);

    OrganizationResponse map(Organization organization);

}
