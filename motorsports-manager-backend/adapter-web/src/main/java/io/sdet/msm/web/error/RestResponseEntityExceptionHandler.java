package io.sdet.msm.web.error;

import io.sdet.msm.exception.ProfileDuplicatedException;
import io.sdet.msm.exception.ProfileNotFoundException;
import io.sdet.msm.model.ErrorResponse;
import io.sdet.msm.model.FieldError;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleContraintViolationException(ConstraintViolationException ex) {
        var fieldErrors = ex.getConstraintViolations()
                .stream()
                .map(v->
                        FieldError.builder()
                            .field(((PathImpl)v.getPropertyPath()).getLeafNode().toString())
                            .error(v.getMessage())
                            .build())
                .toList();

        return buildErrorResponse(HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                "Incorrect parameters provided",
                "constraint-violation-exception",
                fieldErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(v-> FieldError.builder().field(v.getField()).error(v.getDefaultMessage()).build())
                .toList();

        return buildErrorResponse(HttpStatus.BAD_REQUEST,
                ex.getLocalizedMessage(),
                "Incorrect request body",
                "incorrect-request-body",
                fieldErrors);
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String detail, String title, String type) {
        return buildErrorResponse(status, detail, title, type, new ArrayList<>());
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String detail, String title, String type, List<FieldError> errors) {
        return ResponseEntity.status(status).body(ErrorResponse.builder()
                .detail(detail)
                .status(status.value())
                .title(title)
                .type(type)
                .errors(errors)
                .build());
    }
}
