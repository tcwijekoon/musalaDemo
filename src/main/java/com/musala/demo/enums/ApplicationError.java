package com.musala.demo.enums;


public enum ApplicationError {

    SERVER_ERROR("000","Server error."),
    TEST_ERROR("001","Test error."),
    INVALID_IP_ADDRESS("002","Invalid IP address"),
    GATEWAY_NOT_SAVED("003","Gateway not saved"),
    DEVICE_NOT_SAVED("003","Device not saved"),
    SERIAL_ALREADY_EXISTS("004","Serial already exists"),
    INVALID_SERIAL("005","Invalid Serial"),
    INVALID_DATE("005","Invalid Date"),
    NAME_REQUIRED("005","Name required"),
    VENDOR_REQUIRED("005","Vendor required"),
    MAX_DEVICES_ADDED("005","Maximum devices added for the Gateway"),
    CREATED_DATE_REQUIRED("005","Created Date required"),
    STATUS_REQUIRED("005","Status required"),
    INVALID_STATUS("005","Invalid Status"),
    NO_DATA("003","No Data"),
    INVALID_GATEWAY_ID("006","Invalied Gateway Id");

    private String statusCode;
    private String statusMessage;

    private ApplicationError(String statusCode , String statusMessage){
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }


}
