/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josee
 */
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class AlgoSHA256 {
    public String encriptionFunc(String secretKey, String string) {
        String encryptedProduct = "";
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] key_word = sha256.digest(secretKey.getBytes(StandardCharsets.UTF_8));
            byte[] keyBytesBased = Arrays.copyOf(key_word, 24);
            SecretKey key = new SecretKeySpec(keyBytesBased, "DESede");
            Cipher cypherText = Cipher.getInstance("DESede");
            cypherText.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = string.getBytes(StandardCharsets.UTF_8);
            byte[] auxBuffer = cypherText.doFinal(plainTextBytes);
            String base64Bytes = Base64.getEncoder().encodeToString(auxBuffer);
            encryptedProduct = new String(base64Bytes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        return encryptedProduct;
    }

    public String desencryptionFunc(String secretKey, String encodedString) {
        String desencryptedString = "";
        try {
            byte[] sentence = Base64.getDecoder().decode(encodedString.getBytes(StandardCharsets.UTF_8));
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] keyDigested = sha256.digest(secretKey.getBytes(StandardCharsets.UTF_8));
            byte[] keyBytes = Arrays.copyOf(keyDigested, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "RSA/ECB/OAEPWithSHA-256AndMGF1Padding ");
            Cipher decrypter = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding ");
            decrypter.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decrypter.doFinal(sentence);
            desencryptedString = new String(plainText, StandardCharsets.UTF_8);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        return desencryptedString;
    }
}