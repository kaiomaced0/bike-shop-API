package br.glacks.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.BikeDTO;
import br.glacks.dto.BikeResponseDTO;
import br.glacks.model.bike.Bike;
import br.glacks.repository.BikeRepository;
import br.glacks.service.BikeService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BikeServiceImpl implements BikeService {

    public static final Logger LOG = Logger.getLogger(BikeServiceImpl.class);


    @Inject
    BikeRepository repository;

    @Override
    public Response getAll(){
        try {
            LOG.info("Requisição Bike.getAll()");
            return Response.ok(repository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(bike -> bike.getId()))
                    .map(BikeResponseDTO::new)
                    .collect(Collectors.toList())).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.getAll()");
            return Response.status(Status.BAD_REQUEST).entity(e).build();
        }

    }

    @Override
    public Response getId(long id){
        try {
            LOG.info("Requisição Bike.getId()");
            Bike b = repository.findById(id);
            return Response.ok(new BikeResponseDTO(b)).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.getId()");
            return Response.status(Status.BAD_REQUEST).entity(e).build();

        }

    }

    @Override
    public Response getNome(String nome){
        try {
            LOG.info("Requisição Bike.getId()");
            List<Bike> b = repository.findByNome(nome);
            return Response.ok(b.stream().map(BikeResponseDTO::new).collect(Collectors.toList())).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.getNome()");
            return Response.status(Status.BAD_REQUEST).entity(e).build();

        }

    }

    @Override
    @Transactional
    public Response insert(BikeDTO bike){
        try {
            LOG.info("Requisição Bike.insert()");
            repository.persist(BikeDTO.criaBike(bike));
            return Response.ok(bike).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.insert()");
            return Response.status(Status.BAD_REQUEST).entity(e).build();
        }
    }

    @Override
    @Transactional
    public Response update(long id, BikeDTO bike) {
        try {
            LOG.info("Requisição Bike.update()");
            Bike entity = repository.findById(id);

            if (bike.nome() != null) {
                entity.setNome(bike.nome());
            }
            if (bike.nomeLongo() != null) {
                entity.setNomeLongo(bike.nomeLongo());
            }
            if (bike.preco() != null) {
                entity.setPreco(bike.preco());
            }
            if (bike.cor() != null) {
                entity.setCor(bike.cor());
            }
            if (bike.estoque() != null) {
                entity.setEstoque(bike.estoque());
            }
            if (bike.marca() != null) {
                entity.setMarca(bike.marca());
            }
            if (bike.observacao() != null) {
                entity.setObservacao(bike.observacao());
            }
            if (bike.marcha() != null) {
                entity.setMarcha(bike.marcha());
            }
            if (bike.tamanho() != null) {
                entity.setTamanho(bike.tamanho());
            }
            if (bike.tipoBike() != null) {
                entity.setTipoBike(bike.tipoBike());
            }

            return Response.ok(entity).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.update()", e);
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }


    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            Bike entity = repository.findById(id);
            entity.setAtivo(false);

            LOG.info("Requisição Bike.delete()");
            return Response.status(Status.OK).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.delete()");
            return Response.status(Status.BAD_REQUEST).entity(e).build();
            // TODO: handle exception
        }

    }

}