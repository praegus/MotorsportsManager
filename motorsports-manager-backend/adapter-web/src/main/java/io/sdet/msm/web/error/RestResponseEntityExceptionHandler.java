package io.sdet.msm.web.error;

import io.sdet.msm.exception.ProfileDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public RestResponseEntityExceptionHandler() {
        super();
    }

    @ExceptionHandler(ProfileDuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseEntity<RestErrorResponse> handleProfileDuplicated(ProfileDuplicatedException ex) {
        return buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    private ResponseEntity<RestErrorResponse> buildErrorResponse(HttpStatus status, String message) {
        RestErrorResponse restErrorResponse = new RestErrorResponse(status.value(), message);
        return ResponseEntity.status(status).body(restErrorResponse);
    }
}
