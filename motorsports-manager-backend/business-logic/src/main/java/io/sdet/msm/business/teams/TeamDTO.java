package io.sdet.msm.business.teams;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamDTO {
    private String name;
    private String slogan;
}
