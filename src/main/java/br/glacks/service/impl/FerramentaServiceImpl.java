package br.glacks.service.impl;

import br.glacks.dto.FerramentaDTO;
import br.glacks.dto.ProdutoAdminResponseDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.Categoria;
import br.glacks.model.Cor;
import br.glacks.model.EntityClass;
import br.glacks.model.Ferramenta;
import br.glacks.model.bike.Freio;
import br.glacks.repository.CategoriaRepository;
import br.glacks.repository.FerramentaRepository;
import br.glacks.repository.MarcaRepository;
import br.glacks.service.FerramentaService;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@ApplicationScoped
public class FerramentaServiceImpl implements FerramentaService {

    @Inject
    FerramentaRepository repository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    ProdutoService produtoService;

    @Inject
    CategoriaRepository categoriaRepository;

    @Override
    public Response getAll(int page, int pageSize) {
        try {
            return Response.ok(repository.findAll().page(page, pageSize).stream()
                    .sorted(Comparator.comparing(EntityClass::getId).reversed()).map(ProdutoResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Override
    public long count() {
        try {
            return repository.findAll()
                    .stream().filter(EntityClass::getAtivo)
                    .toList().size();

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Response getAllAdmin(int page, int pageSize) {
        try {
            return Response.ok(repository.findAll().page(page, pageSize).stream().filter(EntityClass::getAtivo).map(ProdutoAdminResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Override
    public Response getId(Long id) {
        try {
            return Response.ok(new ProdutoAdminResponseDTO(repository.findById(id))).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Transactional
    @Override
    public Response insert(ProdutoDTO m) {
        try {
            Ferramenta ferramenta = FerramentaDTO.criaFerramenta(m);
            ferramenta.setCor(Cor.valueOf(m.idCor().intValue()));
            ferramenta.setMarca(marcaRepository.findById(m.idMarca()));
            Categoria c = categoriaRepository.findByNome("Ferramenta");
            ferramenta.setCategorias(new ArrayList<>());
            ferramenta.getCategorias().add(c);
            repository.persist(ferramenta);
            return Response.ok(new ProdutoResponseDTO(ferramenta)).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Transactional
    @Override
    public Response update(Long id, ProdutoDTO m) {
            return produtoService.update(id, m);
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            return produtoService.delete(id);
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}
