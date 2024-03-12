package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.salas;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.Sessao;
import jakarta.persistence.*;

@Entity
@Table(name = "salas")
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nrosala;
    private Integer capacidade;
    @ManyToOne
    @JoinColumn(name = "sessao_id", referencedColumnName = "id")
    private Sessao sessao;
}
