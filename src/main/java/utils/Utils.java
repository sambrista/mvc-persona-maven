package utils;

import view.ConsoleView;

import java.util.Scanner;

/**
 * Utils de consola: lectura segura (reintenta hasta que el dato sea válido).
 * Se usa desde la Vista (View) para pedir información al usuario.
 */
public final class Utils {
    private static final Scanner SC = new Scanner(System.in);

    private Utils() { }

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
