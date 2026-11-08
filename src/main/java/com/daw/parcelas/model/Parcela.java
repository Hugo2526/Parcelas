package com.daw.parcelas.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "parcela")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private Double superficie;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_cultivo")
    private TipoCultivo tipoCultivo;
}
