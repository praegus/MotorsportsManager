package io.sdet.msm.exception;

public class ProfileDuplicatedException extends RuntimeException {
    public ProfileDuplicatedException() {
        super("Profile already exists");
    }

    public ProfileDuplicatedException(String message) {
        super(message);
    }
}
