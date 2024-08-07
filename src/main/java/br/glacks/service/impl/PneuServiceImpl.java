package br.glacks.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import br.glacks.dto.PneuDTO;
import br.glacks.dto.ProdutoAdminResponseDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.Categoria;
import br.glacks.model.Cor;
import br.glacks.model.EntityClass;
import br.glacks.model.bike.Pneu;
import br.glacks.repository.CategoriaRepository;
import br.glacks.repository.MarcaRepository;
import br.glacks.repository.PneuRepository;
import br.glacks.service.PneuService;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PneuServiceImpl implements PneuService {
    @Inject
    PneuRepository repository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    ProdutoService produtoService;

    @Inject
    CategoriaRepository categoriaRepository;

    @Override
    public Response getAll(int page, int pageSize) {
        try {
            return Response.ok(repository.findAll().page(page, pageSize).stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed())
                    .map(ProdutoResponseDTO::new)
                    .collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
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
            return Response.ok(repository.findAll().page(page, pageSize).stream()
            .filter(EntityClass::getAtivo)
            .sorted(Comparator.comparing(EntityClass::getId).reversed())
            .map(ProdutoAdminResponseDTO::new)
            .collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    public Response getId(Long id) {
        try{
            return Response.ok(new ProdutoAdminResponseDTO(repository.findById(id))).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response insert(ProdutoDTO produto) {
        try {
            Pneu p = PneuDTO.criaPneu(produto);
            p.setMarca(marcaRepository.findById(produto.idMarca()));
            p.setCor(Cor.valueOf(produto.idCor().intValue()));
            p.setCategorias(new ArrayList<>());
            Categoria c = categoriaRepository.findByNome("Pneu");
            p.getCategorias().add(c);
            repository.persist(p);
            return Response.ok(new ProdutoResponseDTO(p)).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public Response update(Long id, ProdutoDTO produto) {
        return produtoService.update(id, produto);
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            Pneu Pneu = repository.findById(id);
            Pneu.setAtivo(false);
            return Response.ok().build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}
