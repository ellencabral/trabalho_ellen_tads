package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //metodo utilizado em UserDetailsServiceHttpBasic
    Usuario findByUsuario(String usuario);
}
