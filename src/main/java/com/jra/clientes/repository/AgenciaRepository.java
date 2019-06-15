package com.jra.clientes.repository;

import com.jra.clientes.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
    List<Agencia> findByNomeAgenciaContainingIgnoreCase(String nomeAgencia);
}
