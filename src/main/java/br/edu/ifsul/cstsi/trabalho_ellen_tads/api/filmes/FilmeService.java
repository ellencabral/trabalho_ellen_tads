package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;
    public List<FilmeDTOResponse> getFilmes() {

        return repository.findAll().stream()
                .map(FilmeDTOResponse::create)
                .collect(Collectors.toList());
    };
    public FilmeDTOResponse getFilme(Long id) {
        return FilmeDTOResponse.create(repository.getReferenceById(id));
    }
    public Filme insertFilme(Filme filme) {
        return repository.save(filme);
    }
    public FilmeDTOResponse updateFilme(Filme filme, Long id) {
        var filmeUpdate = repository.getReferenceById(id);
        filmeUpdate.setTitulo(filme.getTitulo());
        filmeUpdate.setDuracao(filme.getDuracao());

        return FilmeDTOResponse.create(repository.save(filmeUpdate));
    }
    public boolean deleteFilme(Long id) {
        repository.deleteById(id);
        return true;
    }
}
