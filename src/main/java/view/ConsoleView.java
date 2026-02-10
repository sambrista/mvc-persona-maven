package view;

import model.Persona;
import utils.Utils;

/**
 * VISTA (View): solo muestra información y pide datos al usuario.
 * Importante: No crea el modelo Persona. Devuelve datos al controlador.
 */
public final class ConsoleView {

    private ConsoleView() { /* Constructor oculto para evitar crear objetos de esta clase */ }

    /**
     * Muestra un menú de opciones para la gestión de personas y solicita la entrada de una opción por parte del usuario.
     * La selección del usuario es validada para que sea un valor entero dentro del rango de opciones disponibles.
     *
     * @return Un número entero que representa la opción seleccionada por el usuario, entre 0 y 4.
     */
    public static int mostrarMenuYLeerOpcion() {
        System.out.println();
        System.out.println("==== MENÚ ====");
        System.out.println("1) Crear persona");
        System.out.println("2) Mostrar persona");
        System.out.println("3) Actualizar persona");
        System.out.println("4) Borrar persona");
        System.out.println("0) Salir");

        return Utils.pideEntero("Elige una opción: ", 0, 4);
    }

    /**
     * Solicita al usuario que introduzca un nombre no vacío.
     * La validación garantiza que el texto introducido no sea nulo ni esté vacío tras eliminar espacios en blanco.
     * Encargada de interactuar exclusivamente con el usuario a través de la consola.
     *
     * @return Una cadena de texto no vacía que representa el nombre introducido por el usuario.
     */
    public static String pedirNombre() {
        return Utils.pideTextoNoVacio("Nombre: ");
    }

    /**
     * Solicita al usuario que introduzca una edad válida.
     * La edad debe ser un número entero dentro del rango de 0 a 130, ambos inclusive.
     * Si el valor introducido no es válido, se muestra un mensaje de error
     * y se solicita nuevamente en un bucle hasta recibir un dato correcto.
     *
     * @return Un número entero que representa la edad introducida por el usuario,
     *         dentro del rango permitido (de 0 a 130).
     */
    public static int pedirEdad() {
        return Utils.pideEntero("Edad: ", 0, 130);
    }

    /**
     * Muestra un mensaje en la consola.
     *
     * @param mensaje El mensaje que se desea mostrar.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Muestra la información de una persona en la consola.
     * Si el parámetro proporcionado es nulo, no se muestra nada.
     *
     * @param persona La instancia de Persona cuya información se desea mostrar.
     */
    public static void mostrarPersona(Persona persona) {
        if (persona != null) {
            System.out.println("Persona almacenada: " + persona);
        }
    }

    /**
     * Muestra un mensaje de error precedido por la etiqueta "ERROR: ".
     * Este método está diseñado para informar visualmente al usuario
     * sobre algún problema ocurrido, diferenciando claramente los errores
     * de los mensajes ordinarios.
     *
     * @param mensaje El texto descriptivo del error que se mostrará en la consola.
     */
    public static void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }
}
