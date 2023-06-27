package br.glacks.service;

    import java.util.List;

    import jakarta.ws.rs.PathParam;
    import jakarta.ws.rs.core.Response;

    import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.dto.UsuarioUpdateDTO;
import br.glacks.dto.UsuarioUpdateEmailDTO;
import br.glacks.dto.UsuarioUpdateLoginDTO;
import br.glacks.dto.UsuarioUpdateNomeDTO;
import br.glacks.dto.UsuarioUpdateSenhaDTO;
import br.glacks.model.Usuario;

    public interface UsuarioService {
        
        public List<UsuarioResponseDTO> getAll();

        public Usuario getId(@PathParam("id") long id);

        public Usuario findByLoginAndSenha(String login, String senha);

        public UsuarioResponseDTO findByLogin(String login);

        public List<UsuarioResponseDTO> getNome(@PathParam("nome") String nome);

        public UsuarioResponseDTO updateEmail(Long id, UsuarioUpdateEmailDTO email);

        public UsuarioResponseDTO updateNome(Long id, UsuarioUpdateNomeDTO nome);

        public UsuarioResponseDTO updateLogin(Long id, UsuarioUpdateLoginDTO login);

        public UsuarioResponseDTO updateSenha(Long id, UsuarioUpdateSenhaDTO senha);

        public Response insert(UsuarioDTO usuarioDTO);

        public UsuarioResponseDTO updateImagem(long id, String imageForm);
        
        public Response delete(@PathParam("id") Long id);

    
}
