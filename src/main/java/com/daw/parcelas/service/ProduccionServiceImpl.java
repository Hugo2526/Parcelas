package com.daw.parcelas.service;

import com.daw.parcelas.controller.RecursoNoEncontradoException;
import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.model.Produccion;
import com.daw.parcelas.model.Producto;
import com.daw.parcelas.repository.ProduccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduccionServiceImpl implements ProduccionService {

    private final ProduccionRepository produccionRepository;

    public ProduccionServiceImpl(
            ProduccionRepository produccionRepository) {
        this.produccionRepository = produccionRepository;
    }

    @Override
    public List<Produccion> listarTodas() {
        return produccionRepository.findAll();
    }

    @Override
    public Produccion buscarPorId(Long id) {
        return produccionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe la producción con id " + id));
    }

    @Override
    public Produccion guardar(Produccion produccion) {
        return produccionRepository.save(produccion);
    }

    @Override
    public void eliminar(Long id) {
        produccionRepository.deleteById(id);
    }

    @Override
    public double calcularTotalKilos(List<Produccion> producciones) {
        return producciones.stream()
                .mapToDouble(Produccion::getCantidadKg)
                .sum();
    }

    @Override
    public List<Produccion> filtrarProductoYCalidad(String producto, String calidad) {

        if ("TODOS".equals(producto) && "TODOS".equals(calidad)) {
            return produccionRepository.findAllByOrderByFechaRecoleccionDesc();
        } else if ("TODOS".equals(producto)) {
            return produccionRepository.findByCalidadOrderByFechaRecoleccionDesc(Calidad.valueOf(calidad));
        } else if ("TODOS".equals(calidad)) {
            return produccionRepository.findByProductoOrderByFechaRecoleccionDesc(Producto.valueOf(producto));
        } else {
            return produccionRepository.findByProductoAndCalidadOrderByFechaRecoleccionDesc(
                    Producto.valueOf(producto),
                    Calidad.valueOf(calidad));
        }

    }
    @Override
    public List<Produccion> ultimas() {
        return produccionRepository.findTop5ByOrderByFechaRecoleccionDesc();
    }

    @Override
    public long contarPorCalidad(Calidad calidad) {
        return produccionRepository.countByCalidad(calidad);
    }

}
