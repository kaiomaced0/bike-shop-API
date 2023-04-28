package br.glacks.service;

    import java.util.List;

    import javax.ws.rs.PathParam;
    import javax.ws.rs.core.Response;

    import br.glacks.dto.UsuarioDTO;
    import br.glacks.dto.UsuarioResponseDTO;
    import br.glacks.model.Usuario;

    public interface UsuarioService {
        
        public List<UsuarioResponseDTO> getAll();

        public Usuario getId(@PathParam("id") long id);

        public List<UsuarioResponseDTO> getNome(@PathParam("nome") String nome);

        public Response insert(UsuarioDTO usuarioDTO);

        public UsuarioResponseDTO update(@PathParam("id") long id, UsuarioDTO usuario);
        
        public Response delete(@PathParam("id") Long id);
    
}
