package com.example.ananasstore.dto.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ValidTokenResponse {
    private boolean valid;
}