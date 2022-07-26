package org.marvi.testmockito.ejemplos.services;

import org.junit.jupiter.api.Test;
import org.marvi.testmockito.ejemplos.models.Examen;
import org.marvi.testmockito.ejemplos.repositories.ExamenRepository;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

    @Test
    void findExamenPorNombre() {
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenServices services = new ExamenServiceImpl(repository);
        List<Examen> datos = Arrays.asList(new Examen(5L, "Matemáticas"), new Examen(6L, "Lenguaje"),
                new Examen(7L, "Historia"));

        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = services.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matemáticas",examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenServices services = new ExamenServiceImpl(repository);
        List<Examen> datos = Collections.emptyList();

        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = services.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matemáticas",examen.get().getNombre());
    }
}