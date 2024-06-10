package com.library.collection.constants;

public enum StatusCode {

    OK(200,"SUCCESS","OK"),

    CREATED(201,"SUCCESS","SUCCESS"),

    NO_DATA(300,"SUCCESS","NO DATA FOUND"),

    BAD_REQUEST(400,"ERROR","INVALID PAYLOAD"),

    INTERNAL_SERVER_ERROR(500,"ERROR","SORRY SOMETHING WENT WRONG");


    private final Integer code;
    private final String status;
    private final String message;

    StatusCode(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
