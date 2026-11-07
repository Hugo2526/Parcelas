package com.daw.parcelas.service;

import com.daw.parcelas.model.Parcela;

import java.util.List;

public interface ParcelaService {

    List<Parcela> listarTodas();

    Parcela buscarPorId(Long id);

    Parcela guardar(Parcela parcela);

    void eliminar(Long id);

}

