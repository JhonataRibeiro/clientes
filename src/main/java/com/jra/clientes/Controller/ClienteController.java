package com.jra.clientes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Controller
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping()
    public String listar(){
        return "Listar Cliente";
    }
}
