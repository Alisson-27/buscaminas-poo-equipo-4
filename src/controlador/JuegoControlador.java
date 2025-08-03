package controlador;

import modelo.Partida;
import modelo.CasillaYaDescubiertaException;
import modelo.EntradaInvalidaException;
import modelo.Tablero;
import vista.ConsolaVista;

import java.util.Scanner;

public class JuegoControlador {

    private Partida partida;
    private ConsolaVista vista;
    private Scanner scanner;

    public JuegoControlador(Partida partida, ConsolaVista vista) {
        this.partida = partida;
        this.vista = vista;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        vista.mostrarMensaje("Bienvenido al Buscaminas!");
        while (!partida.isTerminado()) {
            vista.mostrarTablero(partida.getTablero());
            try {
                String entrada = pedirEntrada();
                if (entrada.equalsIgnoreCase("salir")) {
                    vista.mostrarMensaje("Saliendo del juego. ¡Hasta luego!");
                    break;
                }
                if (entrada.startsWith("marcar ")) {
                    marcarCasilla(entrada.substring(7).trim());
                } else {
                    descubrirCasilla(entrada);
                }
            } catch (EntradaInvalidaException | CasillaYaDescubiertaException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }

        if (partida.isGanado()) {
            vista.mostrarMensaje("¡Felicidades! ¡Has ganado!");
        } else if (partida.isTerminado()) {
            vista.mostrarMensaje("¡Has perdido! Encontraste una mina.");
            vista.mostrarTablero(partida.getTablero());
        }
    }

    private String pedirEntrada() {
        System.out.print("Ingrese coordenada (ejemplo A5) o 'marcar A5' o 'salir': ");
        return scanner.nextLine().trim();
    }

    private void descubrirCasilla(String coord) throws EntradaInvalidaException, CasillaYaDescubiertaException {
        int[] pos = validarCoordenada(coord);
        partida.descubrirCasilla(pos[0], pos[1]);
    }

    private void marcarCasilla(String coord) throws EntradaInvalidaException {
        int[] pos = validarCoordenada(coord);
        modelo.Casilla casilla = partida.getTablero().getCasilla(pos[0], pos[1]);
        if (casilla.isDescubierta()) {
            throw new EntradaInvalidaException("No puede marcar una casilla ya descubierta");
        }
        casilla.marcar();
    }

    private int[] validarCoordenada(String coord) throws EntradaInvalidaException {
        if (coord.length() < 2 || coord.length() > 3) {
            throw new EntradaInvalidaException("Formato inválido");
        }
        char letra = Character.toUpperCase(coord.charAt(0));
        if (letra < 'A' || letra >= ('A' + Tablero.FILAS)) {
            throw new EntradaInvalidaException("Fila inválida");
        }
        int fila = letra - 'A';

        String numStr = coord.substring(1);
        int columna;
        try {
            columna = Integer.parseInt(numStr) - 1;
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Columna inválida");
        }
        if (columna < 0 || columna >= Tablero.COLUMNAS) {
            throw new EntradaInvalidaException("Columna inválida");
        }
        return new int[]{fila, columna};
    }
}
