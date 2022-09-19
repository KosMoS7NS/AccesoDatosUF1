package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaMenuPort;
import com.ifp.UF1.configuration.PersonaStaticConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static com.ifp.UF1.configuration.PersonaStaticConfig.NOMBRE;
import static com.ifp.UF1.configuration.PersonaStaticConfig.RUTA;

/**
 * Esta clase esta compuesta de un menú en el cual devuelve ciertos números que se utilizarán en el main para llamar
 * a otros métodos
 */
@Service
@Slf4j
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

        System.out.println("1) Escribir - 3 MAX");
        System.out.println("2) Leer");

        System.out.println("=====================================");
        respuesta = scanner.nextInt();

        if (respuesta == 1 || respuesta == 2) {
            switch (respuesta) {

                case 1:
                    break;

                case 2:
                    try {
                        System.out.println("Introduce el nombre del fichero: ");
                        RUTA = scanner.next();

                        System.out.println("=====================================");

                        System.out.println("3) Leer todo el fichero");
                        System.out.println("4) Leer una persona");

                        respuesta = scanner.nextInt();
                        System.out.println("=====================================");

                        if (respuesta == 3) return respuesta;
                        if (respuesta == 4) {
                            System.out.println("Introduce el nombre de la Persona: ");
                            NOMBRE = scanner.next();

                        } else return 0;
                        break;

                    } catch (Exception e) {
                        throw new Exception("Nombre no válido");
                    }

                default:
                    break;

            }

        } else return 0;

        return respuesta;
    }
}
