package com.api.desafiosantander.model;
import com.api.desafiosantander.model.Entity.Agency;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Data
public class AgencyDistanceVo {

    private String agencia;
    private Double distancia;


    public AgencyDistanceVo(@NotNull Agency agency, double agParamX, double agParamY) {

        double sum = 0;

        double agPosX, agPosY;
        agPosX = agency.getPosX(); // PEGA O VALOR DA POSI��O X e Y DA AGENCIA CADASTRADA.
        agPosY = agency.getPosY();

        double pos1, pos2;

        pos1 = Math.pow(agParamX - agPosX, 2);
        pos2 = Math.pow(agParamY - agPosY, 2);

        sum = Math.sqrt(pos1 + pos2);
        this.agencia = agency.getNome();

        NumberFormat formatter = new DecimalFormat("#00");

        this.distancia = Double.parseDouble(formatter.format(sum));
    }
    //FONTE DA FORMULA PARA REALIZAR O CALCULO
    //https://mundoeducacao.uol.com.br/matematica/distancia-entre-dois-pontos.htm
    //https://brasilescola.uol.com.br/matematica/distancia-entre-dois-pontos.htm




}
