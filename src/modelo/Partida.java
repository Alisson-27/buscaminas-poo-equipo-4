package modelo;

public class Partida {
    private Tablero tablero;
    private Jugador jugador;
    private boolean terminado;
    private boolean ganado;

    public Partida(Jugador jugador) {
        this.jugador = jugador;
        this.tablero = new Tablero();
        this.terminado = false;
        this.ganado = false;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public boolean isGanado() {
        return ganado;
    }

    public void descubrirCasilla(int fila, int columna) throws CasillaYaDescubiertaException {
        tablero.descubrirCasilla(fila, columna);

        if (tablero.getCasilla(fila, columna).tieneMina()) {
            terminado = true;
            ganado = false;
            return;
        }

        if (tablero.todasCasillasSegurasDescubiertas()) {
            terminado = true;
            ganado = true;
        }
    }
}