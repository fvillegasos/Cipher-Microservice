package com.example.francisco.villegas.os.cipher.service;

import com.example.francisco.villegas.os.cipher.exception.CipherException;
import com.example.francisco.villegas.os.cipher.mapper.CipherMapper;
import org.openapitools.model.TextIn;
import org.openapitools.model.TextOut;
import org.springframework.stereotype.Service;

@Service
public class AESCipherService {

    private final CipherMapper mapper;

    public AESCipherService(CipherMapper mapper) {
        this.mapper = mapper;
    }

    public TextOut cipher(TextIn textIn) throws CipherException {
        try {
            //TODO
            return mapper.generateTextOut(null);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }

    public TextOut decipher(TextIn textIn) throws CipherException {
        try {
            //TODO
            return mapper.generateTextOut(null);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }
}
