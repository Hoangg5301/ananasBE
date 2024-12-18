package com.example.ananasstore.service.impl;

import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import com.example.ananasstore.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void testExceptionHandle() {
        throw new AppException(ErrorCode.APIKEY_INVALID);
    }
}
