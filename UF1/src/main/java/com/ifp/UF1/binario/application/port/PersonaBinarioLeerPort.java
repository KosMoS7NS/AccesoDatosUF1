package com.ifp.UF1.binario.application.port;

import java.io.IOException;
import java.util.List;

public interface PersonaBinarioLeerPort {
    List leerBinario(String ruta) throws IOException, ClassNotFoundException;
}
