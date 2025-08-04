## Buscaminas - Proyecto POO

---

## 👨‍💻 Integrantes del equipo

| Nombre Completo       |
|-----------------------|
| Alisson Herrera       |
| Francisco Litardo     |
| Bryan Ponce           |
| Martin Ortiz          |

---

Este proyecto es una implementación en consola del popular juego Buscaminas, desarrollado en Java siguiendo los principios de Programación Orientada a Objetos (POO), aplicando el patrón MVC, manejo de excepciones personalizadas, y pruebas unitarias con JUnit 5.

El tablero es de 10x10 casillas con 10 minas colocadas aleatoriamente. El jugador puede descubrir casillas o marcarlas como minas para evitar perder. El juego termina cuando se descubre una mina (derrota) o cuando se descubren todas las casillas seguras (victoria).

---

## Estructura del Proyecto
buscaminas/
├── src/
│   ├── modelo/
│   │   ├── Casilla.java
│   │   ├── CasillaYaDescubiertaException.java
│   │   ├── EntradaInvalidaException.java
│   │   ├── Mina.java
│   │   ├── Tablero.java
│   │   ├── Jugador.java
│   │   └── Partida.java
│   ├── vista/
│   │   └── ConsolaVista.java
│   ├── controlador/
│   │   └── JuegoControlador.java
│   ├── util/
│   │   ├── GestorArchivos.java
│   │   └── Constantes.java
│   └── aplicacion/
│       └── Main.java
├── test/
│   └── modelo/
│       └── TableroTest.java

---

## Instrucciones para ejecutar
1. Clonar repositorio y abrir en Eclipse.
2. Ejecutar la clase principal aplicacion.Main.
3. Seguir las instrucciones en consola para jugar.

---

## Técnica de Código Limpio Aplicada
- Principio KISS (Keep It Simple, Stupid).
- Encapsulamiento estricto.
- Excepciones personalizadas.
- Patrón MVC.
  
---
 
## Instrucciones para ejecutar
1. Clonar repositorio y abrir en Eclipse.
2. Ejecutar la clase principal aplicacion.Main.
3. Seguir las instrucciones en consola para jugar.

---

## Pruebas Unitarias
Se incluyen pruebas para verificar colocación de minas, conteo correcto y manejo de excepciones.
Ejecutar en Eclipse como JUnit Test en test/modelo/TableroTest.java.

---

## Técnica de Código Limpio Aplicada
- Principio KISS (Keep It Simple, Stupid).
- Encapsulamiento estricto.
- Excepciones personalizadas.
- Patrón MVC.

---

## 🛠️ Requisitos  
- **Java JDK 17+** ([Descargar aquí](https://www.oracle.com/java/technologies/javase-downloads.html)).  
- **IDE** (IntelliJ, Eclipse o VS Code con extensión Java).
- ![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)  
- ![License](https://img.shields.io/badge/License-MIT-green)  
- ![GitHub contributors](https://img.shields.io/github/contributors/Alisson-27/buscaminas-poo-equipo-4)  


---

## Repositorio
https://github.com/Alisson-27/buscaminas-poo-equipo-4

Gracias por jugar nuestro Buscaminas en consola.
