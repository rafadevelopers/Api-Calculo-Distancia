package com.api.desafiosantander.controller;
import com.api.desafiosantander.model.AgencyDistanceVo;
import com.api.desafiosantander.model.Agency;
import com.api.desafiosantander.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/desafio")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    //METODO PARA CADASTRAR UMA NOVA AGENCIA.
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String CreateAgency(@RequestBody Agency agency) {
        return agencyService.createAgency(agency);
    }

    //METODO PARA ALTERAR AGENCIA PELO ID.
    @PutMapping(value = "/alterar/{id}")
    public Agency updateAgencyById(@RequestBody Agency agency, @PathVariable("id") Long id){
        return agencyService.updateAgencyById(agency, id);
    }

    //METODO PARA DELETAR A AGENCIA PELO ID.
    @DeleteMapping(value = "/deletar/{id}")
    public String deletAgency(@PathVariable("id") Long id){
        return agencyService.deletAgency(id);
    }


    //METODO PARA BUSCAR UMA AGENCIA PELO ID.
    @GetMapping("/buscar/{id}")
    public Agency findAgencyById(@PathVariable("id") Long id){
        return agencyService.findAgencyById(id);
    }


    //METODO PARA LISTAR TODAS AS AGENCIAS CADASTRADAS E SUAS POSIÇÕES.
    @GetMapping
    public List<Agency> findAllAgency() {
        return agencyService.findAllAgency();
    }


    //METODO PARA LISTAR AS AGENCIAS  E SUAS RESPECTIVAS DISTANCIAS.
    @GetMapping(value = "/distancia/", params = {"posX", "posY"})
    public List<AgencyDistanceVo> findAgencyByDistance(@RequestParam Double posX, @RequestParam Double posY) {
        return agencyService.findAgencyByDistance(posX, posY);
    }

}


