package br.com.etec.sw2.produto.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.sw2.produto.controllers.dtos.ProdutoDto;
import br.com.etec.sw2.produto.models.ProdutoModel;
import br.com.etec.sw2.produto.services.ProdutoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api_produto")
public class ProdutoController {

    // Declarar serviço de conexão com repositório
    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super();
        this.produtoService = produtoService;
    }

    // Método POST para salvar o produto
    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto) {

        if (produtoService.existsByCodigoDeBarras(produtoDto.getcodigoDeBarras())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLITO: Produto já cadastrado!");
        }

        if (produtoService.existsByDescricao(produtoDto.getDescricao())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLITO: Descrição já utilizada!");
        }

        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        produtoModel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));
    }

    // Método GET para buscar produtos cadastrados
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Object> getOneProduto(@PathVariable(value = "id") UUID id) {
        Optional<ProdutoModel> produtoModelOptional = produtoService.findById(id);
        if (!produtoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoModelOptional.get());
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") UUID id) {
        Optional<ProdutoModel> produtoModelOptional = produtoService.findById(id);
        if (!produtoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        produtoService.delete(produtoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso.");
    }

    // EXEMPLO 2 DE PUT PARA ALTERAR DADOS
    @PutMapping("/produto/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "id") UUID id,
            @RequestBody @Valid ProdutoDto produtoDto) {
        Optional<ProdutoModel> produtoModelOptional = produtoService.findById(id);
        if (!produtoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        produtoModel.setId(produtoModelOptional.get().getId());
        produtoModel.setDataDeRegistro(produtoModelOptional.get().getdataDeValidade());

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModel));
    }
}
