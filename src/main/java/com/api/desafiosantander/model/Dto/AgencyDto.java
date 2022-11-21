package com.api.desafiosantander.model.Dto;

import com.api.desafiosantander.model.Entity.Agency;
import lombok.Data;

@Data
public class AgencyDto {

    private Long id;

    private String nome;

    private Double posX;

    private Double posY;

    public AgencyDto(){

    }

    public AgencyDto(Agency agency){
        this.id = agency.getId();
        this.nome = agency.getNome();
        this.posX = agency.getPosX();
        this.posY = agency.getPosY();

    }

}
