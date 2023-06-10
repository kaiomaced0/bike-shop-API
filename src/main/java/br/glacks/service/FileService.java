package br.glacks.service;

import java.io.File;
import java.io.IOException;

public interface FileService {

    public String salvarImagemUsuario(byte[] imagem, String nomeImagem) throws IOException;

    public String salvarImagemProduto(byte[] imagem, String nomeImagem) throws IOException;

    public File download(String nomeArquivo);
}