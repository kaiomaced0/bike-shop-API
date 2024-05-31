package br.glacks.service;

import br.glacks.dto.*;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.form.ImageForm;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface UsuarioLogadoService {

    public UsuarioResponseDTO updateSenha(UsuarioUpdateSenhaDTO senha);
    
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login);
    
    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome);

    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email);

    public Response getGostei();

    public Response gosteiInsert(@PathParam("id") long id);

    public Response gosteiDelete(@PathParam("id") Long id);

    public Response telefoneInsert(TelefoneUsuarioLogadoDTO telefoneUsuarioLogadoDTO);
    
    public PessoaFisicaResponseDTO getPerfilUsuarioLogado();

    public Response deleteOn();

    public Response salvarImagem(@MultipartForm ImageForm form);

    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem);

    public Response insertEndereco(EnderecoDTO endereco);
}
