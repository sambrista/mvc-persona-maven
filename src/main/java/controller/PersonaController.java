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
        if (this.personaActual == null) {
            ConsoleView.mostrarError("No hay ninguna persona creada todavía.");
            return;
        }
        ConsoleView.mostrarPersona(this.personaActual);
    }

    // CRUD: Update
    public void actualizarPersona() {
        if (this.personaActual == null) {
            ConsoleView.mostrarError("No hay persona para actualizar. Primero crea una.");
            return;
        }

        String nombre = ConsoleView.pedirNombre();
        int edad = ConsoleView.pedirEdad();

        this.personaActual.setNombre(nombre);
        this.personaActual.setEdad(edad);

        ConsoleView.mostrarMensaje("Persona actualizada correctamente.");
    }

    // CRUD: Delete
    public void borrarPersona() {
        if (this.personaActual == null) {
            ConsoleView.mostrarError("No hay persona para borrar.");
            return;
        }
        this.personaActual = null;
        ConsoleView.mostrarMensaje("Persona borrada correctamente.");
    }

    // --- Métodos auxiliares sin vista ---

    public void crearPersona(String nombre, int edad) {
        this.personaActual = new Persona(nombre, edad);
    }

    public void actualizarPersona(String nombre, int edad) {
        if (this.personaActual == null) {
            throw new IllegalStateException("No existe persona para actualizar.");
        }
        this.personaActual.setNombre(nombre);
        this.personaActual.setEdad(edad);
    }

    public void borrarPersonaSinVista() {
        this.personaActual = null;
    }

    public Persona getPersonaActual() {
        return this.personaActual;
    }
}
