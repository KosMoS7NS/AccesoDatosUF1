package com.ifp.UF1;

import com.ifp.UF1.application.port.PersonaFicheroLeerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifp.UF1.application.port.PersonaCreatePort;
import com.ifp.UF1.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.UF1.application.port.PersonaReadPort;

import lombok.extern.slf4j.Slf4j;

/**
 * Este proyecto se realiza mediante una Arquitectura Hexagonal para no exponer las Entidades.
 * <p>
 * No se utilizan controladores con peticiones POST/GET ya que no es el objetivo de este ejercicio.
 */
@Slf4j
@SpringBootApplication
public class Uf1Application implements CommandLineRunner {

    @Autowired
    PersonaCreatePort personaCreatePort;

    @Autowired
    PersonaReadPort personaReadPort;

    @Autowired
    PersonaFicheroAlmacenarPort personaFicheroAlmacenarPort;

    @Autowired
    PersonaFicheroLeerPort personaFicheroLeerPort;

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
	try {
        if (personaFicheroAlmacenarPort.almacenarFichero(personaCreatePort.createPersona()))
            log.info("PERSONA -> {}", personaReadPort.getAll());

        System.out.println(personaFicheroLeerPort.leerFichero("Fichero.txt"));
    } catch (Exception e) {
	    throw new Exception("Introduce correctamente los datos");
	}
    }
}
