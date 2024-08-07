package io.sdet.msm.exception;

public class ProfileDuplicatedException extends RuntimeException {
    public ProfileDuplicatedException() {
        super("Season already exists");
    }

    public ProfileDuplicatedException(String message) {
        super(message);
    }
}
