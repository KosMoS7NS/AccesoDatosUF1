package com.ifp.UF1.texto.application.port;

import java.io.IOException;
import java.util.List;

/**
 * Puerto compuesto por dos métodos.
 * <p>
 * EL primer método leerFichero devuelve una lista con todas las personas del fichero.txt
 * <p>
 * El segundo método leerFicheroNombre devuelve una lista con los datos de una persona del fichero.txt
 */
public interface PersonaFicheroLeerPort {

    /**
     *
     * @param ruta Ruta del fichero.txt
     * @return List
     * @throws IOException
     */
    List leerFichero(String ruta) throws IOException;

    /**
     *
     * @param ruta Ruta del fichero.txt
     * @param nombre Nombre a buscar en el fichero.txt
     * @return List
     * @throws IOException
     */
    List leerFicheroNombre(String ruta, String nombre) throws IOException;

}
