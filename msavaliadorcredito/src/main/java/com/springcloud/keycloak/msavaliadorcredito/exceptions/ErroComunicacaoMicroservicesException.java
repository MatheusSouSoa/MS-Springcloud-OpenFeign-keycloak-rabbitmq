package com.springcloud.keycloak.msavaliadorcredito.exceptions;

import lombok.Getter;

@Getter
public class ErroComunicacaoMicroservicesException extends  Exception{

    private Integer status;

    public ErroComunicacaoMicroservicesException (String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
