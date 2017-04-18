package com.github.lianqu1990.common.util;

import com.github.lianqu1990.common.entity.ResponseCode;
import com.github.lianqu1990.common.entity.ResponseData;
import org.springframework.cglib.beans.ImmutableBean;

/**
 * @author hanchao
 * @date 2017年4月13日 下午4:54:47
 */
public class ResponseUtil {
    /**
     * 为了方便返回，禁止调用此变量的set方法
     */
    public static final ResponseData SUCCESS = (ResponseData) ImmutableBean.create(new ResponseData(ResponseCode.SUCCESS));
    public static final ResponseData FAILED = (ResponseData) ImmutableBean.create(new ResponseData(ResponseCode.FAILED));
    
    public static ResponseData createResponse(ResponseCode code){
        return new ResponseData(code);
    } 
    
}
