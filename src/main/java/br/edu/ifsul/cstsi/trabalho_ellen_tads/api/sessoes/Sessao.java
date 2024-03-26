package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes.Filme;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.ingressos.Ingresso;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.salas.Sala;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "sessoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dt_sessao;
    private Time hor_sessao;
    private BigDecimal valor_inteira;
    private BigDecimal valor_meia;
    private Boolean encerrada;
    @ManyToOne
    @JoinColumn(name = "filme_id", referencedColumnName = "id")
    private Filme filme;
    @OneToMany(mappedBy = "sessao")
    private Collection<Ingresso> ingressos;
    @ManyToOne
    @JoinColumn(name = "sala_id", referencedColumnName = "id")
    private Sala sala;
}
