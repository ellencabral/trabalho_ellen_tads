package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.autenticacao;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra.TokenJwtDTO;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra.TokenService;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios.Usuario;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> efetuaLogin(@Valid @RequestBody UsuarioDTO data) {
        var authenticationDTO = new UsernamePasswordAuthenticationToken(data.usuario(), data.senha());

        var authentication = manager.authenticate(authenticationDTO);

        var tokenJWT = tokenService.geraToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
