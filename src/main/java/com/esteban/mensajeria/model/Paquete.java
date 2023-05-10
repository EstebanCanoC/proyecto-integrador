package com.esteban.mensajeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
