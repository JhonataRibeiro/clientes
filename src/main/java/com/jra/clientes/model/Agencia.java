package com.jra.clientes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Data
@Entity
@NoArgsConstructor
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String banco;

    @Column
    private String nomeAgencia;

    @Column
    private int agencia;

    @Column
    private int conta;
}
