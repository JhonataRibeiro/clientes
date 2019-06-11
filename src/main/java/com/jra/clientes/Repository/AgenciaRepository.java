package com.jra.clientes.Repository;

import com.jra.clientes.Model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jribeiro
 * @date 10/06/19
 */
@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
}
