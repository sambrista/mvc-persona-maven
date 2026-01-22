# MVC Persona (Java + Maven + JUnit) super simple

Este proyecto es un ejemplo **sencillísimo** para ilustrar la arquitectura **MVC** (Modelo–Vista–Controlador) en Java, usando **Maven** y **JUnit 5**.

## ¿Qué puedo aprender?

Observa como:

- La clase `Persona` de **model** se encarga de contener los datos de una persona, y comprobar que sean correctos.
- La clase `ConsoleView` de **view** se encarga de mostrar mensajes, errores, personas... por pantalla, y pedir datos al usuario.
- La clase `PersonaController` de **controller** nos permite realizar operaciones sobre una persona, utilizando `Persona` para gestionar la información y `ConsoleView` para mostrar y pedir datos.
- La clase `Main` de **app** contiene el programa principal, que mediante el controlador realiza las operaciones que el usuario demanda.
- La clase `Utils` de **utils** proporciona métodos independientes que son útiles.

En cada paquete encontrarás un archivo `README.md` que explica más a fondo la clase que contiene.

## Relación entre capas

`Main` → llama a → `Controller`

`Controller` ↔ coordina ↔ `View` (consola)

`Controller` → crea/actualiza → `Model`

`View` → usa → `Utils` (lectura segura de consola)

## Estructura de paquetes

- `app`
  - `Main` (arranque y flujo)
- `controller`
  - `PersonaController` (CRUD)
- `model`
  - `Persona` (nombre, edad + validaciones)
- `view`
  - `ConsoleView` (menú y mensajes en consola, métodos `static`)
- `utils`
  - `Utils` (pideEntero / pideTextoNoVacio con validación y reintentos)

## Requisitos

- Java 17
- Maven 3.x

## Compilar

```bash
mvn clean package
```

## Ejecutar

Este proyecto incluye `exec-maven-plugin`, así que puedes ejecutar con:

```bash
mvn exec:java
```

## Pasar los tests (JUnit 5)

```bash
mvn test
```

## Ejemplo de uso (ejecución típica)

```text
==== MENÚ ====
1) Crear persona
2) Mostrar persona
3) Actualizar persona
4) Borrar persona
0) Salir
Elige una opción: 1
Nombre: Ana
Edad: 20
Persona creada correctamente.

==== MENÚ ====
...
Elige una opción: 2
Persona actual: Persona{nombre='Ana', edad=20}

==== MENÚ ====
Elige una opción: 0
Saliendo...
```

## Notas didácticas

- La **Vista no crea** `Persona`: solo pide/mostrar datos.
- El **Controlador** es quien crea y modifica el **Modelo**.
- `Utils` evita errores típicos (texto no numérico, valores fuera de rango, etc.) reintentando en bucle.
