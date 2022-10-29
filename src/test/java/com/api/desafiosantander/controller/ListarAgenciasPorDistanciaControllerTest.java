package com.api.desafiosantander.controller;
import com.api.desafiosantander.service.AgenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ListarAgenciasPorDistanciaControllerTest {

    @Autowired
    AgenciaService agenciaService;

    @Test
    public void initListarAgenciaDistancia(){
        agenciaService.listarPorDistancia(22, 35);
    }

}
