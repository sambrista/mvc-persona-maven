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


    /**
     * Crea una nueva instancia de la clase Persona con los datos proporcionados y la asigna
     * a la propiedad personaActual.
     *
     * @param nombre El nombre de la persona. No puede ser null ni vacío.
     * @param edad La edad de la persona. Debe ser un número entero no negativo.
     * @throws IllegalArgumentException Si el nombre es null o vacío, o si la edad es negativa.
     */
    public void crearPersona(String nombre, int edad) {
        this.personaActual = new Persona(nombre, edad);
    }

    /**
     * Actualiza los atributos de la persona gestionada en el controlador con los valores
     * proporcionados como parámetros.
     *
     * @param nombre el nuevo nombre de la persona. Debe ser no nulo ni vacío.
     * @param edad la nueva edad de la persona. Debe ser un valor mayor o igual a 0.
     * @throws IllegalStateException si no hay una persona existente para actualizar.
     * @throws IllegalArgumentException si el nombre es nulo/vacío o la edad es negativa.
     */
    public void actualizarPersona(String nombre, int edad) {
        if (this.personaActual == null) {
            throw new IllegalStateException("No existe persona para actualizar.");
        }
        this.personaActual.setNombre(nombre);
        this.personaActual.setEdad(edad);
    }

    /**
     * Elimina la referencia a la persona gestionada actualmente por el controlador.
     */
    public void borrarPersonaSinVista() {
        this.personaActual = null;
    }

    /**
     * Obtiene la instancia actual de la clase Persona que está siendo gestionada por el controlador.
     *
     * @return la persona actual gestionada por el controlador, o null si no existe ninguna.
     */
    public Persona getPersonaActual() {
        return this.personaActual;
    }
}
