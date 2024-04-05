package br.glacks.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Cor;
import br.glacks.model.Marca;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;
import br.glacks.repository.MarcaRepository;
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

    @Inject
    MarcaRepository marcaRepository;


    @Override
    public Response getAll(){
        try {
            LOG.info("Requisição Bike.getAll()");
            return Response.ok(repository.findAll()
                    .stream()
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
            Bike b = BikeDTO.criaBike(bike);
            b.setMarca(marcaRepository.findById(bike.produto().idMarca()));
            b.setTipoBike(TipoBike.valueOf(bike.idTipoBike().intValue()));
            b.setTamanho(Tamanho.valueOf(bike.idTamanho().intValue()));
            b.setCor(Cor.valueOf(bike.produto().idCor().intValue()));
            repository.persist(b);
            return Response.ok(new BikeResponseDTO(b)).build();

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

            if (bike.produto().nome() != null) {
                entity.setNome(bike.produto().nome());
            }
            if (bike.produto().nomeLongo() != null) {
                entity.setNomeLongo(bike.produto().nomeLongo());
            }
            if (bike.produto().precoVenda() != null) {
                entity.setPreco(bike.produto().precoVenda());
            }
            if (bike.produto().precoCusto() != null) {
                entity.setValorCompra(bike.produto().precoCusto());
            }
            if (bike.produto().idCor() != null) {
                entity.setCor(Cor.valueOf(bike.produto().idCor().intValue()));
            }
            if (bike.produto().estoque() != null) {
                entity.setEstoque(bike.produto().estoque());
            }
            if (bike.produto().idMarca() != null) {
                Marca m = marcaRepository.findById(bike.produto().idMarca());
                entity.setMarca(m);
            }

            if (bike.marcha() != null) {
                entity.setMarcha(bike.marcha());
            }
            if (bike.idTamanho() != null) {
                entity.setTamanho(Tamanho.valueOf(bike.idTamanho().intValue()));
            }
            if (bike.idTipoBike() != null) {
                entity.setTipoBike(TipoBike.valueOf(bike.idTipoBike().intValue()));
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