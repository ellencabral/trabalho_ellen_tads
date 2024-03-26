package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
