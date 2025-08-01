
package util;

import modelo.Partida;

import java.io.*;

public class GestorArchivos {

    private static final String ARCHIVO_GUARDADO = "guardado.dat";

    public static void guardarPartida(Partida partida) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_GUARDADO))) {
            oos.writeObject(partida);
        }
    }

    public static Partida cargarPartida() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_GUARDADO))) {
            return (Partida) ois.readObject();
        }
    }

    public static boolean existeGuardado() {
        File archivo = new File(ARCHIVO_GUARDADO);
        return archivo.exists();
    }
}
