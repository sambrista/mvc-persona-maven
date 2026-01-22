# Paquete `utils`

Este paquete contiene **utilidades reutilizables** para la entrada de datos por consola.

Su objetivo es evitar errores comunes y repetir código en la vista.

## Clase: `Utils`

### ¿Para qué sirve?
Centraliza la lógica de lectura y validación de datos introducidos por el usuario,
asegurando que el programa no falle por entradas incorrectas.

Es una clase:
- `final`
- con constructor privado
- y métodos estáticos

## Métodos

### `pideEntero(String mensaje, int min, int max)`
- Muestra un mensaje al usuario.
- Lee el valor introducido por consola.
- Comprueba:
    - que sea un número entero,
    - que esté dentro del rango `[min, max]`.
- Si el valor no es válido:
    - muestra un mensaje de error,
    - vuelve a pedir el dato en bucle.

### `pideTextoNoVacio(String mensaje)`
- Solicita un texto al usuario.
- Elimina espacios sobrantes.
- Impide cadenas vacías o solo con espacios.
- Repite hasta que el dato sea válido.

## Relación con otras clases
- **Usada por**:
    - `view.ConsoleView`
- **No depende de**:
    - `controller`
    - `model`

Esto mantiene las utilidades desacopladas del MVC.
