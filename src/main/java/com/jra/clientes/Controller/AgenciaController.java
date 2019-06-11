package com.jra.clientes.Controller;

import com.jra.clientes.Model.Agencia;
import com.jra.clientes.Service.AgenciaService;
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
@RequestMapping("/agencias")
public class AgenciaController {
    @Autowired
    AgenciaService agenciaService;

    @GetMapping()
    public List<Agencia> listar(){
        return agenciaService.listar();
    }

    @PostMapping()
    public Agencia inserir(@RequestBody Agencia agencia){
        return agenciaService.inserir(agencia);
    }

}
