package com.ifp.UF1.application.port;

import java.io.IOException;
import java.util.List;

public interface PersonaFicheroLeer {
    String leerFichero(String ruta) throws IOException;

//    List leerFicheroNombre(String ruta) throws IOException;

    List leerFicheroNombre(String ruta, String nombre) throws IOException;
}
