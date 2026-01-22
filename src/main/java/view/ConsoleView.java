package view;

import utils.Utils;

/**
 * VISTA (View): solo muestra información y pide datos al usuario.
 * Importante: NO crea el modelo Persona. Devuelve datos al controlador.
 *
 * Se ha definido como clase estática (métodos static) para simplificar.
 */
public final class ConsoleView {

    private ConsoleView() { }

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

    public static String pedirNombre() {
        return Utils.pideTextoNoVacio("Nombre: ");
    }

    public static int pedirEdad() {
        return Utils.pideEntero("Edad: ", 0, 130);
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarPersona(String descripcion) {
        System.out.println(descripcion);
    }

    public static void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }
}
