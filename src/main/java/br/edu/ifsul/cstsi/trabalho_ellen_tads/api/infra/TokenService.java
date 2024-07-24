package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra.exception.TokenInvalidoException;
import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value(value = "${api.security.token.secret}") //vem de application.properties
    private String secret;

    public String geraToken(Usuario usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("API Produtos Exemplo de TADS")
                    .withSubject(usuario.getUsername())
                    .withIssuedAt(LocalDateTime.now().toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("API Produtos Exemplo de TADS")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch(JWTVerificationException exception) {
            throw new TokenInvalidoException("Token JWT inválido ou expirado");
        }
    }
}
