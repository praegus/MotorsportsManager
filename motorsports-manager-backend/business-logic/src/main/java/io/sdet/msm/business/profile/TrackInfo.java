package io.sdet.msm.business.profile;

import io.sdet.msm.enums.TrackStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TrackInfo {
    private String name;

    private TrackStatus status;

    private Integer prizeMoney;
}
