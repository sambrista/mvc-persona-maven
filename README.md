# MVC Persona (Java + Maven + JUnit) — Ejemplo de consola (muy simple)

Este proyecto es un ejemplo **sencillísimo** para ilustrar la arquitectura **MVC** (Modelo–Vista–Controlador) en Java, usando **Maven** y **JUnit 5**.

## Objetivo didáctico

- Ver claramente cómo se relacionan:
  - **Model**: datos + validaciones
  - **View**: consola (mostrar/pedir datos)
  - **Controller**: coordina el flujo
  - **Main**: punto de entrada
- CRUD mínimo sobre una única entidad `Persona`.

## Relación entre capas (diagrama textual)

`Main` → llama a → `Controller`

`Controller` ↔ coordina ↔ `View` (consola)

`Controller` → crea/actualiza → `Model`

`View` → usa → `Utils` (lectura segura de consola)

## Estructura de paquetes

- `app`
  - `Main` (arranque)
- `controller`
  - `PersonaController` (flujo + CRUD)
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
