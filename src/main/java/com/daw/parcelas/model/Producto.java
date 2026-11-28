package com.daw.parcelas.model;

public enum Producto {
    ACEITUNA("Aceituna"),
    ALMENDRA("Almendra"),
    UVA("Uva"),
    NARANJA("Naranja"),
    LIMON("Limón"),
    PISTACHO("Pistacho"),
    TOMATE("Tomate"),
    PIMIENTO("Pimiento"),
    TRIGO("Trigo");

    private final String etiqueta;

    Producto(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
