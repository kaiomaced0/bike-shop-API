package br.glacks.service.impl;

import br.glacks.dto.CarrosselResponseDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.EntityClass;
import br.glacks.model.HomeConfig;
import br.glacks.repository.HomeConfigRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HomeConfigService {

    @Inject
    HomeConfigRepository repository;

    public Response getDestaques(){
        try{
            HomeConfig h = repository.findById(1L);
            if(h.getProdutosDestaque().isEmpty())
                throw new Exception("");
            return Response.ok(h.getProdutosDestaque().stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId))
                    .map(ProdutoResponseDTO::new)
                    .collect(Collectors.toList())).build();

        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();

        }
    }

    public Response getCarrossel(){
        try{
            HomeConfig h = repository.findById(1L);
            if(h.getListaCarrosel().isEmpty())
                throw new Exception("");
            return Response.ok(h.getListaCarrosel().stream().map(CarrosselResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();

        }
    }

}
