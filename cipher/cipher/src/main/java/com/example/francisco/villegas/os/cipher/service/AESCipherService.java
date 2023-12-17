package com.example.francisco.villegas.os.cipher.service;

import com.example.francisco.villegas.os.cipher.constant.CipherConstants;
import com.example.francisco.villegas.os.cipher.exception.CipherException;
import com.example.francisco.villegas.os.cipher.mapper.CipherMapper;
import com.example.francisco.villegas.os.cipher.util.Base64Utils;
import org.openapitools.model.AesOtk;
import org.openapitools.model.TextIn;
import org.openapitools.model.TextOut;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@Service
public class AESCipherService {

    public AesOtk generateOtk() throws CipherException {
        try {
            var keyGenerator = KeyGenerator.getInstance(CipherConstants.AES);
            keyGenerator.init(CipherConstants.AES_KEY_LENGTH);
            var key = keyGenerator.generateKey();
            var otk = Base64Utils.FromBytesToEncodedString(key.getEncoded());
            return CipherMapper.generateAesOtk(otk);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }

    public TextOut cipher(TextIn textIn) throws CipherException {
        try {
            //TODO
            return CipherMapper.generateTextOut(null);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }

    public TextOut decipher(TextIn textIn) throws CipherException {
        try {
            //TODO
            return CipherMapper.generateTextOut(null);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }
}
