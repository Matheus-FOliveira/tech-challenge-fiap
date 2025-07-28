package com.postech.techchallenge.application.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userLogin;
    private String senha;
}
