package com.api.desafiosantander.model;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Data
public class AgenciaDistanciaVO {

    private String agencia;
    private double distancia;


    public AgenciaDistanciaVO(@NotNull Agencia agencia, double agParamX, double agParamY) {

        double sum = 0;

        double agPosX, agPosY;
        agPosX = agencia.getPosX(); // PEGA O VALOR DA POSIÇÃO X e Y DA AGENCIA CADASTRADA.
        agPosY = agencia.getPosY();

        double pos1, pos2;

        pos1 = Math.pow(agParamX - agPosX, 2);
        pos2 = Math.pow(agParamY - agPosY, 2);

        sum = Math.sqrt(pos1 + pos2);
        this.agencia = agencia.getNome();

        NumberFormat formatter = new DecimalFormat("#00");

        this.distancia = Double.parseDouble(formatter.format(sum));
    }

    //FONTE DA FORMULA PARA REALIZAR O CALCULO
    //https://mundoeducacao.uol.com.br/matematica/distancia-entre-dois-pontos.htm
    //https://brasilescola.uol.com.br/matematica/distancia-entre-dois-pontos.htm




}
