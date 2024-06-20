package br.glacks.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
import br.glacks.repository.ProdutoRepository;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.CupomDTO;
import br.glacks.dto.CupomResponseDTO;
import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;
import br.glacks.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    public static final Logger LOG = Logger.getLogger(CupomServiceImpl.class);

    @Inject
    CupomRepository repository;

    @Inject
    ProdutoRepository produtoRepository;

    @Override
    public List<CupomResponseDTO> getAll(int page, int pageSize) {
        try {
            LOG.info("Requisição Cupom.getAll()");
            return repository.findAll().page(page, pageSize).stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed()).map(CupomResponseDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getAll()");
            return null;
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
    public CupomResponseDTO getId(long id) {
        try {
            LOG.info("Requisição Cupom.getId()");
            return new CupomResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getId()");
            return null;
        }

    }

    @Override
    public List<CupomResponseDTO> getNome(String nome) {
        try {
            LOG.info("Requisição Cupom.getNome()");
            return repository.findByNome(nome).stream().map(CupomResponseDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getNome()");
            return null;
        }

    }

    @Override
    public CupomResponseDTO getCodigo(String codigo) {
        try {
            Cupom c = repository.findByCodigo(codigo);
            LOG.info("Requisição Cupom.getCodigo()");
            return new CupomResponseDTO(c);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getCodigo()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(CupomDTO cupom) {
        try {
            LOG.info("Requisição Cupom.insert()");
            Cupom c = CupomDTO.criaCupom(cupom);
            c.setProdutos(new ArrayList<>());
            if(!cupom.produtos().isEmpty()){
                cupom.produtos().stream().forEach(produtoId -> {
                    c.getProdutos().add(produtoRepository.findById(produtoId));
                });
            }
            if(c.getValorDesconto() < 50.0 && c.getValorDesconto() > 0){
                repository.persist(c);
            }
            else{
                throw new Exception("Valor de desconto muito alto!");
            }

            return Response.ok(new CupomResponseDTO(c)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.insert()");
            return Response.status(400).entity(e).build();
        }

    }

    @Override
    @Transactional
    public Response update(long id, CupomDTO cupom) {
        try {
            LOG.info("Requisição Cupom.update()");
            Cupom entity = repository.findById(id);
            entity.setNome(cupom.nome());
            entity.setCodigo(cupom.codigo());
            entity.setQuantidade(cupom.quantidade());
            if(cupom.valorDesconto() < 50.0 && cupom.valorDesconto() > 0){
                entity.setValorDesconto(cupom.valorDesconto());
            }
            return Response.ok(new CupomResponseDTO(entity)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.update()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Cupom.delete()");
            Cupom entity = repository.findById(id);
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.delete()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    public Cupom isActive(String id) {
        Cupom cupom = repository.findByCodigo(id);
        if(cupom.getAtivo()){
            return cupom;
        }else {
            return null;
        }
    }


}
