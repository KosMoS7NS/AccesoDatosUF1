package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaMenu;
import com.ifp.UF1.configuration.PersonaStaticConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Slf4j
public class PersonaMenuUseCase implements PersonaMenu {

    @Override
    public int menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int respuesta;

        System.out.println("=====================================");
        System.out.println("Introduce una opción: ");

        System.out.println("1) Escribir");
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
                        PersonaStaticConfig.RUTA = scanner.next();

                        System.out.println("=====================================");

                        System.out.println("3) Leer todo el fichero");
                        System.out.println("4) Leer una persona");
                        PersonaStaticConfig.NOMBRE = scanner.next();

                        respuesta = scanner.nextInt();
                        System.out.println("=====================================");
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
