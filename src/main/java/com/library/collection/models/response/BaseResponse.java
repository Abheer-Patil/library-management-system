package com.library.collection.models.response;

import com.library.collection.constants.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private Integer code;
    private String status;
    private String message;
    private Object data;

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
    }

    public BaseResponse(Object data, StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = data;
    }
}
