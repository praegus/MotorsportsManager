package io.sdet.msm.domain.chassis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Chassis {
    FIRST("pretty", "red"),
    SECOND("strong", "yellow");

    private final String name;
    private final String color;
}
