package com.musala.demo.exception;

import com.musala.demo.enums.ApplicationError;

public class MusalaException extends RuntimeException  {

    private String errorCode;
    private String errorMessage;

    public MusalaException(ApplicationError applicationError) {
        this.errorCode = applicationError.getStatusCode();
        this.errorMessage = applicationError.getStatusMessage();
    }

    public MusalaException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
