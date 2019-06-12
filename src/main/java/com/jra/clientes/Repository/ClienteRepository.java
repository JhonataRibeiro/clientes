package com.jra.clientes.Repository;

import com.jra.clientes.Model.Cliente;
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
