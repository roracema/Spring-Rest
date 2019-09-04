package br.com.fiap.rest.repository;

import br.com.fiap.rest.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome(String nome);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);
}