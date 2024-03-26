package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios;

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
    @PostMapping
    public ResponseEntity efetuaLogin(@RequestBody UsuarioDTO userDTO) {
        var authenticationDTO = new UsernamePasswordAuthenticationToken(userDTO.usuario(), userDTO.senha());
        var authentication = manager.authenticate(authenticationDTO);

        return ResponseEntity.ok().build();
    }
}
