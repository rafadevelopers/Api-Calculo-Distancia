package com.api.desafiosantander.controller;

import com.api.desafiosantander.service.AgencyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FindAgencyByIdControllerTest {

    @Autowired
    AgencyService agencyService;

    @Test
    public  void initFindAgencyById(){
        agencyService.findAgencyById(1L);
    }

}
