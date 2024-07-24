package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.autenticacao;

import br.edu.ifsul.cstsi.trabalho_ellen_tads.api.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacaoRepository extends JpaRepository<Usuario, Long> {

    //metodo utilizado em UserDetailsServiceHttpBasic
    Usuario findByUsuario(String usuario);
}
