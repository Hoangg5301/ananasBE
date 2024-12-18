package com.example.ananasstore.controller;

import com.example.ananasstore.nxtrans.aop.permission.CheckApiKey;
import com.example.ananasstore.service.TestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestController {
    TestService testService;

    @GetMapping("/test-apikey")
    @CheckApiKey
    public String testApiKey(@RequestParam("testV") String testV,
                             @RequestParam("testValue") String testValue
    ) {
        return "Hello World";
    }

    @GetMapping("test-exception")
    public String testException(@RequestParam String testV,
                                String apiKey,
                                String testValue) {
        testService.testExceptionHandle();
        return "hello world!";
    }
}
