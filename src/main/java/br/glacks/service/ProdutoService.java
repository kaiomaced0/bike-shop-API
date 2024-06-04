package br.glacks.service;
import java.util.List;

import br.glacks.dto.ProdutoAdminResponseDTO;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.form.ImageForm;
import br.glacks.model.Produto;

public interface ProdutoService {
    
    public List<ProdutoResponseDTO> getAll();
    public List<ProdutoAdminResponseDTO> getAllAdmin();

    public ProdutoResponseDTO getId(@PathParam("id") long id);

    public ProdutoAdminResponseDTO getIdAdmin(Long id);

    public Response listIds(List<Long> listaProdutos);

    public Response getNome(@PathParam("nome") String nome);

    public Response insert(ProdutoDTO produtoDTO);

    public Response update(@PathParam("id") long id, ProdutoDTO produto);
    
    public Response delete(@PathParam("id") Long id);

    public Response retiraEstoque(@PathParam("id") Long id, int quantidade);
    
    public Response adicionaEstoque(@PathParam("id") Long id, int quantidade);

    public Response salvarImagem(@MultipartForm ImageForm form);
}
