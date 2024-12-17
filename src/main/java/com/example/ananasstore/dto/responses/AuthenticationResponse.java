package com.example.ananasstore.dto.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AuthenticationResponse {
    String token;
    private boolean authenticated;
}
