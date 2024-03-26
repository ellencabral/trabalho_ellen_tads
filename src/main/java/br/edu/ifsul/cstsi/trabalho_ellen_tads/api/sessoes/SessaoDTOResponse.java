package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.sessoes;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class SessaoDTOResponse {
    private Date dt_sessao;
    private Time hor_sessao;
    private boolean encerrada;
    private Long id;
}
