package com.example.francisco.villegas.os.cipher.util;

import com.example.francisco.villegas.os.cipher.constant.CipherConstants;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CipherUtils {

    public static Cipher generateCipherByAlgorithm(String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(algorithm);
    }

    public static SecretKeySpec generateAesKey(String keyStr) {
        return new SecretKeySpec(keyStr.getBytes(), CipherConstants.AES);
    }

    public static GCMParameterSpec generateRandomIv() {
        byte[] iv = new byte[CipherConstants.IV_LENGTH];
        new SecureRandom().nextBytes(iv);
        return generateIv(iv);
    }

    public static GCMParameterSpec generateIv(byte[] iv) {
        return new GCMParameterSpec(CipherConstants.T_LENGTH, iv);
    }

}
