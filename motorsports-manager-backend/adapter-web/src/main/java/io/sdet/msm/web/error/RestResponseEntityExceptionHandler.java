package io.sdet.msm.web.error;

import io.sdet.msm.exception.ProfileDuplicatedException;
import io.sdet.msm.exception.ProfileNotFoundException;
import io.sdet.msm.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public RestResponseEntityExceptionHandler() {
        super();
    }

    @ExceptionHandler(ProfileDuplicatedException.class)
    protected ResponseEntity<Object> handleProfileDuplicated(ProfileDuplicatedException ex) {
        return buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), "Duplicated profile", "duplicated-profile");
    }

    @ExceptionHandler(ProfileNotFoundException.class)
    protected ResponseEntity<Object> handleProfileNotFound(ProfileNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), "Profile not found", "profile-not-found");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var detailMessage = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> "[%s]: %s".formatted(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.joining("; "));

        return buildErrorResponse(HttpStatus.BAD_REQUEST, detailMessage, "Incorrect request body", "incorrect-request-body");
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String detail, String title, String type) {
        var errorResponse = new ErrorResponse();
        errorResponse.detail(detail);
        errorResponse.status(status.value());
        errorResponse.title(title);
        errorResponse.type(type);
        return ResponseEntity.status(status).body(errorResponse);
    }
}
