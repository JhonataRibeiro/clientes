package com.jra.clientes.Model;

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
    private int agencia;

    @Column
    private int conta;
}
