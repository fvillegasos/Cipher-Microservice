package com.example.francisco.villegas.os.cipher.service;

import com.example.francisco.villegas.os.cipher.Log.CipherLog;
import com.example.francisco.villegas.os.cipher.constant.CipherConstants;
import com.example.francisco.villegas.os.cipher.exception.CipherException;
import com.example.francisco.villegas.os.cipher.mapper.CipherMapper;
import com.example.francisco.villegas.os.cipher.util.Base64Utils;
import com.example.francisco.villegas.os.cipher.util.CipherUtils;
import org.openapitools.model.AesOtk;
import org.openapitools.model.TextIn;
import org.openapitools.model.TextOut;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

@Service
public class AESCipherService {

    public AesOtk generateOtk() throws CipherException {
        try {
            var keyGenerator = KeyGenerator.getInstance(CipherConstants.AES);
            keyGenerator.init(CipherConstants.AES_KEY_LENGTH);
            var key = keyGenerator.generateKey();
            var otk = Base64Utils.fromBytesToEncodedString(key.getEncoded());
            return CipherMapper.generateAesOtk(otk);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }

    public TextOut cipher(TextIn textIn) throws CipherException {
        try {
            var input = textIn.getText().getBytes();

            var cipher = CipherUtils.generateCipherByAlgorithm(CipherConstants.AES_GCM);
            var key = CipherUtils.generateAesKey(textIn.getOtk());
            var iv = CipherUtils.generateRandomIv();

            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] cipheredText = cipher.doFinal(input);

            var encodedCipheredText = Base64Utils.fromBytesToEncodedString(cipheredText);
            CipherLog.print(encodedCipheredText);
            var encodedIv = Base64Utils.fromBytesToEncodedString(iv.getIV());
            CipherLog.print(encodedIv);
            var output = encodedIv.concat(encodedCipheredText);
            CipherLog.print(output);

            return CipherMapper.generateTextOut(output);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }

    public TextOut decipher(TextIn textIn) throws CipherException {
        try {
            var input = textIn.getText();
            var encodedIv = input.substring(0, CipherConstants.IV_LENGTH);
            CipherLog.print(encodedIv);
            var encodedCipheredText = input.substring(CipherConstants.IV_LENGTH);
            CipherLog.print(encodedCipheredText);

            var decodedIv = Base64Utils.fromStringToDecodedBytes(encodedIv);
            var cipheredText = Base64Utils.fromStringToDecodedBytes(encodedCipheredText);

            var cipher = CipherUtils.generateCipherByAlgorithm(CipherConstants.AES_GCM);
            var key = CipherUtils.generateAesKey(textIn.getOtk());
            var iv = CipherUtils.generateIv(decodedIv);

            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] decipheredText = cipher.doFinal(cipheredText);

            var encodedDecipheredText = Base64Utils.fromBytesToEncodedString(decipheredText);
            CipherLog.print(encodedDecipheredText);

            return CipherMapper.generateTextOut(encodedDecipheredText);
        } catch (Exception e) {
            throw CipherException.of(e);
        }
    }
}
