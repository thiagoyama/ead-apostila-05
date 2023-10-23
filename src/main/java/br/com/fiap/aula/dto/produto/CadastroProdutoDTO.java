package br.com.fiap.aula.dto.produto;

import br.com.fiap.aula.domain.Categoria;

public record CadastroProdutoDTO(String nome, String descricao, Double valor, Integer quantidade, Boolean disponivel, Categoria categoria) {
}
