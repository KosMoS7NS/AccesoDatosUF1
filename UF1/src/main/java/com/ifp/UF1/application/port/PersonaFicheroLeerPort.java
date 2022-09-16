package com.ifp.UF1.application.port;

import java.io.IOException;

public interface PersonaFicheroLeerPort {
    String leerFichero(String ruta) throws IOException;
}
