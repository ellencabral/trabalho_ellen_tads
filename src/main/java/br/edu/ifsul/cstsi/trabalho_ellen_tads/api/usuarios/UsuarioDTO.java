package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @Email
        @NotBlank
        String usuario,

        @NotBlank
        String senha
    ) {
}
