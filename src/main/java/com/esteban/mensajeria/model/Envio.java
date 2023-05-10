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
@Table(name = "envios")
public class Envio {
    @Id
    @Column(name = "numero_guia")
    private String numeroGuia;

    @ManyToOne
    @JoinColumn(name = "cedula_cliente", referencedColumnName = "cedula")
    private Cliente cliente;

    @Column(name = "ciudad_origen")
    private String ciudadOrigen;

    @Column(name = "ciudad_destino")
    private String ciudadDestino;

    @Column(name = "direccion_destino")
    private String direccionDestino;

    @Column(name = "nombre_recibe")
    private String nombreRecibe;

    @Column(name = "celular")
    private String celular;

    @Column(name = "valor_declarado_paquete")
    private double valorDeclaradoPaquete;

    @Column(name = "peso")
    private int peso;

    @Column(name = "valor_envio")
    private double valorEnvio;

    @Column(name = "estado_envio")
    @Enumerated(EnumType.STRING)
    private EstadoEnvio estadoEnvio;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    @ManyToOne
    @JoinColumn(name = "cedula_empleado", referencedColumnName = "cedula")
    private Empleado empleado;
}
