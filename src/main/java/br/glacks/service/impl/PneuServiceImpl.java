package br.glacks.service.impl;

import br.glacks.dto.PneuDTO;
import br.glacks.dto.ProdutoAdminResponseDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.EntityClass;
import br.glacks.model.bike.Pneu;
import br.glacks.repository.PneuRepository;
import br.glacks.service.PneuService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.stream.Collectors;

@ApplicationScoped
public class PneuServiceImpl implements PneuService {
    @Inject
    PneuRepository repository;
    @Override
    public Response getAll() {
        try {
            return Response.ok(repository.findAll().stream().filter(EntityClass::getAtivo).map(ProdutoResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    public Response getAllAdmin() {
        try {
            return Response.ok(repository.findAll().stream().filter(EntityClass::getAtivo).map(ProdutoAdminResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    public Response getId(Long id) {
        try{
            return Response.ok(new ProdutoResponseDTO(repository.findById(id))).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response insert(ProdutoDTO c) {
        try{
            Pneu Pneu = PneuDTO.criaPneu(c);
            repository.persist(Pneu);
            return Response.ok(new ProdutoResponseDTO(Pneu)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response update(Long id, ProdutoDTO c) {
        try {
            Pneu Pneu = repository.findById(id);
            Pneu.setNome(c.nome());
            return Response.ok(new ProdutoResponseDTO(Pneu)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
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
