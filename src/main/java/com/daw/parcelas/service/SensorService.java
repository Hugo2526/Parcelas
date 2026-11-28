package com.daw.parcelas.service;

import com.daw.parcelas.model.Sensor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SensorService {

    List<Sensor> getAllSensors();

    Page<Sensor> getAllSensorsByNameAndTipoSensors(String name, String tipo);

    Sensor getSensorById(Long id);

    List<Sensor> getAllSensorsTemperatura();

    void saveSensor(Sensor sensor);

    void deleteSensorById(Long id);
}