package com.api.desafiosantander.service;

import com.api.desafiosantander.model.Agencia;
import com.api.desafiosantander.model.AgenciaDistanciaVO;
import com.api.desafiosantander.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public String cadastroAgencia(Agencia agencia) {
        try {
            if (
                    null == agencia.getNome()  || agencia.getNome().isEmpty()
            ) {
                throw new Exception("O campo nome não ser vazio!");
            }
            agencia = agenciaRepository.save(agencia);
            return "Agencia " + agencia.getNome() + " criada com Sucesso";
        } catch (Exception e) {
            return "Erro ao criar agencia: " + e.getMessage();
        }
    }

    //METODO QUE CONTEM A LOGICA POR TRÁS DA LISTAGEM DE LOJAS
    public List<Agencia> listarTodasAgencias() {
        return agenciaRepository.findAll();
    }

    //METODO QUE CONTEM A LOGICA POR TRÁS DA LISTAGEM DE LOJAS POR DISTANCIA
    public List<AgenciaDistanciaVO> listarPorDistancia( double posX, double posY){

        List<Agencia> agencias = new ArrayList<Agencia>();
        List<AgenciaDistanciaVO> agenciasvo = new ArrayList<AgenciaDistanciaVO>();
        agencias = this.listarTodasAgencias();

        for (int i = 0; i <= agencias.size() - 1; i++) {                          //( 52 - 56 ) LAÇO DE REPETIÇÃO REPONSAVEL RESPONSAVEL
            Agencia ag = agencias.get(i);
            AgenciaDistanciaVO vo = new AgenciaDistanciaVO(ag, posX, posY);
            agenciasvo.add(vo);
        }

        agenciasvo = agenciasvo.stream()
                .sorted(Comparator.comparingDouble(AgenciaDistanciaVO::getDistancia) // ( 58 - 61 ) ORDENA O RETORNO DAS LOJAS E SUAS DISTANCIAS
                )                                                                    // DA MENOR PARA A MAIOR DISTANCIA.
                .collect(Collectors.toCollection(ArrayList::new));

        return agenciasvo;

    }

    //METODO QUE CONTEM A LOGICA PARA DELETAR A AGENCIA
    public String deletarAgencia(Long id){
        agenciaRepository.deleteById(id);
        return "Agencia excluida com sucesso!";
    }
}
