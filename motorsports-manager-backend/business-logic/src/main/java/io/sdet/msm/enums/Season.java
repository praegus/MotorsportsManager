package io.sdet.msm.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum Season {
    DEFAULT("2024-2025", RacingClass.GO_KART, List.of(Track.TUTORIAL));

    final String name;
    final RacingClass racingClass;
    final List<Track> tracks;

    Season(String name, RacingClass racingClass, List<Track> tracks) {
        this.name = name;
        this.racingClass = racingClass;
        this.tracks = tracks;
    }
}
