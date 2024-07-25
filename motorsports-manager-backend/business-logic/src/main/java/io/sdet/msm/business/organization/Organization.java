package io.sdet.msm.business.organization;

import io.sdet.msm.business.profile.Profile;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Organization {
    private String name;
    private Profile profile;
}
