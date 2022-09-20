package com.ifp.UF1.shared;

import com.ifp.UF1.shared.configuration.PersonaStaticConfig;
import com.ifp.UF1.shared.port.PersonaMenuPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static com.ifp.UF1.shared.configuration.PersonaStaticConfig.*;

/**
 * Esta clase esta compuesta de un menú en el cual devuelve ciertos números que se utilizarán en el main para llamar
 * a otros métodos
 */
@Service
public class PersonaMenuUseCase implements PersonaMenuPort {

    /**
     * @return int
     * @throws Exception
     */
    @Override
    public int menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int respuesta;

        System.out.println("=====================================");
        System.out.println("Introduce una opción: ");

        System.out.println("1) Escribir fichero - 3 MAX");
        System.out.println("2) Escribir binario - 3 MAX");
        System.out.println("3) Leer fichero");
        System.out.println("0) Salir");

        System.out.println("=====================================");
        respuesta = scanner.nextInt();

        if (respuesta == 1 || respuesta == 2 || respuesta == 3) {
            switch (respuesta) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    try {
                        System.out.println("Introduce el nombre del fichero: ");
                        RUTA = scanner.next();

                        System.out.println("=====================================");

                        System.out.println("4) Leer todo el fichero - TEXTO");
                        System.out.println("5) Leer una persona - TEXTO");
                        System.out.println("6) Leer todo el fichero - BINARIO");
                        System.out.println("7) Leer una persona - BINARIO");
                        System.out.println("0) Salir");

                        respuesta = scanner.nextInt();
                        System.out.println("=====================================");

                        if (respuesta == 4 || respuesta == 6) return respuesta;
                        if (respuesta == 5 || respuesta == 7) {
                            System.out.println("Introduce el nombre de la Persona: ");
                            NOMBRE = scanner.next();
                            return respuesta;

                        }

                        break;

                    } catch (Exception e) {
                        throw new Exception("Nombre no válido");
                    }
            }

        } else return 0;

        return respuesta;
    }
}
