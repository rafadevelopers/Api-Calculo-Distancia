package com.api.desafiosantander.controller;

import com.api.desafiosantander.model.Agencia;
import com.api.desafiosantander.service.AgenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastroAgenciaTest {

    @Autowired
    AgenciaService agenciaService;

    @Test
    public void initCadastro(){
        Agencia ag = new Agencia();
        ag.setId(1);
        ag.setNome("Santader SP");
        ag.setPosX(22);
        ag.setPosY(35);
        agenciaService.cadastroAgencia(ag);
    }

}
