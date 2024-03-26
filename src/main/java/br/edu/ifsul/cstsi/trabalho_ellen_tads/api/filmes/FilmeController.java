package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/filmes")
public class FilmeController {
    @Autowired
    FilmeService service;
    @GetMapping
    public ResponseEntity<List<FilmeDTOResponse>> selectAll() {
        return ResponseEntity.ok(service.getFilmes());
    }
    @GetMapping("{id}")
    public ResponseEntity<FilmeDTOResponse> selectById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFilme(id));
    }
    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<URI> insert(@RequestBody Filme filme) {
        var f = service.insertFilme(filme);
        var location = getUri(f.getId());
        return ResponseEntity.created(location).build();
    }
    @PutMapping("{id}")
    public ResponseEntity<FilmeDTOResponse> update(@RequestBody Filme filme, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateFilme(filme, id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteFilme(id);
        return ResponseEntity.ok().build();
    }
    //utilitário
    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }
}
