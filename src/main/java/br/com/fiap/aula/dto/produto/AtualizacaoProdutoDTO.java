package br.com.fiap.aula.dto.produto;

public record AtualizacaoProdutoDTO(String nome, String descricao, Double valor, Integer quantidade, Boolean disponivel) {
}
