package io.sdet.msm.business.vehicle;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Vehicle {

    private String name;

    private String wheels;

    private String engine;

    private String chassis;
}
