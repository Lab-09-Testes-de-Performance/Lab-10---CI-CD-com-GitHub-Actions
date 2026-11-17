package com.example.atividade_pratica.repository;

import com.example.atividade_pratica.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
