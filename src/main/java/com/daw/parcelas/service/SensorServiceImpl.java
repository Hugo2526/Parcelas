package com.daw.parcelas.service;

import com.daw.parcelas.controller.RecursoNoEncontradoException;
import com.daw.parcelas.model.Sensor;
import com.daw.parcelas.model.TipoSensor;
import com.daw.parcelas.repository.SensorRepository;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorServiceImpl implements SensorService {

    private static final Logger logger = LoggerFactory.getLogger(SensorServiceImpl.class);

    public final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Page<Sensor> getAllSensorsByNameAndTipoSensors(String name, String tipo) {
        if (tipo.equals("TODOS")) {
            return sensorRepository.findAllByNameContainingIgnoreCase(name);
        } else {
            return sensorRepository.findAllByNameContainingIgnoreCaseAndTipoEquals(name, TipoSensor.valueOf(tipo));
        }
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Sensor con id " +
                                id + " no encontrado"));
    }

    @Override
    public List<Sensor> getAllSensorsTemperatura() {
        logger.debug("Obteniendo todos los sensores de temperatura");
        return sensorRepository.findAllByTipoEquals(TipoSensor.TEMPERATURA);
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
    }
}