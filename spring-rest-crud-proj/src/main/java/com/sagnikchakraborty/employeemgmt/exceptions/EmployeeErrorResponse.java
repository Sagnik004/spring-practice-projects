package com.sagnikchakraborty.employeemgmt.exceptions;

public class EmployeeErrorResponse {

    private int statusCode;
    private String errorMessage;
    private long timestamp;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int statusCode, String errorMessage, long timestamp) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EmployeeNotFoundErrorResponse{" +
                "statusCode=" + statusCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
