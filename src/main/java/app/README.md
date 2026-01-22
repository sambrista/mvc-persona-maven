# Paquete `app`

Este paquete contiene el **punto de entrada de la aplicación**.

En una arquitectura MVC, es buena práctica separar el arranque del programa del resto de capas
(modelo, vista y controlador). De este modo, cada parte tiene una responsabilidad clara.

## Clase: `Main`

### ¿Para qué sirve?
La clase `Main` es la encargada de **iniciar la aplicación**.  
Contiene el método `main`, que es el primer método que ejecuta Java al arrancar el programa.

### Método principal

#### `public static void main(String[] args)`
- Crea una instancia del controlador (`PersonaController`).
- Lanza la ejecución del programa llamando a su método `run()`.

Esta clase **no contiene lógica de negocio**, no muestra menús y no trabaja directamente con datos.
Su única función es **arrancar y delegar**.

## Relación con otras clases
- **Usa**: `controller.PersonaController`
- **No debe usar directamente**:
    - `model.Persona`
    - `view.ConsoleView`
    - `utils.Utils`

Esto refuerza la idea de que `Main` solo sirve para iniciar el programa.
