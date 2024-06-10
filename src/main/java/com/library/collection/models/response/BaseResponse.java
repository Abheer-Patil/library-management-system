package com.library.collection.models.response;

import com.library.collection.constants.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Wrapper response class representing a response returned by API endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    /**
     * HTTP status code of the response.
     */
    private Integer code;

    /**
     * Status message indicating the outcome of the operation.
     */
    private String status;

    /**
     * Additional message providing details about the operation.
     */
    private String message;

    /**
     * Data payload included in the response.
     */
    private Object data;

    /**
     * Constructs a BaseResponse object with the given status code.
     *
     * @param statusCode The status code representing the outcome of the operation.
     */
    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
    }

    /**
     * Constructs a BaseResponse object with the given data payload and status code.
     *
     * @param data       The data payload to include in the response.
     * @param statusCode The status code representing the outcome of the operation.
     */
    public BaseResponse(Object data, StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = data;
    }
}
