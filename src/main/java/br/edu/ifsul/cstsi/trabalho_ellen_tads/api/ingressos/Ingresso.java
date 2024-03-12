package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.ingressos;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.Sessao;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "ingressos")
public class Ingresso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tipo;
    @OneToMany(mappedBy = "ingresso")
    private Collection<Sessao> sessoes;
}
