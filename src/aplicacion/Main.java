package aplicacion;

import controlador.JuegoControlador;
import modelo.Jugador;
import modelo.Partida;
import vista.ConsolaVista;

public class Main {
    public static void main(String[] args) {
        ConsolaVista vista = new ConsolaVista();
        Jugador jugador = new Jugador("Jugador 1");
        Partida partida = new Partida(jugador);
        JuegoControlador controlador = new JuegoControlador(partida, vista);

        controlador.iniciarJuego();
    }
}
