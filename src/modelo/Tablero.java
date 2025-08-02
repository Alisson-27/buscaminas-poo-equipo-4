package modelo;
import java.util.Random;

public class Tablero {
    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;
    public static final int MINAS = 10;

    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[FILAS][COLUMNAS];
        inicializarCasillas();
        colocarMinas();
        calcularMinasAlrededor();
    }

    private void inicializarCasillas() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);
            if (!casillas[fila][columna].tieneMina()) {
                casillas[fila][columna] = new Mina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAlrededor() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!casillas[i][j].tieneMina()) {
                    int contador = 0;
                    for (int filaAdj = i - 1; filaAdj <= i + 1; filaAdj++) {
                        for (int colAdj = j - 1; colAdj <= j + 1; colAdj++) {
                            if (filaAdj >= 0 && filaAdj < FILAS && colAdj >= 0 && colAdj < COLUMNAS) {
                                if (casillas[filaAdj][colAdj].tieneMina()) {
                                    contador++;
                                }
                            }
                        }
                    }
                    casillas[i][j].setMinasAlrededor(contador);
                }
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public void descubrirCasilla(int fila, int columna) throws CasillaYaDescubiertaException {
        Casilla casilla = getCasilla(fila, columna);
        casilla.descubrir();

        if (casilla.tieneMina()) {
            // Descubrió mina, juego perdido (se maneja en controlador)
            return;
        }
        if (casilla.getMinasAlrededor() == 0) {
            // Descubre casillas adyacentes vacías recursivamente
            for (int filaAdj = fila - 1; filaAdj <= fila + 1; filaAdj++) {
                for (int colAdj = columna - 1; colAdj <= columna + 1; colAdj++) {
                    if (filaAdj >= 0 && filaAdj < FILAS && colAdj >= 0 && colAdj < COLUMNAS) {
                        if (!casillas[filaAdj][colAdj].isDescubierta()) {
                            descubrirCasilla(filaAdj, colAdj);
                        }
                    }
                }
            }
        }
    }

    public boolean todasCasillasSegurasDescubiertas() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Casilla c = casillas[i][j];
                if (!c.tieneMina() && !c.isDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }
}


