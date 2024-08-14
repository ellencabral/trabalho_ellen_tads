package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.filmes;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.TrabalhoEllenTadsApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (classes = TrabalhoEllenTadsApplication.class)
@ActiveProfiles("test")
public class FilmeServiceIntegracaoTest {

    @Autowired
    private FilmeService service;

    @Test
    @DisplayName("Busca os filmes na base de dados, espera 6 filmes")
    public void testGetFilmesEsperaUmaListaCom6Filmes() {

        // arrange + act
        var filmes = service.getFilmes();

        // assert
        assertEquals(6, filmes.size());
    }
}
