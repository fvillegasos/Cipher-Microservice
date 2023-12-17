package com.example.francisco.villegas.os.cipher.util;

import java.util.Base64;

public class Base64Utils {

    public static String fromBytesToEncodedString(byte[] bytes) {
        return Base64.getEncoder().withoutPadding().encodeToString(bytes);
    }

    public static byte[] fromStringToDecodedBytes(String string) {
        var bytes = string.getBytes();
        return Base64.getDecoder().decode(bytes);
    }

}
