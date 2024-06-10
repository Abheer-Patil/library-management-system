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

    BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
    }

    BaseResponse(Object data, StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = data;
    }
}
