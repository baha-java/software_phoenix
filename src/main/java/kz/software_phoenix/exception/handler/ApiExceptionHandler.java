package kz.software_phoenix.exception.handler;

import kz.software_phoenix.exception.AuthenticationException;
import kz.software_phoenix.exception.DuplicateEntityException;
import kz.software_phoenix.exception.NotFoundException;
import kz.software_phoenix.exception.UserInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage(),
                httpStatus.value()
        );
        return new ResponseEntity<>(apiExceptionResponse, httpStatus);
    }


    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiExceptionResponse> handleNotFoundException(NotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                e.getMessage(),
                httpStatus.value()
        );
        return new ResponseEntity<>(apiExceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {DuplicateEntityException.class})
    public ResponseEntity<?> handleApiDuplicateEntityException(DuplicateEntityException d){
        HttpStatus httpStatus = HttpStatus.FOUND;

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                d.getMessage(),
                httpStatus.value()
        );
        return new ResponseEntity<>(apiExceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException a){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                a.getMessage(),
                httpStatus.value()
        );
        return new ResponseEntity<>(apiExceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {UserInputException.class})
    public ResponseEntity<?> handleUserInputException(UserInputException u){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                u.getMessage(),
                httpStatus.value()
        );
        return new ResponseEntity<>(apiExceptionResponse, httpStatus);
    }

}
