package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.autenticacao;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra.TokenJwtDTO;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra.TokenService;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios.Usuario;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> efetuaLogin(@RequestBody UsuarioDTO data) {
        var authenticationDTO = new UsernamePasswordAuthenticationToken(data.usuario(), data.senha());

        var authentication = manager.authenticate(authenticationDTO);

        var tokenJWT = tokenService.geraToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }
}
