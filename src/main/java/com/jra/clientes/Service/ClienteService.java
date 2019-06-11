package com.jra.clientes.Service;

import com.jra.clientes.Model.Cliente;
import com.jra.clientes.Repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Service
@Slf4j
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente inserir(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
