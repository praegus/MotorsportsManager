package io.sdet.msm.exception;

public class ProfileDuplicatedException extends RuntimeException {
    public ProfileDuplicatedException(String message) {
        super(message);
    }
}
