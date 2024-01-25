package com.example.francisco.villegas.os.cipher.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    private Base64Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static byte[] decodeAndGenerateBytes(String string) {
        return Base64.getDecoder().decode(string);
    }

    public static String encodeAndGenerateString(byte[] bytes) {
        return fromBytesToString(Base64.getEncoder().encode(bytes));
    }

    public static String fromBytesToString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
