package org.example.utils;

import java.util.Scanner;

public class Input {

    public static Scanner scanner = new Scanner(System.in);

    // =========================================================
    // LEITURA SEGURA DE INTEIROS
    // =========================================================
    public static int lerOpcao() {

        while (true) {

            try {

                int valor = Integer.parseInt(
                        scanner.nextLine()
                );

                return valor;

            } catch (NumberFormatException e) {

                System.out.print(
                        "  > Digite apenas números: "
                );
            }
        }
    }

    // =========================================================
    // LEITURA SEGURA DE TEXTO
    // =========================================================
    public static String lerTexto(String campo) {

        while (true) {

            String valor = scanner.nextLine();

            if (!valor.trim().isEmpty()) {
                return valor;
            }

            System.out.print("  > " + campo + " não pode ser vazio: ");
        }
    }

    // =========================================================
    // PAUSAR TELA
    // =========================================================
    public static void pausar(String mensagem) {

        System.out.println(mensagem);
        scanner.nextLine();
    }

    public static double lerDouble(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                return Double.parseDouble(
                        scanner
                                .nextLine()
                                .replace(",", ".")
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "  > Digite um valor válido!"
                );
            }
        }
    }
}