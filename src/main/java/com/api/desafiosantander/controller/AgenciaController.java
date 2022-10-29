package com.api.desafiosantander.controller;
import com.api.desafiosantander.model.AgenciaDistanciaVO;
import com.api.desafiosantander.model.Agencia;
import com.api.desafiosantander.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/desafio")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    //METODO PARA CADASTRAR UMA NOVA AGENCIA.
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@RequestBody Agencia agencia) {
        return agenciaService.cadastroAgencia(agencia);
    }

    //METODO PARA LISTAR TODAS AS AGENCIAS CADASTRADAS E SUAS POSIÇÕES.
    @GetMapping
    public List<Agencia> listar() {
        return agenciaService.listarTodasAgencias();
    }


    //METODO PARA LISTAR AS AGENCIAS CADASTRADAS E SUAS RESPECTIVAS DISTANCIAS.
    @GetMapping(value = "/distancia/", params = {"posX", "posY"})
    public List<AgenciaDistanciaVO> listarPorDistancia(@RequestParam double posX, @RequestParam double posY) {
        return agenciaService.listarPorDistancia(posX, posY);
    }
    //METODO PARA DELETAR A LOJA PELO SEU ID.
    @DeleteMapping(value = "/deletar/{id}")
    public String deletarAgencia(@PathVariable("id") Long id){
         return agenciaService.deletarAgencia(id);
    }
}
