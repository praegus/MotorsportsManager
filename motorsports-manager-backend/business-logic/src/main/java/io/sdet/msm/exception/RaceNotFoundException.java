package io.sdet.msm.exception;

public class RaceNotFoundException extends RuntimeException {
    public RaceNotFoundException() {
        super("Race not found");
    }
}
