package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.Sessao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "filmes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Time duracao;
    @OneToMany(mappedBy = "filme", fetch = FetchType.EAGER) // atributo filme da classe Sessao
    private Collection<Sessao> sessoes;
}
