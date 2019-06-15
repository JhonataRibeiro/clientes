package com.jra.clientes.repository;

import com.jra.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
     List<Cliente> findByNomeContaining(String nome);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
