package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TableroTest {

    @Test
    public void testColocacionMinas() {
        Tablero tablero = new Tablero();
        int minasContadas = 0;
        for (int i = 0; i < Tablero.FILAS; i++) {
            for (int j = 0; j < Tablero.COLUMNAS; j++) {
                Casilla c = tablero.getCasilla(i, j);
                if (c.tieneMina()) minasContadas++;
            }
        }
        assertEquals(Tablero.MINAS, minasContadas);
    }

    @Test
    public void testMinasAlrededor() {
        Tablero tablero = new Tablero();
        for (int i = 0; i < Tablero.FILAS; i++) {
            for (int j = 0; j < Tablero.COLUMNAS; j++) {
                Casilla c = tablero.getCasilla(i, j);
                if (!c.tieneMina()) {
                    int contador = 0;
                    for (int filaAdj = i - 1; filaAdj <= i + 1; filaAdj++) {
                        for (int colAdj = j - 1; colAdj <= j + 1; colAdj++) {
                            if (filaAdj >= 0 && filaAdj < Tablero.FILAS && colAdj >= 0 && colAdj < Tablero.COLUMNAS) {
                                if (tablero.getCasilla(filaAdj, colAdj).tieneMina()) {
                                    contador++;
                                }
                            }
                        }
                    }
                    assertEquals(contador, c.getMinasAlrededor());
                }
            }
        }
    } 

    @Test
    public void testDescubrirCasillaYaDescubierta() {
        Tablero tablero = new Tablero();
        try {
            tablero.descubrirCasilla(0, 0);
            assertThrows(modelo.CasillaYaDescubiertaException.class, () -> {
                tablero.descubrirCasilla(0, 0);
            });
        } catch (Exception e) {
            fail("No se esperaba excepción al descubrir la primera casilla");
        }
    } 

    @Override
    public String toString() {
        return "TableroTest []";
    }
}