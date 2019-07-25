package com.sp.admin.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.sp.commons.exception.EncryptionDecryptionException;

@Service
public class EncryptDecryptServiceImpl implements EncryptDecryptService {

	private static SecretKeySpec secretKeySpec;
    private static final String ALGORITHM="AES";
    
	public static void setKey(final String useKey) throws NoSuchAlgorithmException {
		MessageDigest sha = null;
		byte[] key = null;
		key = useKey.getBytes(StandardCharsets.UTF_8);
		sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16);
		secretKeySpec = new SecretKeySpec(key, ALGORITHM);
	}

	@Override
	public String encrypt(final String plainText, final String secretKey) {
		String encryptMessage = null;
		try
        {
            setKey(secretKey);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            encryptMessage = Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e){
           throw new EncryptionDecryptionException("Problem While Encryption");
        }
        return encryptMessage;
	}

	@Override
	public String decrypt(final String cipherText, final String secretKey) {
		String decryptMessage = null;
		try{
            setKey(secretKey);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            decryptMessage = new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        }
        catch (Exception e){
            throw new EncryptionDecryptionException("Problem While Deryption");
        }
        return decryptMessage;
	}

}
