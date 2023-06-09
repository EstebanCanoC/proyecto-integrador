package com.esteban.mensajeria.repository;

import com.esteban.mensajeria.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, String> {
}
