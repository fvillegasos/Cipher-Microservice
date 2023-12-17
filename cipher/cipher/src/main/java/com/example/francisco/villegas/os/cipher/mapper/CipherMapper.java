package com.example.francisco.villegas.os.cipher.mapper;

import org.openapitools.model.AesOtk;
import org.openapitools.model.TextOut;

public class CipherMapper {

    public static AesOtk generateAesOtk(String otk) {
        var aesOtk = new AesOtk();
        aesOtk.setOtk(otk);
        return aesOtk;
    }

    public static TextOut generateTextOut(String text) {
        var textOut = new TextOut();
        textOut.setText(text);
        return textOut;
    }

}
