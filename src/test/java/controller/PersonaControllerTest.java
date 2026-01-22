package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaControllerTest {

    @Test
    void alCrearPersonaElModeloQuedaActualizado() {
        PersonaController controller = new PersonaController();

        controller.crearPersona("Luis", 30);

        assertNotNull(controller.getPersonaActual());
        assertEquals("Luis", controller.getPersonaActual().getNombre());
        assertEquals(30, controller.getPersonaActual().getEdad());
    }

    @Test
    void actualizarPersonaCambiaLosDatos() {
        PersonaController controller = new PersonaController();
        controller.crearPersona("Eva", 25);

        controller.actualizarPersona("Eva María", 26);

        assertEquals("Eva María", controller.getPersonaActual().getNombre());
        assertEquals(26, controller.getPersonaActual().getEdad());
    }

    @Test
    void borrarPersonaDejaElModeloANull() {
        PersonaController controller = new PersonaController();
        controller.crearPersona("Pepe", 40);

        controller.borrarPersonaSinVista();

        assertNull(controller.getPersonaActual());
    }
}
