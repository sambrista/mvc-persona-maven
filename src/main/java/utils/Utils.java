package utils;

import view.ConsoleView;

import java.util.Scanner;

/**
 * Utils de consola: lectura segura (reintenta hasta que el dato sea válido).
 * Se usa desde la Vista (View) para pedir información al usuario.
 */
public final class Utils {
    private static final Scanner SC = new Scanner(System.in);

    /**
     * Solicita al usuario un número entero dentro de un rango específico.
     * Muestra un mensaje personalizado y valida que el número introducido sea
     * un entero válido y que esté en el rango especificado. Si el valor no es válido,
     * muestra un mensaje de error y vuelve a solicitar el dato en bucle.
     *
     * @param mensaje El mensaje que se mostrará al usuario para solicitar el dato.
     * @param min El valor mínimo aceptado para el número introducido.
     * @param max El valor máximo aceptado para el número introducido.
     * @return Un número entero dentro del rango especificado.
     */
    public static int pideEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);

            String linea = SC.nextLine();
            int valor;

            try {
                valor = Integer.parseInt(linea.trim());
            } catch (NumberFormatException ex) {
                ConsoleView.mostrarError("debes introducir un número entero válido.");
                continue;
            }

            if (valor < min || valor > max) {
                ConsoleView.mostrarError("el número debe estar entre " + min + " y " + max + ".");
                continue;
            }

            return valor;
        }
    }

    /**
     * Solicita al usuario que introduzca un texto no vacío.
     * Elimina los espacios en blanco del principio y final del texto,
     * y repite la solicitud si el dato introducido es nulo o vacío.
     *
     * @param mensaje El mensaje que se mostrará al usuario para solicitar el dato.
     * @return Una cadena de texto no vacía introducida por el usuario.
     */
    public static String pideTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            String texto = SC.nextLine();
            if (texto == null) {
                ConsoleView.mostrarError("debes introducir texto.");
                continue;
            }

            String limpio = texto.trim();
            if (limpio.isEmpty()) {
                ConsoleView.mostrarError("el texto no puede estar vacío.");
                continue;
            }

            return limpio;
        }
    }
}
