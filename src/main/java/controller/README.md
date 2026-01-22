# Paquete `controller`

Este paquete contiene el **Controlador** del patrón MVC.

El controlador es el encargado de **coordinar la interacción** entre:
- la Vista (entrada/salida por consola),
- y el Modelo (datos y validaciones).

---

## Clase: `PersonaController`

### ¿Para qué sirve?
`PersonaController` gestiona el flujo completo de la aplicación:
- muestra el menú,
- responde a las opciones del usuario,
- crea, consulta, actualiza y borra una `Persona`.

En este ejemplo, el controlador mantiene un **estado mínimo**:
- una única `Persona` llamada `personaActual`.

Esto se hace así para simplificar el ejemplo y facilitar su comprensión.

---

## Métodos principales

### `run()`
- Implementa el **bucle principal** del programa.
- Muestra el menú usando la vista.
- Ejecuta la opción elegida por el usuario.
- Repite hasta que se selecciona la opción de salir.

Es el método que “lleva el control” de la aplicación.

---

## Métodos CRUD sobre `Persona`

### `crearPersona()`
- Pide el nombre y la edad a la vista.
- Crea una nueva instancia de `Persona`.
- Guarda la persona como `personaActual`.

### `mostrarPersona()`
- Comprueba si existe una persona creada.
- Si no existe, muestra un mensaje informativo.
- Si existe, muestra sus datos.

### `actualizarPersona()`
- Comprueba que exista una persona.
- Pide nuevos datos a la vista.
- Actualiza el modelo usando sus setters.

### `borrarPersona()`
- Elimina la referencia a la persona actual.
- Informa al usuario del resultado.

## Métodos sin vista

En este proyecto, los métodos `crearPersona()`, `mostrarPersona()`, `actualizarPersona()`, y `borrarPersona()` del controlador **piden los datos** a la vista, muestran mensajes al usuario...  
Esto se hace así para mantener el ejemplo **muy simple** y porque el controlador es el componente que **orquesta el flujo** (menú → pedir datos → actualizar modelo → mostrar resultado).

Para mejorar la testabilidad y desacoplar la entrada por consola, el controlador también ofrece métodos alternativos que recibe los datos como parámetros, o los devuelven en lugar de imprimirlos.  

- `void crearPersona(String nombre, int edad)`
- `void actualizarPersona(String nombre, int edad)`
- `void borrarPersonaSinVista()`
- `Persona getPersonaActual()`

En proyectos más grandes, es común que la interacción (I/O) esté aún más separada y que el controlador se centre en métodos que reciben datos ya validados o transformados.

## Relación con otras clases
- **Usa**:
    - `view.ConsoleView`
    - `model.Persona`
- **No lee directamente de consola**.
- **No imprime directamente por pantalla** (delegado a la vista).
