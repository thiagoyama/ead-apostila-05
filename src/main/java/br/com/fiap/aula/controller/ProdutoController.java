package br.com.fiap.aula.controller;

import br.com.fiap.aula.dto.produto.AtualizacaoProdutoDTO;
import br.com.fiap.aula.dto.produto.CadastroProdutoDTO;
import br.com.fiap.aula.dto.produto.DetalhesProdutoDTO;
import br.com.fiap.aula.dto.produto.ListagemProdutoDTO;
import br.com.fiap.aula.domain.Produto;
import br.com.fiap.aula.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDTO> cadastrar(@RequestBody CadastroProdutoDTO dto, UriComponentsBuilder uriBuilder){
        var produto = new Produto(dto);
        produtoRepository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesProdutoDTO(produto));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemProdutoDTO>> listar(Pageable paginacao){
        var page = produtoRepository.findAll(paginacao).map(ListagemProdutoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesProdutoDTO> pesquisar(@PathVariable("id") Long id){
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesProdutoDTO(produto));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesProdutoDTO> atualizar(@PathVariable("id")Long id, @RequestBody AtualizacaoProdutoDTO dto){
        var produto =produtoRepository.getReferenceById(id);
        produto.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesProdutoDTO(produto));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable("id")Long id){
        var produto = produtoRepository.getReferenceById(id);
        produtoRepository.delete(produto);
        return ResponseEntity.noContent().build();
    }

}
