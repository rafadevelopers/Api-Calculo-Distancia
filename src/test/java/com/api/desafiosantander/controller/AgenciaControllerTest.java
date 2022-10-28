package com.api.desafiosantander.controller;


import com.api.desafiosantander.model.Agencia;
import com.api.desafiosantander.service.AgenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgenciaControllerTest {

    @Autowired
    AgenciaService agenciaService;

    @Test
    public void initCadastro(){
        Agencia ag = new Agencia();
        ag.setNome("Santader SP");
        ag.setPosX(22);
        ag.setPosY(35);
        agenciaService.cadastroAgencia(ag);
    }

    @Test
    public void initListarAgencia(){
        agenciaService.listarTodasAgencias();
    }

    @Test
    public void initListarAgenciaDistancia(){
        agenciaService.listarPorDistancia(22, 35);
    }
}
