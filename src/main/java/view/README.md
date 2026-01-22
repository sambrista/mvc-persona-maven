# Paquete `view`

Este paquete contiene la **Vista** del patrón MVC.

La vista se encarga exclusivamente de la **interacción con el usuario**:
- mostrar menús,
- mostrar mensajes,
- pedir datos por consola.

No contiene lógica de negocio ni crea objetos del modelo.

## Clase: `ConsoleView`

### ¿Para qué sirve?
`ConsoleView` centraliza toda la entrada y salida por consola.

Está diseñada como una clase **estática** para simplificar el ejemplo y evitar instanciaciones innecesarias en un proyecto introductorio.

## Métodos

### `mostrarMenuYLeerOpcion()`
- Muestra el menú principal.
- Pide una opción al usuario.
- Devuelve un número entero válido.

### `pedirNombre()`
- Solicita un texto no vacío.
- Delegando la validación en `Utils`.

### `pedirEdad()`
- Solicita un número entero dentro de un rango válido.
- Delegando la validación en `Utils`.

### `mostrarMensaje(String mensaje)`
- Muestra mensajes informativos o de error.

### `mostrarPersona(String descripcion)`
- Muestra información relacionada con la persona actual.

## Relación con otras clases
- **Usa**:
    - `utils.Utils`
- **Es usada por**:
    - `controller.PersonaController`
