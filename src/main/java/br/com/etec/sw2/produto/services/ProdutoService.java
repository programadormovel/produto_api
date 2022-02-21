package br.com.etec.sw2.produto.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.etec.sw2.produto.models.ProdutoModel;
import br.com.etec.sw2.produto.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    // Ponto de Injeção
    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public ProdutoModel save(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public boolean existsByCodigoDeBarras(String codigoDeBarras) {
        return produtoRepository.existsByCodigoDeBarras(codigoDeBarras);
    }

    public boolean existsByDescricao(String descricao) {
        return produtoRepository.existsByDescricao(descricao);
    }

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> findById(UUID id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void delete(ProdutoModel produtoModel) {
        produtoRepository.delete(produtoModel);
    }
}
