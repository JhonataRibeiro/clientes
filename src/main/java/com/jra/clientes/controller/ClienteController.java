package com.jra.clientes.controller;

import com.jra.clientes.model.Cliente;
import com.jra.clientes.service.ClienteService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Controller
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public List<Cliente> listar(){
        return clienteService.listar();
    }

    @GetMapping("/{nome}")
    public List<Cliente> procurarPelo(@PathVariable String nome){
        return clienteService.procurarPelo(nome);
    }

    @PostMapping()
    public Cliente inserir(@RequestBody Cliente cliente){return clienteService.inserir(cliente);}

    @PutMapping()
    public ResponseEntity editar(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.editar(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> exlcuir(@PathVariable Integer id){
        try {
            clienteService.excluir(id);
        } catch (NotFound notFound) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }

}
