package io.sdet.msm.enums;

import lombok.Getter;

@Getter
public enum Track {
    TUTORIAL(1, 3, 4),
    WINDY_ROAD(20, 20, 1),
    LONG_ROAD_HOME(0,0,1);

    final int shortCorners;
    final int longCorners;
    final int straightRoads;

    Track(int shortCorners, int longCorners, int straightRoads) {
        this.shortCorners = shortCorners;
        this.longCorners = longCorners;
        this.straightRoads = straightRoads;
    }
}
