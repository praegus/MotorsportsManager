package io.sdet.msm.business.track;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Track {
    private String name;

    private String status;

    private Integer prizeMoney;
}
