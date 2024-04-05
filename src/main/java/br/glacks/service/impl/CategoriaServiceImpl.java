package br.glacks.service.impl;

import br.glacks.dto.CategoriaDTO;
import br.glacks.dto.CategoriaResponseDTO;
import br.glacks.model.Categoria;
import br.glacks.model.EntityClass;
import br.glacks.repository.CategoriaRepository;
import br.glacks.service.CategoriaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.stream.Collectors;

@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService {
    @Inject
    CategoriaRepository repository;
    @Override
    public Response getAll() {
        try {
            return Response.ok(repository.findAll().stream().filter(EntityClass::getAtivo).map(CategoriaResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    public Response getId(Long id) {
        try{
            return Response.ok(new CategoriaResponseDTO(repository.findById(id))).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response insert(CategoriaDTO c) {
        try{
            Categoria categoria = CategoriaDTO.criaCategoria(c);
            repository.persist(categoria);
            return Response.ok(new CategoriaResponseDTO(categoria)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response update(Long id, CategoriaDTO c) {
        try {
            Categoria categoria = repository.findById(id);
            categoria.setNome(c.nome());
            return Response.ok(new CategoriaResponseDTO(categoria)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            Categoria categoria = repository.findById(id);
            categoria.setAtivo(false);
            return Response.ok().build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}
