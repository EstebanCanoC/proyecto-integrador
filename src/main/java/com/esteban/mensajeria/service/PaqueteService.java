package com.esteban.mensajeria.service;

import com.esteban.mensajeria.model.Paquete;
import com.esteban.mensajeria.model.TipoPaquete;
import com.esteban.mensajeria.repository.PaqueteRepository;
import org.springframework.stereotype.Service;

@Service
public class PaqueteService {
    private final PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public Paquete crearPaquete(Integer peso, double valorDeclaradoPaquete){
        TipoPaquete tipo;
        if (peso < 2) {
            tipo = TipoPaquete.LIVIANO;
        } else if (peso < 5) {
            tipo = TipoPaquete.MEDIANO;
        } else {
            tipo = TipoPaquete.GRANDE;
        }

        Paquete paquete = new Paquete();
        paquete.setTipoPaquete(tipo);
        paquete.setPeso(peso);
        paquete.setValorDeclaradoPaquete(valorDeclaradoPaquete);
        paqueteRepository.save(paquete);
        return paquete;
    }
}
