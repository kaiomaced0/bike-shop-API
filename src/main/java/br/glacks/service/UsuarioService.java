package br.glacks.service;

    import java.util.List;

    import jakarta.ws.rs.PathParam;
    import jakarta.ws.rs.core.Response;

    import br.glacks.dto.UsuarioDTO;
    import br.glacks.dto.UsuarioResponseDTO;
    import br.glacks.model.Usuario;

    public interface UsuarioService {
        
        public List<UsuarioResponseDTO> getAll();

        public Usuario getId(@PathParam("id") long id);

        public Usuario findByLoginAndSenha(String login, String senha);

        public UsuarioResponseDTO findByLogin(String login);

        public Usuario findByLoginUsuarioLogado(String login);

        public List<UsuarioResponseDTO> getNome(@PathParam("nome") String nome);

        public Response insert(UsuarioDTO usuarioDTO);

        public UsuarioResponseDTO update(@PathParam("id") long id, UsuarioDTO usuario);

        public UsuarioResponseDTO updateOn(@PathParam("chave") String chave, UsuarioDTO usuario);

        public UsuarioResponseDTO updateImagem(long id, String imageForm);
        
        public Response delete(@PathParam("id") Long id);
    
}
