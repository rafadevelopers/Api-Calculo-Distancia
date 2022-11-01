package com.api.desafiosantander.controller;
import com.api.desafiosantander.service.AgencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest

public class FindAllAgencyControllerTest {

    @Autowired
    AgencyService agencyService;

    @Test
    public void initListarAgencia(){
        agencyService.findAllAgency();
    }
}
