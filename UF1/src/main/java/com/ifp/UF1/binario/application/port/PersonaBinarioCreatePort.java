package com.ifp.UF1.binario.application.port;

import java.util.List;

/**
 * Puerto con el método de creación de Personas.
 */
public interface PersonaBinarioCreatePort {

    /**
     *
     * @return List
     * @throws Exception
     */
    List createPersona() throws Exception;
}
