package com.example.ananasstore;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class Test {
    public static void main(String[] args) {
        String a = null;
        String b = "b";
        if( b.equals(a)){
            System.out.println("a==b");
        }
    }
}
