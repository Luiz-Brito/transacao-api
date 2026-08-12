package com.luiz.transacao_api.exceptions;

public class UnprocessableContent extends RuntimeException {
    public UnprocessableContent(String message) {
        super(message);
    }
}
