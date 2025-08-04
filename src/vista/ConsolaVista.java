package vista;

import modelo.Tablero;
import modelo.Casilla;

public class ConsolaVista {

    public void mostrarTablero(Tablero tablero) {
        System.out.print("   ");
        for (int col = 1; col <= Tablero.COLUMNAS; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int fila = 0; fila < Tablero.FILAS; fila++) {
            char letra = (char) ('A' + fila);
            System.out.print(letra + "  ");
            for (int col = 0; col < Tablero.COLUMNAS; col++) {
                Casilla casilla = tablero.getCasilla(fila, col);
                System.out.print(casilla.toString() + " ");
            }
            System.out.println();
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}