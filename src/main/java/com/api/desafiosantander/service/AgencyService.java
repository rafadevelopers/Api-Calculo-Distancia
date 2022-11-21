package com.api.desafiosantander.service;

import com.api.desafiosantander.model.Entity.Agency;
import com.api.desafiosantander.model.AgencyDistanceVo;
import com.api.desafiosantander.model.Dto.AgencyDto;
import com.api.desafiosantander.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public String createAgency(Agency agency) {
        try {
            if (
                    null == agency.getNome() || agency.getNome().isEmpty()
            ) {
                throw new Exception("O campo nome não ser vazio!");
            }
            agency = agencyRepository.save(agency);
            return "Agencia " + agency.getNome() + " criada com Sucesso";
        } catch (Exception e) {
            return "Erro ao criar agencia: " + e.getMessage();
        }
    }

    //METODO QUE CONTEM A LOGICA PARA ALTERAR A AGENCIA
    public AgencyDto updateAgencyById(Agency agency, Long id) {
        Optional<Agency> ag = agencyRepository.findById(id);
        if (ag.isPresent()) {
            Agency obj = ag.get();
            String posX = String.valueOf(agency.getPosX());
            String posY = String.valueOf(agency.getPosX());
            if (agency.getNome() != null) {
                obj.setNome(agency.getNome());
            }
            if (posX != null) {
                obj.setPosX(agency.getPosX());
            }
            if (posY != null) {
                obj.setPosY(agency.getPosY());
            }
            agencyRepository.save(obj);
            return convertToDto(obj);
        }
        return null;

    }

    //METODO QUE CONTEM A LOGICA PARA DELETAR A AGENCIA
    public String deletAgency(Long id) {
        agencyRepository.deleteById(id);
        return "Agencia deletada com sucesso!";
    }

    public AgencyDto findAgencyById(Long id) {
        Optional<Agency> ag = agencyRepository.findById(id);
        if (ag.isPresent()) {
            return convertToDto(ag.get());
        }
        return null;
    }

    //METODO QUE CONTEM A LOGICA POR TRÁS DA LISTAGEM DE LOJAS
    public List<Agency> findAllAgency() {
        return agencyRepository.findAll();
    }



    //METODO QUE CONTEM A LOGICA POR TRÁS DA LISTAGEM DE LOJAS POR DISTANCIA
    public List<AgencyDistanceVo> findAgencyByDistance(Double posX, Double posY) {

        List<Agency> agencies = new ArrayList<Agency>();
        List<AgencyDistanceVo> agenciasvo = new ArrayList<AgencyDistanceVo>();
        agencies = this.findAllAgency();

        for (int i = 0; i <= agencies.size() - 1; i++) {
            Agency ag = agencies.get(i);
            AgencyDistanceVo vo = new AgencyDistanceVo(ag, posX, posY);
            agenciasvo.add(vo);
        }

        agenciasvo = agenciasvo.stream()
                .sorted(Comparator.comparingDouble(AgencyDistanceVo::getDistancia)
                )
                .collect(Collectors.toCollection(ArrayList::new));

        return agenciasvo;

    }

    private AgencyDto convertToDto(Agency agency){
        AgencyDto dto = new AgencyDto();
        dto.setId(agency.getId());
        dto.setNome(agency.getNome());
        dto.setPosX(agency.getPosX());
        dto.setPosY(agency.getPosY());
        return dto;

    }






}
