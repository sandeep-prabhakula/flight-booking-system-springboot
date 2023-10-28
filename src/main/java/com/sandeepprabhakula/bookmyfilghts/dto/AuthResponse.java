package com.sandeepprabhakula.bookmyfilghts.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class AuthResponse {
    private String jwtToken;
    private String uid;
    private String email;
}
