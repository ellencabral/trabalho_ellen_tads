package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.Sessao;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes.SessaoDTOResponse;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.sql.Time;
import java.util.Collection;

@Data
public class FilmeDTOResponse {
    private Long id;
    private String titulo;
    private Time duracao;
    private Collection<SessaoDTOResponse> sessoes;

    public static FilmeDTOResponse create(Filme filme) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(filme, FilmeDTOResponse.class);
    }
}
