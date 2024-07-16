package io.sdet.msm.exception;

public class ProfileDuplicatedException extends RuntimeException {
    public ProfileDuplicatedException() {
        super("Profile already exists");
    }
}
