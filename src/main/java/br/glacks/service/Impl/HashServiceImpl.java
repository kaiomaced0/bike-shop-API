package br.glacks.service.Impl;

import javax.crypto.SecretKeyFactory;

import br.glacks.service.HashService;

public class HashServiceImpl implements HashService{

    private String salt = "#blahhxyz9232";
    private Integer iterationCount = 233;
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
    
}
