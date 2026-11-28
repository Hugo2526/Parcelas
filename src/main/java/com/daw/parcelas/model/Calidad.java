package com.daw.parcelas.model;

public enum Calidad {
    EXTRA("Extra"),
    PRIMERA("Primera"),
    SEGUNDA("Segunda");

    private final String etiqueta;

    Calidad(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}