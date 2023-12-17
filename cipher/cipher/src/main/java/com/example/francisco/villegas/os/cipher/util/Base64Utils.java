package com.example.francisco.villegas.os.cipher.util;

import java.util.Base64;

public class Base64Utils {

    public static String FromBytesToEncodedString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
