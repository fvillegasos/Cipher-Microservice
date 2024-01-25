package com.example.francisco.villegas.os.cipher.service;

import com.example.francisco.villegas.os.cipher.exception.CipherException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.openapitools.model.TextIn;

class AESCipherServiceTest {

    private final static String TEST_OTK = "k69LkQB2xCzhDMiWzPRwu+XmRQS+QjXd";
    private final static String TEST_TEXT = "Hello world!";

    @InjectMocks
    AESCipherService aesCipherService;

    @BeforeEach
    void setUp() {
        aesCipherService = new AESCipherService();
    }

    @Test
    void generateOtk() throws CipherException {
        var otk = aesCipherService.generateOtk();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(otk),
                () -> Assertions.assertNotNull(otk.getOtk()),
                () -> Assertions.assertEquals(32, otk.getOtk().length())
        );
    }

    @Test
    void cipherAndDecipher() throws CipherException {
        var cipheredText = aesCipherService.cipher(generateTextIn(TEST_TEXT));
        var decipheredText = aesCipherService.decipher(generateTextIn(cipheredText.getText()));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(decipheredText),
                () -> Assertions.assertNotNull(decipheredText.getText()),
                () -> Assertions.assertEquals(TEST_TEXT, decipheredText.getText())
        );
    }

    private TextIn generateTextIn(String text) {
        var textIn = new TextIn();
        textIn.setOtk(TEST_OTK);
        textIn.setText(text);
        return textIn;
    }


}