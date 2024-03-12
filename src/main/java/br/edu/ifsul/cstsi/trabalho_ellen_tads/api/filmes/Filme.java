package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.Sessao;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Time duracao;
    @OneToMany(mappedBy = "filme") // atributo filme da classe Sessao
    private Collection<Sessao> sessoes;
}
