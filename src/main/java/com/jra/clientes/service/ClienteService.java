package com.jra.clientes.service;

import com.jra.clientes.model.Cliente;
import com.jra.clientes.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.omg.CosNaming.NamingContextPackage.NotFound;
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

    public void excluir(Integer id) throws NotFound {
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow(NotFound::new));
    }

    public List<Cliente> procurarPelo(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Cliente editar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
