package com.esteban.mensajeria.model;

import javax.persistence.*;

@Entity
@Table(name = "paquetes")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaquete;
    @Column(name = "tipo")
    private TipoPaquete tipoPaquete;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "valor")
    private double valorDeclaradoPaquete;
}
