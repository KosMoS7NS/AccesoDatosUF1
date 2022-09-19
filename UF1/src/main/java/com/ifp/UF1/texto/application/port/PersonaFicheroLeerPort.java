package com.ifp.UF1.texto.application.port;

import java.io.IOException;
import java.util.List;

/**
 * Puerto compouesto por dos métodos.
 * <p>
 * EL primer método leerFichero devuelve una lista con todas las personas del fichero.txt
 * <p>
 * El segundo método leerFicheroNombre devuelve una lista con los datos de una persona del fichero.txt
 */
public interface PersonaFicheroLeerPort {

    List leerFichero(String ruta) throws IOException;

    List leerFicheroNombre(String ruta, String nombre) throws IOException;

}
