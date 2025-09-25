package com.transfert.transfert_argent.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String motDePasse;
}
