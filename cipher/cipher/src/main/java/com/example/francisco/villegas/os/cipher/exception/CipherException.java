package com.example.francisco.villegas.os.cipher.exception;

public class CipherException extends Exception {
    public CipherException(String message) {
        super(message);
    }

    public static CipherException of(Exception ex) {
        return new CipherException(ex.getMessage());
    }
}
