package controller;

import model.Persona;
import view.ConsoleView;

/**
 * CONTROLADOR (Controller): coordina el flujo entre Vista y Modelo.
 * Gestiona UNA única Persona (suficiente para ilustrar MVC sin colecciones).
 */
public class PersonaController {

    private Persona personaActual; // "estado" mínimo del ejemplo

    // CRUD (muy simple): Create
    public void crearPersona() {
        String nombre = ConsoleView.pedirNombre();
        int edad = ConsoleView.pedirEdad();

        this.personaActual = new Persona(nombre, edad);
        ConsoleView.mostrarMensaje("Persona creada correctamente.");
    }

    // CRUD: Read
    public void mostrarPersona() {
        if (personaActual == null) {
            ConsoleView.mostrarPersona("No hay ninguna persona creada todavía.");
            return;
        }
        ConsoleView.mostrarPersona("Persona actual: " + personaActual);
    }

    // CRUD: Update
    public void actualizarPersona() {
        if (personaActual == null) {
            ConsoleView.mostrarMensaje("No hay persona para actualizar. Primero crea una.");
            return;
        }

        String nombre = ConsoleView.pedirNombre();
        int edad = ConsoleView.pedirEdad();

        personaActual.setNombre(nombre);
        personaActual.setEdad(edad);

        ConsoleView.mostrarMensaje("Persona actualizada correctamente.");
    }

    // CRUD: Delete
    public void borrarPersona() {
        if (personaActual == null) {
            ConsoleView.mostrarMensaje("No hay persona para borrar.");
            return;
        }
        personaActual = null;
        ConsoleView.mostrarMensaje("Persona borrada correctamente.");
    }

    // --- Métodos auxiliares para testing determinista (sin consola) ---

    public void crearPersona(String nombre, int edad) {
        this.personaActual = new Persona(nombre, edad);
    }

    public void actualizarPersona(String nombre, int edad) {
        if (personaActual == null) {
            throw new IllegalStateException("No existe persona para actualizar.");
        }
        personaActual.setNombre(nombre);
        personaActual.setEdad(edad);
    }

    public void borrarPersonaSinVista() {
        personaActual = null;
    }

    public Persona getPersonaActual() {
        return personaActual;
    }
}
