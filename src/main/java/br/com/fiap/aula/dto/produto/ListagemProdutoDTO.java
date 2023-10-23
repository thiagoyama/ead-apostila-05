package br.com.fiap.aula.dto.produto;

import br.com.fiap.aula.domain.Produto;

public record ListagemProdutoDTO(Long codigo, String nome, String descricao, double valor) {

    public ListagemProdutoDTO(Produto produto){
        this(produto.getCodigo(), produto.getNome(), produto.getDescricao(), produto.getValor());
    }

}
