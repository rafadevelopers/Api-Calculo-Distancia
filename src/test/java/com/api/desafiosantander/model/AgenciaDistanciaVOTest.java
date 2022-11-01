package com.api.desafiosantander.model;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@SpringBootTest
public class AgenciaDistanciaVOTest {

@Test
    public void AgenciaDistanciaVOTest() {

        double sum = 0.0;

        double agParamX = -3;
        double agParamY = -11;

        double agPosX = 2;
        double agPosY = 1;

        double pos1, pos2;

        pos1 = Math.pow(agParamX - agPosX, 2);
        pos2 = Math.pow(agParamY - agPosY, 2);

        sum = Math.sqrt(pos1 + pos2);

        Assertions.assertThat(sum).isEqualTo(13);
        NumberFormat formatter = new DecimalFormat("#00");
    }




}
