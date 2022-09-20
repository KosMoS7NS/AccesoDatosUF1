package com.ifp.UF1.binario.application.port;

import java.io.IOException;
import java.util.List;

/**
 * Puerto compuesto por dos métodos.
 * <p>
 * EL primer método leerFichero devuelve una lista con todas las personas del fichero.dat
 * <p>
 * El segundo método leerFicheroNombre devuelve una lista con los datos de una persona del fichero.dat
 */
public interface PersonaBinarioLeerPort {
    /**
     *
     * @param ruta del fichero.dat
     * @return List
     * @throws IOException
     * @throws ClassNotFoundException
     */
    List leerBinario(String ruta) throws IOException, ClassNotFoundException;

    /**
         * @param ruta Ruta del fichero.dat
         * @param nombre Nombre de la persona a buscar en el fichero.dat
         * @return List
         * @throws IOException
         */
    List leerFicheroNombre(String ruta, String nombre) throws IOException, ClassNotFoundException;
}
