package io.sdet.msm.web.organization;

import io.sdet.msm.api.OrganizationsApi;
import io.sdet.msm.business.organization.Organization;
import io.sdet.msm.business.organization.OrganizationService;
import io.sdet.msm.model.OrganizationRequest;
import io.sdet.msm.model.OrganizationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
public class OrganizationsEndpoint implements OrganizationsApi {

    private final OrganizationService organizationService;
    private final OrganizationWebMapper organizationWebMapper;

    @Override
    public ResponseEntity<OrganizationResponse> createOrganization(OrganizationRequest organizationRequest) {
        Organization organization = organizationWebMapper.map(organizationRequest);

        Organization createdOrganization = organizationService.createOrganization(organization);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(createdOrganization.getName().toLowerCase())
                .toUri();

        return ResponseEntity.created(location).body(organizationWebMapper.map(createdOrganization));
    }

    @Override
    public ResponseEntity<List<OrganizationResponse>> getAllOrganizations() {
        return null;
    }

    @Override
    public ResponseEntity<List<OrganizationResponse>> getOrganizationByName(String name) {
        return null;
    }
}
