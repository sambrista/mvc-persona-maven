package app;

import controller.PersonaController;
import view.ConsoleView;

/**
 * Programa principal (Main): arranca la aplicación creando el controlador.
 * (La vista es estática, así que no se instancia).
 */
public class Main {
    public static void main(String[] args) {
        PersonaController controller = new PersonaController();
        int opcion;
        do {
            opcion = ConsoleView.mostrarMenuYLeerOpcion();

            switch (opcion) {
                case 1 -> controller.crearPersona();
                case 2 -> controller.mostrarPersona();
                case 3 -> controller.actualizarPersona();
                case 4 -> controller.borrarPersona();
                case 0 -> ConsoleView.mostrarMensaje("Saliendo...");
                default -> ConsoleView.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
