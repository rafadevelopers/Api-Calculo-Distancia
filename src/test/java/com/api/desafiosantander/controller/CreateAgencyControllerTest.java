package com.api.desafiosantander.controller;
import com.api.desafiosantander.model.Agency;
import com.api.desafiosantander.service.AgencyService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateAgencyControllerTest {


    @Autowired
    AgencyService agencyService;

    @Test
    public void initCadastro(){

        Agency ag = new Agency();
        ag.setId(1);
        ag.setNome("Santader SP");
        ag.setPosX(22.0);
        ag.setPosY(35.0);
        agencyService.createAgency(ag);
    }

}
