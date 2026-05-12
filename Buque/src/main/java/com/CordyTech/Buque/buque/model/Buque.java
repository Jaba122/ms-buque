package com.CordyTech.Buque.buque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import com.CordyTech.Buque.buque.model.EstadoBuque;

@Entity
@Table(name = "buque")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codBuque;

    @Column(nullable = false)
    private String nombreBuque;

    @Column(nullable = false)
    private Double esloraBuque;

    @Column(nullable = false)
    private Double manga;

    @Column(nullable = false)
    private Double calado;

    @Column(nullable = false)
    private Double tonelajeBruto;

    @Column(nullable = false, unique = true)
    private String imoNumero;

    @Column(nullable = false)
    private String bandera;

    @Column(nullable = false)
    private String agenciaNaviera;

    @Column(nullable = false)
    private LocalDateTime fechaHoraLlegada;

    @Column(nullable = false)
    private LocalDateTime fechaHoraPartida;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoBuque estadoBuque;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creadoEn;

    @UpdateTimestamp
    private LocalDateTime actualizadoEn;

}