package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.AvaliacaoDTO;
import br.glacks.dto.AvaliacaoResponseDTO;
import br.glacks.model.Avaliacao;
import br.glacks.repository.AvaliacaoRepository;
import br.glacks.repository.ProdutoRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.AvaliacaoService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Inject
    AvaliacaoRepository repository;

    @Inject
    UsuarioRepository uRepository;

    @Inject
    ProdutoRepository pRepository;
    
    @Override
    public List<AvaliacaoResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(avaliacao -> new AvaliacaoResponseDTO(avaliacao))
            .collect(Collectors.toList());
        
    }

    @Override
    public AvaliacaoResponseDTO getId(long id){ 
        return new AvaliacaoResponseDTO(repository.findById(id));
        
    }

    @Override
    @Transactional
    public Response insert(AvaliacaoDTO avaliacao){
        Avaliacao a = AvaliacaoDTO.criAvaliacao(avaliacao);
        a.setUsuario(uRepository.findById(a.getUsuario().getId()));
        a.setProduto(pRepository.findById(a.getProduto().getId()));
        repository.persist(a);
        return Response.ok(avaliacao).build();
    }

    @Override
    @Transactional
    public Avaliacao update(long id, Avaliacao avaliacao){
        Avaliacao entity = repository.findById(id);
        entity.setNome(avaliacao.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
