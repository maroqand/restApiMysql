package me.nsarvar.exception;

import me.nsarvar.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by nsarvar on 12/27/17.
 * @ControllerAdivce annotation is a component annotation allowing implementation classes to be auto-detected
 * through classpath scanning.
 * @ControllerAdvice listens across the whole application for exceptions. When throws an exception, it will
 * catch and convert it to the meaningful message
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseMessage> resourceNotFound(ResourceNotFoundException ex){
        ResponseMessage errorMessage = new ResponseMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<ResponseMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMessage> invalidInput(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        ResponseMessage response = new ResponseMessage(HttpStatus.BAD_REQUEST, "Validation errors");
        response.setErrors(ValidationUtil.fromBindingErrors(bindingResult));

        return new ResponseEntity<ResponseMessage>(response, HttpStatus.BAD_REQUEST);
    }
}
