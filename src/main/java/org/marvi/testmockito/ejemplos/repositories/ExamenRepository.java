package org.marvi.testmockito.ejemplos.repositories;

import org.marvi.testmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);

    List<Examen> findAll();
}
