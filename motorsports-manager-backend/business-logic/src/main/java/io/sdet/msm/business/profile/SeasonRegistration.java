package io.sdet.msm.business.profile;

import io.sdet.msm.enums.RacingClass;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SeasonRegistration {

    private String name;

    private RacingClass racingClass;

    private Integer accountBalance;

    private Vehicle vehicle;

    private List<TrackRecord> trackRecords;
}
