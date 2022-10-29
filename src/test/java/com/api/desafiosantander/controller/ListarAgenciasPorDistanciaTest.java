package com.api.desafiosantander.controller;

import com.api.desafiosantander.service.AgenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ListarAgenciasPorDistanciaTest {

    @Autowired
    AgenciaService agenciaService;

    @Test
    public void initListarAgenciaDistancia(){
        agenciaService.listarPorDistancia(22, 35);
    }

}
