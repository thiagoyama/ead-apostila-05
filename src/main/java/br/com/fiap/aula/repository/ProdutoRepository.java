package br.com.fiap.aula.repository;

import br.com.fiap.aula.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
