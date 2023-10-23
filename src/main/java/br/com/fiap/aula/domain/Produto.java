package br.com.fiap.aula.domain;

import br.com.fiap.aula.dto.produto.AtualizacaoProdutoDTO;
import br.com.fiap.aula.dto.produto.CadastroProdutoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long codigo;

    private String nome;

    private String descricao;

    private Double valor;

    private Integer quantidade;

    private Boolean disponivel;

    private Categoria categoria;

    private boolean ativo = true;

    public Produto(CadastroProdutoDTO dto) {
        nome = dto.nome();
        descricao = dto.descricao();
        valor = dto.valor();
        quantidade = dto.quantidade();
        disponivel = dto.disponivel();
        categoria = dto.categoria();
    }

    public void atualizarInformacoes(AtualizacaoProdutoDTO dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.disponivel() != null)
            disponivel = dto.disponivel();
        if (dto.descricao() != null)
            descricao = dto.descricao();
        if (dto.quantidade() != null)
            quantidade = dto.quantidade();
        if (dto.valor() != null)
            valor = dto.valor();
    }
}
