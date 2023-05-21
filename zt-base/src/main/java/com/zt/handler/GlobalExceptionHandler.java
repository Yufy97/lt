package com.zt.handler;

import cn.hutool.core.util.StrUtil;
import com.zt.constant.AppHttpCodeEnum;
import com.zt.entity.Result;
import com.zt.handler.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler  {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result MaxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e){
        log.error("{}", e.getMessage());
        return Result.errorResult(AppHttpCodeEnum.FILE_SIZE_ERROR);
    }

    @ExceptionHandler(SystemException.class)
    public Result systemExceptionHandler(SystemException e){
        log.error(" ", e);
//        log.error("{}", e.getMessage());
        return Result.errorResult(e.getCode(),e.getMsg());
    }


//    @ExceptionHandler(Exception.class)
//    public Result exceptionHandler(Exception e){
//
//        log.error(" ", e);
//        Result result = null;
//        if(e instanceof BadCredentialsException){
//            result = Result.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(),e.getMessage());
//        }else if(e instanceof InsufficientAuthenticationException){
//            result = Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
//        }else if(e instanceof AccessDeniedException){
//            result = Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
//        } else{
//            result = Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
//        }
//        return result;
//    }


    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> msgList = new ArrayList<>();
        bindingResult.getFieldErrors().stream().forEach(item->msgList.add(item.getDefaultMessage()));
        String msg = StrUtil.join(msgList.toString());
        log.error("【系统异常】{}",msg);
        return Result.errorResult(AppHttpCodeEnum.EMPTY_PARAMS_ERROR);
    }
}
