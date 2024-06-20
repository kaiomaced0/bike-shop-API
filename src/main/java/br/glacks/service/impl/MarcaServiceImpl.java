package br.glacks.service.impl;

import br.glacks.dto.MarcaDTO;
import br.glacks.dto.MarcaResponseDTO;
import br.glacks.model.EntityClass;
import br.glacks.model.Marca;
import br.glacks.model.bike.Freio;
import br.glacks.repository.MarcaRepository;
import br.glacks.service.MarcaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.Comparator;
import java.util.stream.Collectors;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    MarcaRepository repository;

    @Override
    public Response getAll() {
        try {
            return Response.ok(repository.findAll().stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed()).map(MarcaResponseDTO::new).collect(Collectors.toList())).build();
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
            return Response.ok(repository.findAll().page(page, pageSize).stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed()).map(MarcaResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Override
    public Response getId(Long id) {
        try {
            return Response.ok(new MarcaResponseDTO(repository.findById(id))).build();
        }catch (Exception e){
            return Response.status(400).build();
        }
    }

    @Transactional
    @Override
    public Response insert(MarcaDTO m) {
        try {
            Marca marca = MarcaDTO.criaMarca(m);
            repository.persist(marca);
            return Response.ok(new MarcaResponseDTO(marca)).build();
        }catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @Transactional
    @Override
    public Response update(Long id, MarcaDTO m) {
        try {
            Marca marca = repository.findById(id);
            marca.setNome(m.nome());
            return Response.ok(new MarcaResponseDTO(marca)).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            Marca marca = repository.findById(id);
            marca.setAtivo(false);
            return Response.ok(new MarcaResponseDTO(marca)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}
