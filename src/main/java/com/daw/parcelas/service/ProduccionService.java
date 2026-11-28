package com.daw.parcelas.service;

import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.model.Produccion;

import java.util.List;

public interface ProduccionService {
    List<Produccion> listarTodas();
    Produccion buscarPorId(Long id);
    Produccion guardar(Produccion produccion);
    void eliminar(Long id);
    long contarPorCalidad(Calidad calidad);
    List<Produccion> ultimas();
    double calcularTotalKilos(List<Produccion> producciones);
    List<Produccion> filtrarProductoYCalidad(String producto, String calidad);
}

