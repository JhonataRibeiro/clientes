package com.jra.clientes.Service;

import com.jra.clientes.Model.Agencia;
import com.jra.clientes.Repository.AgenciaRepository;
import lombok.extern.slf4j.Slf4j;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Service
@Slf4j
public class AgenciaService {
    @Autowired
    AgenciaRepository agenciaRepository;

    public List<Agencia> listar(){
        return agenciaRepository.findAll();
    }

    public Agencia inserir(Agencia agencia){
        return agenciaRepository.save(agencia);
    }

    public void excluir(Integer id) throws NotFound {
        agenciaRepository.delete(agenciaRepository.findById(id).orElseThrow(NotFound::new));
    }

    public Agencia editar(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    public List<Agencia> procurarPelo(String nomeAgencia) {
        return agenciaRepository.findByNomeAgenciaContainingIgnoreCase(nomeAgencia);
    }
}
