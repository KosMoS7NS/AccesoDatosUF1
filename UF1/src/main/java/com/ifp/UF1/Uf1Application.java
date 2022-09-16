package com.ifp.UF1;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifp.UF1.application.port.PersonaCreatePort;
import com.ifp.UF1.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.UF1.application.port.PersonaReadPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Uf1Application implements CommandLineRunner {

    @Autowired
    PersonaCreatePort personaCreatePort;

    @Autowired
    PersonaReadPort personaReadPort;

    @Autowired
    PersonaFicheroAlmacenarPort personaFicheroAlmacenarPort;

    public static void main(String[] args) {
	SpringApplication.run(Uf1Application.class, args);
    }

    /**
     * Se muesta en los logs, una lista con la información de la Persona.
     * 
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
	try {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Intrdouce un ID: ");
	    Integer id = scanner.nextInt();

	    System.out.println("Intrdouce tu nombre: ");
	    String nombre = scanner.next();

	    scanner.nextLine();
	    System.out.println("Intrdouce tus apellidos: ");
	    String apellidos = scanner.nextLine();

	    System.out.println("Intrdouce tu edad: ");
	    int edad = scanner.nextInt();

	    System.out.println("Intrdouce tu ciudad: ");
	    String ciudad = scanner.next();

	    System.out.println("Intrdouce tu nacionalidad: ");
	    String nacionalidad = scanner.next();

	    personaFicheroAlmacenarPort.almacenarFichero(
		    personaCreatePort.createPersona(id, nombre, apellidos, ciudad, nacionalidad, edad));
	} catch (Exception e) {
	    throw new Exception("Introduce correctamente los datos");
	}

	log.info("PERSONA -> {}", personaReadPort.getAll());
    }
}
