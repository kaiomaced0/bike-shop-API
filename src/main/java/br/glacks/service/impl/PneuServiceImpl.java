package br.glacks.service.impl;

import br.glacks.dto.PneuDTO;
import br.glacks.dto.ProdutoAdminResponseDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.Cor;
import br.glacks.model.EntityClass;
import br.glacks.model.Produto;
import br.glacks.model.bike.Pneu;
import br.glacks.repository.MarcaRepository;
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

    @Inject
    MarcaRepository marcaRepository;
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
            Pneu pneu = PneuDTO.criaPneu(c);
            pneu.setMarca(marcaRepository.findById(c.idMarca()));
            pneu.setCor(Cor.valueOf(c.idCor().intValue()));
            repository.persist(pneu);
            return Response.ok(new ProdutoResponseDTO(pneu)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response update(Long id, ProdutoDTO produto) {
        try {

            Pneu entity = repository.findById(id);
            if(produto.nome() != null)
                entity.setNome(produto.nome());
            if(produto.idMarca() != null)
                entity.setMarca(marcaRepository.findById(produto.idMarca()));
            if(produto.nomeLongo() != null)
                entity.setNomeLongo(produto.nomeLongo());
            if(produto.valorCompra() != null)
                entity.setValorCompra(produto.valorCompra());
            if(produto.preco() != null)
                entity.setPreco(produto.preco());
            if(produto.estoque() != null)
                entity.setEstoque(produto.estoque());
            return Response.ok(new ProdutoResponseDTO(entity)).build();
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
