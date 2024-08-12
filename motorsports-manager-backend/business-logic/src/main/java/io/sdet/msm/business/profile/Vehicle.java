package io.sdet.msm.business.profile;

import io.sdet.msm.enums.Chassis;
import io.sdet.msm.enums.Engine;
import io.sdet.msm.enums.Wheels;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Vehicle {

    private Wheels wheels;

    private Engine engine;

    private Chassis chassis;
}
