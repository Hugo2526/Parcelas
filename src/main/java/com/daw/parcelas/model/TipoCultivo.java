package com.daw.parcelas.model;

public enum TipoCultivo {
    OLIVAR("Olivar"),
    ALMENDRO("Almendro"),
    VINEDO("Viñedo"),
    CITRICOS("Cítricos"),
    PISTACHO("Pistacho"),
    LECHUGAS("Lechugas"),
    TOMATES("Tomates"),
    PIMIENTOS("Pimientos");
    private final String etiqueta;
    TipoCultivo(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    public String getEtiqueta() {
        return etiqueta;
    }
}
