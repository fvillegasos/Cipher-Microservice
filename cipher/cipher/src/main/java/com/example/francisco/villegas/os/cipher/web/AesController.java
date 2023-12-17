package com.example.francisco.villegas.os.cipher.web;

import com.example.francisco.villegas.os.cipher.exception.CipherException;
import com.example.francisco.villegas.os.cipher.service.AESCipherService;
import org.openapitools.api.AesApi;
import org.openapitools.model.AesOtk;
import org.openapitools.model.TextIn;
import org.openapitools.model.TextOut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AesController implements AesApi {

    private final AESCipherService aesCipherService;

    public AesController(AESCipherService aesCipherService) {
        this.aesCipherService = aesCipherService;
    }

    @Override
    public ResponseEntity<AesOtk> getAesOtk() {
        try {
            return ResponseEntity.ok(aesCipherService.generateOtk());
        } catch (CipherException ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<TextOut> getCipheredTextAes(TextIn textIn) {
        try {
            return ResponseEntity.ok(aesCipherService.cipher(textIn));
        } catch (CipherException ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<TextOut> getDecipheredTextAes(TextIn textIn) {
        try {
            return ResponseEntity.ok(aesCipherService.decipher(textIn));
        } catch (CipherException ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
