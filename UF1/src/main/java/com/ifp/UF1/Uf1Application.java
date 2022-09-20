package com.ifp.UF1;

import com.ifp.UF1.binario.application.port.PersonaBinarioAlmacenarPort;
import com.ifp.UF1.binario.application.port.PersonaBinarioCreatePort;
import com.ifp.UF1.binario.application.port.PersonaBinarioLeerPort;
import com.ifp.UF1.texto.application.port.PersonaCreatePort;
import com.ifp.UF1.texto.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.UF1.texto.application.port.PersonaFicheroLeerPort;
import com.ifp.UF1.shared.port.PersonaMenuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

import static com.ifp.UF1.shared.configuration.PersonaStaticConfig.*;


/**
 * Este proyecto se realiza mediante una Arquitectura Hexagonal para no exponer las Entidades.
 * <p>
 * PersonaBinarioNoEntity es referenciada como Entity, para demostrar como se organizaría el proyecto con una BBDD
 * <p>
 * Las interfaces son referenciadas como ports.
 * <p>
 * Las clases con métodos son referencias como use case.
 * <p>
 * No se utilizan controladores con peticiones POST/GET ya que no es el objetivo de este ejercicio.
 */
@Slf4j
@SpringBootApplication
public class Uf1Application implements CommandLineRunner {

    @Autowired
    PersonaCreatePort personaCreatePort;

    @Autowired
    PersonaFicheroAlmacenarPort personaFicheroAlmacenarPort;

    @Autowired
    PersonaFicheroLeerPort personaFicheroLeerPort;

    @Autowired
    PersonaBinarioCreatePort personaBinarioCreatePort;

    @Autowired
    PersonaBinarioAlmacenarPort personaBinarioAlmacenarPort;
    @Autowired
    PersonaBinarioLeerPort personaBinarioLeerPort;

    @Autowired
    PersonaMenuPort personaMenuPort;

    public static void main(String[] args) {
        SpringApplication.run(Uf1Application.class, args);
    }

    /**
     * Se muesta en los logs, una lista con la información de la Persona si el fichero no existe.
     * Se controla el metodo con una excepcion por si hay algun fallo en la introducción de datos.
     *
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        switch (personaMenuPort.menu()) {
            case 1 -> personaFicheroAlmacenarPort.almacenarFichero(personaCreatePort.createPersona());
            case 2 -> personaBinarioAlmacenarPort.almacenarBinario(personaBinarioCreatePort.createPersona());
            case 4 -> System.out.println(personaFicheroLeerPort.leerFichero(RUTA));
            case 5 -> System.out.println(personaFicheroLeerPort.leerFicheroNombre(RUTA, NOMBRE));
            case 6 -> System.out.println(personaBinarioLeerPort.leerBinario(RUTA));
            case 7 -> System.out.println(personaFicheroLeerPort.leerFicheroNombre(RUTA, NOMBRE));
        }
    }
}
