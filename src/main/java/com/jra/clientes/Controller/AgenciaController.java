package com.jra.clientes.Controller;

import com.jra.clientes.Model.Agencia;
import com.jra.clientes.Service.AgenciaService;
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
@RequestMapping("/agencias")
public class AgenciaController {
    @Autowired
    AgenciaService agenciaService;

    @GetMapping()
    public List<Agencia> listar(){
        return agenciaService.listar();
    }

    @GetMapping("/{nome}")
    public List<Agencia> procurarPelo(@PathVariable String agencia){
        return agenciaService.procurarPela(agencia);
    }

    @PostMapping()
    public Agencia inserir(@RequestBody Agencia agencia){
        return agenciaService.inserir(agencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Agencia> exlcuir(@PathVariable Integer id){
        try {
            agenciaService.excluir(id);
        } catch (NotFound notFound) {
            return new ResponseEntity<Agencia>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Agencia>(HttpStatus.NO_CONTENT);
    }

}
