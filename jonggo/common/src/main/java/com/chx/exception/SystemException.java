package com.chx.exception;

import com.chx.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class SystemException {

    @ExceptionHandler(RuntimeException.class)
    public SysResult runtimeException(Throwable throwable){
        throwable.printStackTrace();
        log.info(throwable.getMessage());
        return SysResult.fail("error");
    }
}
