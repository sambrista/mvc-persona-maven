package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    @DisplayName("No permite edad negativa - lanza IllegalArgumentException")
    void noPermiteEdadNegativa_lanzaIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Persona("Ana", -1));
        assertTrue(ex.getMessage().toLowerCase().contains("edad"));
    }

    @Test
    @DisplayName("Permite crear persona con datos válidos")
    void permiteCrearPersonaConDatosValidos() {
        Persona p = new Persona("Ana", 20);
        assertEquals("Ana", p.getNombre());
        assertEquals(20, p.getEdad());
    }
}