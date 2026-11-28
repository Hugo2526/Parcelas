package com.daw.parcelas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "producciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El producto no puede estar vacio")
    @Enumerated(EnumType.STRING)
    private Producto producto;

    @NotNull(message = "Debe tener una cantidad")
    @Positive(message = "La cantidad debe ser mayor que 0")
    @DecimalMax(value = "1000000", message = "La cantidad no puede ser superior a 1 millon")
    private Double cantidadKg;

    @NotNull(message = "{produccion.fecha.obligatoria}")
    @PastOrPresent(message = "{produccion.fecha.futura}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecoleccion;

    @NotNull(message = "La calidad no puede estar vacia")
    @Enumerated(EnumType.STRING)
    private Calidad calidad;


}