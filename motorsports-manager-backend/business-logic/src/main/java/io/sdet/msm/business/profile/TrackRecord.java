package io.sdet.msm.business.profile;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TrackRecord {
    private String name;

    private TrackStatus status;

    private Integer prizeMoney;
}
