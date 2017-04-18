package com.github.lianqu1990.common.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hanchao
 * @date 2016/11/27 13:05
 */
@Data
@Builder
public class ResponseData<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public ResponseData setResponseCode(ResponseCode code){
        this.code = code.getCode();
        this.message = code.getInfo();
        return this;
    }

    public T get(){
        return data;
    }

    //
    public ResponseData(){}
    
    public ResponseData(ResponseCode code){
        this.setResponseCode(code);
    }
    
    public ResponseData(int code,String message){
        this(code,message,null);
    }
    
    public ResponseData(int code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    
    public ResponseData setCode(int code) {
        this.code = code;
        return this;
    }

    public ResponseData setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseData setData(T data) {
        this.data = data;
        return this;
    }
    
    
}
