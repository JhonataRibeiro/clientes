package com.jra.clientes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Data
@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private int cep;

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<Agencia> agencias;


}
