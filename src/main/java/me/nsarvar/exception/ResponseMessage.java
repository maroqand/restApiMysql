package me.nsarvar.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by nsarvar on 12/27/17.
 */
public class ResponseMessage {
    private HttpStatus errorCode;
    private String errorMessage;
    private List<String> errors;
    private Date time;

    public ResponseMessage() {
    }

    public ResponseMessage(HttpStatus errorCode, String statusMessage) {
        this.errorCode = errorCode;
        this.errorMessage = statusMessage;
    }


    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
