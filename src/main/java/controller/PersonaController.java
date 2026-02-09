package controller;

import model.Persona;
import view.ConsoleView;

/**
 * CONTROLADOR (Controller): coordina el flujo entre Vista y Modelo.
 * Gestiona UNA única Persona (suficiente para ilustrar MVC sin colecciones).
 */
public class PersonaController {

    /**
     * Representa la instancia actual de una Persona gestionada por el controlador.
     */
    private Persona personaActual;

    /**
     * Crea de forma interactiva una nueva instancia de la clase Persona y la asigna como la persona actual gestionada por el controlador.
     */
    public void crearPersona() {
        String nombre = ConsoleView.pedirNombre();
        int edad = ConsoleView.pedirEdad();

        this.personaActual = new Persona(nombre, edad);
        ConsoleView.mostrarMensaje("Persona creada correctamente.");
    }

    /**
     * Muestra la información de la persona actual almacenada en el controlador.
     * Si no hay ninguna persona creada, se genera un mensaje de error notificando
     * al usuario que aún no existe una persona para mostrar.
     */
    public void mostrarPersona() {
        if (this.personaActual == null) {
            ConsoleView.mostrarError("No hay ninguna persona creada todavía.");
            return;
        }
        ConsoleView.mostrarPersona(this.personaActual);
    }

    /**
     * Actualiza de forma interactiva la información de una persona existente gestionada por el controlador.
     */
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

    /**
     * Elimina la persona actualmente gestionada por el controlador y notifica a través de la vista.
     */
    public void borrarPersona() {
        if (this.personaActual == null) {
            ConsoleView.mostrarError("No hay persona para borrar.");
            return;
        }
        this.personaActual = null;
        ConsoleView.mostrarMensaje("Persona borrada correctamente.");
    }
}
