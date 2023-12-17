package com.example.francisco.villegas.os.cipher.exception;

import com.example.francisco.villegas.os.cipher.Log.CipherLog;

public class CipherException extends Exception {
    public CipherException(String message) {
        super(message);
    }

    public static CipherException of(Exception ex) {
        CipherLog.printError(ex.getMessage());
        return new CipherException(ex.getMessage());
    }
}
