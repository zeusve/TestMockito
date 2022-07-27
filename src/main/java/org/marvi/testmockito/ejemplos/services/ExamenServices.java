package org.marvi.testmockito.ejemplos.services;

import org.marvi.testmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenServices {
    Optional<Examen> findExamenPorNombre(String nombre);

    Examen findExamenPorNombreConPreguntas(String nombre);

    Examen guardar(Examen examen);
}
