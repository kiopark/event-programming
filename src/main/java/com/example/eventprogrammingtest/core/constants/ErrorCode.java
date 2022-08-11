package com.example.eventprogrammingtest.core.constants;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BAD_REQUEST(400, CommonConstants.FAIL_CODE, "입력 값을 확인해주세요.");

    private int status;

    private int code;

    private String message;

    ErrorCode(int status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
