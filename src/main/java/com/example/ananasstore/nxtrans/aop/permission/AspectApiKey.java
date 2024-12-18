package com.example.ananasstore.nxtrans.aop.permission;

import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AspectApiKey {

    @Value("${api.key}")
    private String apiKey;

    @Pointcut("@annotation(CheckApiKey)")
    public void checkApi() {
    }

    @Before("checkApi()")
    public void checkApiKey() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String apiKey = request.getParameter("apiKey");
        if (!this.apiKey.equals(apiKey)) {
            throw new AppException(ErrorCode.APIKEY_INVALID);
        }
    }
}
