package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaControllerTest {

    @Test
    @DisplayName("Al crear persona el modelo queda actualizado")
    void alCrearPersonaElModeloQuedaActualizado() {
        PersonaController controller = new PersonaController();

        controller.crearPersona("Luis", 30);

        assertNotNull(controller.getPersonaActual());
        assertEquals("Luis", controller.getPersonaActual().getNombre());
        assertEquals(30, controller.getPersonaActual().getEdad());
    }

    @Test
    @DisplayName("Actualizar persona cambia los datos")
    void actualizarPersonaCambiaLosDatos() {
        PersonaController controller = new PersonaController();
        controller.crearPersona("Eva", 25);

        controller.actualizarPersona("Eva María", 26);

        assertEquals("Eva María", controller.getPersonaActual().getNombre());
        assertEquals(26, controller.getPersonaActual().getEdad());
    }

    @Test
    @DisplayName("Borrar persona deja el modelo a null")
    void borrarPersonaDejaElModeloANull() {
        PersonaController controller = new PersonaController();
        controller.crearPersona("Pepe", 40);

        controller.borrarPersonaSinVista();

        assertNull(controller.getPersonaActual());
    }
}
