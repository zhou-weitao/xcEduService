package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wtzhou
 * @date 2020/5/25 5:30 下午
 * 统一异常处理
 **/
@Slf4j
@ControllerAdvice
public class ExceptionCatch {


    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResponseResult customerException(CustomException exception) {
        log.error("catch exception : {}\r\nexception: ",exception.getMessage(),exception);
        ResultCode resultCode = exception.getResultCode();
        return new ResponseResult(resultCode);
    }


}
