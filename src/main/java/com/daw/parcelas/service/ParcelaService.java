package com.daw.parcelas.service;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;

import java.util.List;

public interface ParcelaService {

    List<Parcela> listarTodas();

    Parcela buscarPorId(Long id);

    Parcela guardar(Parcela parcela);

    void eliminar(Long id);

    double superficieTotal();

    List<Parcela> findByTipoCultivo(TipoCultivo tipoCultivo);

    List<Parcela> findAllByOrderByNombreAsc();
}

