package io.sdet.msm.business.profile;

import io.sdet.msm.business.season.Season;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class Profile {

    private String name;

    private Set<Season> seasons;
}