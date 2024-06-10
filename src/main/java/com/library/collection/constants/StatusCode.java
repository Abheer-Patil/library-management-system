package com.library.collection.constants;

/**
 * Enum for a wrapper response representing HTTP status codes along with corresponding status and message.
 */
public enum StatusCode {

    /**
     * 200 OK: The request has succeeded.
     */
    OK(200, "SUCCESS", "OK"),

    /**
     * 201 Created: The request has been fulfilled, resulting in the creation of a new resource.
     */
    CREATED(201, "SUCCESS", "SUCCESS"),

    /**
     * 300 No Data: The request was successful, but no data was found.
     */
    NO_DATA(300, "SUCCESS", "NO DATA FOUND"),

    /**
     * 400 Bad Request: The request could not be understood by the server due to invalid syntax.
     */
    BAD_REQUEST(400, "ERROR", "INVALID PAYLOAD"),

    /**
     * 500 Internal Server Error: A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.
     */
    INTERNAL_SERVER_ERROR(500, "ERROR", "SORRY SOMETHING WENT WRONG");

    private final Integer code;
    private final String status;
    private final String message;

    /**
     * Constructor for StatusCode enum.
     *
     * @param code    The HTTP status code.
     * @param status  The status category (e.g., "SUCCESS" or "ERROR").
     * @param message The corresponding message for the status code.
     */
    StatusCode(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    /**
     * Get the HTTP status code.
     *
     * @return The HTTP status code.
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Get the status category (e.g., "SUCCESS" or "ERROR").
     *
     * @return The status category.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get the corresponding message for the status code.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }
}
