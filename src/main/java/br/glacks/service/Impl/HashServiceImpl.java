package br.glacks.service.Impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import br.glacks.service.HashService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HashServiceImpl implements HashService{

    private String salt = "#blahhxyz9232";
    private Integer iterationCount = 223;
    private Integer keylength = 512;

    @Override
    public String getHashSenha(String senha) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(
                            new PBEKeySpec(senha.toCharArray(), salt.getBytes(), iterationCount, keylength)
                        )
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        HashService service = new HashServiceImpl();
        System.out.println();
        System.out.println(service.getHashSenha("123"));
    }
    //cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==
}

