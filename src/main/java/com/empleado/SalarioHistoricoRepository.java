package com.empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioHistoricoRepository extends JpaRepository<SalarioHistorico,Integer> {
}
