package com.daw.parcelas.repository;

import com.daw.parcelas.model.Sensor;
import com.daw.parcelas.model.TipoSensor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

     List<Sensor> findAllByTipoEquals(TipoSensor tipoSensor);
     Page<Sensor> findAllByNameContainingIgnoreCase(String name);
     Page<Sensor> findAllByNameContainingIgnoreCaseAndTipoEquals(String name, TipoSensor tipo);

}