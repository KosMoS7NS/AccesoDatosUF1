package com.ifp.UF1.binario.application.port;

import java.io.IOException;
import java.util.List;

public interface PersonaBinarioLeerPort {
    List leerBinario(String ruta) throws IOException, ClassNotFoundException;

    /**
         * @param ruta   Ruta del fichero.txt
         * @param nombre Nombre de la persona
         * @return List
         * @throws IOException
         */
    List leerFicheroNombre(String ruta, String nombre) throws IOException, ClassNotFoundException;
}
