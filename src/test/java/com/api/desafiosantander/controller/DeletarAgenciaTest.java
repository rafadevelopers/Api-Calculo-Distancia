package com.api.desafiosantander.controller;

import com.api.desafiosantander.service.AgenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeletarAgenciaTest {

    @Autowired
    AgenciaService agenciaService;

    @Test
    public void initDeletarAgencia(){

        agenciaService.deletarAgencia(1L);
    }

}
