package br.glacks.service.impl;

import br.glacks.dto.FreioDTO;
import br.glacks.dto.FreioResponseDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.EntityClass;
import br.glacks.model.bike.Freio;
import br.glacks.repository.FreioRepository;
import br.glacks.service.FreioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.Comparator;
import java.util.stream.Collectors;

@ApplicationScoped
public class FreioServiceImpl implements FreioService {
    @Inject
    FreioRepository repository;
    @Override
    public Response getAll(int page, int pageSize) {
        try {
            return Response.ok(repository.findAll().page(page, pageSize).stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed()).map(FreioResponseDTO::new).collect(Collectors.toList())).build();
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
    public Response getId(Long id) {
        try{
            return Response.ok(new FreioResponseDTO(repository.findById(id))).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response insert(FreioDTO c) {
        try{
            Freio Freio = FreioDTO.criaFreio(c);
            repository.persist(Freio);
            return Response.ok(new FreioResponseDTO(Freio)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response update(Long id, FreioDTO f) {
        try {
            Freio Freio = repository.findById(id);
            Freio.setNome(f.nome());
            return Response.ok(new FreioResponseDTO(Freio)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            Freio Freio = repository.findById(id);
            Freio.setAtivo(false);
            return Response.ok().build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}
