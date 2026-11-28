package com.daw.parcelas.repository;

import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.model.Produccion;
import com.daw.parcelas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduccionRepository extends JpaRepository<Produccion, Long> {
    public List<Produccion> findAllByOrderByFechaRecoleccionDesc();
    public List<Produccion> findByProductoOrderByFechaRecoleccionDesc(Producto producto);
    public List<Produccion> findByCalidadOrderByFechaRecoleccionDesc(Calidad calidad);
    public List<Produccion> findByProductoAndCalidadOrderByFechaRecoleccionDesc(Producto producto, Calidad calidad);
    public long countByCalidad(Calidad calidad);
    public List<Produccion> findTop5ByOrderByFechaRecoleccionDesc();
}