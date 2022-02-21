package br.com.etec.sw2.produto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.etec.sw2.produto.models.ProdutoModel;

@Repository
public interface ProdutoRepository
        extends JpaRepository<ProdutoModel, UUID> {

    boolean existsByCodigoDeBarras(String codigoDeBarras);

    boolean existsByDescricao(String Descricao);
}
