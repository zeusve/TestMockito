package org.marvi.testmockito.ejemplos.services;

import org.marvi.testmockito.ejemplos.models.Examen;
import org.marvi.testmockito.ejemplos.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenServices {
    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository){
        this.examenRepository = examenRepository;
    }
    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll()
                .stream()
                .filter(e -> e.getNombre().equals(nombre))
                .findFirst();
    }
}
