package com.esteban.mensajeria.repository;

import com.esteban.mensajeria.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {
}
