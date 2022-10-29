package com.api.desafiosantander.controller;

import com.api.desafiosantander.model.Agencia;
import com.api.desafiosantander.service.AgenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeletarAgenciaControllerTest {

    @Autowired
    AgenciaService agenciaService;

    @Test
    public void initDeletarAgencia(){
        agenciaService.deletarAgencia(1L);
    }

}
