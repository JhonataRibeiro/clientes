package com.jra.clientes.Controller;

import com.jra.clientes.Model.Cliente;
import com.jra.clientes.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping()
    public Cliente inserir(@RequestBody Cliente cliente){return clienteService.inserir(cliente);}

}
