package com.ifp.UF1;

import com.ifp.UF1.application.port.*;
import com.ifp.UF1.configuration.PersonaStaticConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

import static com.ifp.UF1.configuration.PersonaStaticConfig.*;

/**
 * Este proyecto se realiza mediante una Arquitectura Hexagonal para no exponer las Entidades.
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
            case 3 -> System.out.println(personaFicheroLeerPort.leerFichero(RUTA));
            case 4 -> System.out.println(personaFicheroLeerPort.leerFicheroNombre(RUTA, NOMBRE));
        }
    }
}
