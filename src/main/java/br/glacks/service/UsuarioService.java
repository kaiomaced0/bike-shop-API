package br.glacks.service;

    import java.util.List;

    import br.glacks.dto.*;
    import jakarta.ws.rs.PathParam;
    import jakarta.ws.rs.core.Response;

    import br.glacks.model.Usuario;

    public interface UsuarioService {
        
        public List<UsuarioResponseDTO> getAll();

        public Response getId(@PathParam("id") long id);

        public Usuario findByLoginAndSenha(String login, String senha);

        public UsuarioResponseDTO findByLogin(String login);

        Response update(Long id, PessoaFisicaDTO u);

        public List<UsuarioResponseDTO> getNome(@PathParam("nome") String nome);

        public UsuarioResponseDTO updateEmail(Long id, UsuarioUpdateEmailDTO email);

        public UsuarioResponseDTO updateNome(Long id, UsuarioUpdateNomeDTO nome);

        public UsuarioResponseDTO updateLogin(Long id, UsuarioUpdateLoginDTO login);

        public UsuarioResponseDTO updateSenha(Long id, UsuarioUpdateSenhaDTO senha);

        public Response insert(PessoaFisicaDTO p);

        public UsuarioResponseDTO updateImagem(long id, String imageForm);
        
        public Response delete(@PathParam("id") Long id);

        public Response resetarSenha(Long id);

    
}
