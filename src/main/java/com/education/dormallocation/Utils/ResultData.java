package com.education.dormallocation.Utils;

import lombok.Data;

@Data
public class ResultData<T> {
    private int status;
    private String message;
    private T data;
    private Long timestamp;

    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }

//    成功
    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC100.getCode());
        resultData.setMessage(ReturnCode.RC100.getMessage());
        resultData.setData(data);
        return resultData;
    }

//    失败
    public static <t> ResultData<t> fail(int code, String message) {
        ResultData<t> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}

