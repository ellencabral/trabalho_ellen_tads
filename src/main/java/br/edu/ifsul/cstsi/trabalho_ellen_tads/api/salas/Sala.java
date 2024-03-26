package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.salas;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "salas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nrosala;
    private Integer capacidade;
    @OneToMany(mappedBy = "sala")
    private Collection<Sessao> sessoes;
}
