package model;

/**
 * MODELO (Model): almacena datos y aplica validaciones básicas.
 */
public class Persona {
    private String nombre;
    private int edad;

    /**
     * Constructor de la clase Persona.
     * Inicializa una nueva instancia de Persona con el nombre y la edad especificados.
     *
     * @param nombre El nombre de la persona. No puede ser null ni estar vacío.
     * @param edad La edad de la persona. Debe ser un valor no negativo.
     * @throws IllegalArgumentException Si el nombre es null o vacío, o si la edad es negativa.
     */
    public Persona(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    /**
     * Obtiene el valor actual de la propiedad nombre.
     *
     * @return el nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el valor de la propiedad nombre, aplicando validaciones para asegurar
     * que no sea nulo ni una cadena vacía. El nombre se almacena sin espacios en blanco iniciales
     * o finales.
     *
     * @param nombre el nuevo nombre de la persona. No puede ser null ni una cadena vacía.
     * @throws IllegalArgumentException si el nombre es null o una cadena vacía.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return la edad actual de la persona.
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Establece la edad de la persona, validando que no sea negativa.
     * Si se proporciona un valor negativo, se lanza una excepción.
     *
     * @param edad la edad de la persona. Debe ser un valor mayor o igual a 0.
     * @throws IllegalArgumentException si la edad es un valor negativo.
     */
    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.nombre + " (" + this.edad + " años)";
    }
}
