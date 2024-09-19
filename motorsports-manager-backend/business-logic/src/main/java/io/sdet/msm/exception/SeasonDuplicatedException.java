package io.sdet.msm.exception;

public class SeasonDuplicatedException extends RuntimeException {
    public SeasonDuplicatedException() {
        super("Season already exists");
    }

    public SeasonDuplicatedException(String message) {
        super(message);
    }
}
