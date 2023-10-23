package br.com.fiap.aula.dto.produto;

import br.com.fiap.aula.domain.Categoria;
import br.com.fiap.aula.domain.Produto;

public record DetalhesProdutoDTO(Long codigo, String nome, String descricao, Double valor, Integer quantidade, Boolean disponivel, Categoria categoria) {

    public DetalhesProdutoDTO(Produto produto) {
       this(produto.getCodigo(),produto.getNome(),produto.getDescricao(), produto.getValor(), produto.getQuantidade(), produto.getDisponivel(), produto.getCategoria());
    }

}
