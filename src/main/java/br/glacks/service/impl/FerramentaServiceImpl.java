package br.glacks.service.impl;

import br.glacks.dto.FerramentaDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.Cor;
import br.glacks.model.Ferramenta;
import br.glacks.repository.FerramentaRepository;
import br.glacks.repository.MarcaRepository;
import br.glacks.service.FerramentaService;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.stream.Collectors;

@ApplicationScoped
public class FerramentaServiceImpl implements FerramentaService {

    @Inject
    FerramentaRepository repository;

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    ProdutoService produtoService;

    @Override
    public Response getAll() {
        try {
            return Response.ok(repository.findAll().stream().map(ProdutoResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Override
    public Response getId(Long id) {
        try {
            return Response.ok(new ProdutoResponseDTO(repository.findById(id))).build();
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
}
