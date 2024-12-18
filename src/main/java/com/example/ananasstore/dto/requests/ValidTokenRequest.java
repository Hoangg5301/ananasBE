package com.example.ananasstore.dto.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ValidTokenRequest {
    private String token;
}
