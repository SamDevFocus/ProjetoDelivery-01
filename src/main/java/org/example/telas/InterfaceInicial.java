package org.example.telas;

import org.example.utils.Input;
import org.example.utils.Loading;

public class InterfaceInicial {
    public void opcoesInicial() {
        boolean rodando = true;
        while (rodando) {

            System.out.println("+---------------------------------+");
            System.out.println("|            DELIVERY             |");
            System.out.println("+---------------------------------+");
            System.out.println("|       1 - Restaurante           |");
            System.out.println("|       2 - Entregador            |");
            System.out.println("|       3 - Cliente               |");
            System.out.println("|       4 - Sair                  |");
            System.out.println("+---------------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcaoInicial = Input.scanner.nextInt();

            switch (opcaoInicial) {
                case 1:
                    System.out.println("Restarante");
                    InterfaceRestaurante restaurante = new InterfaceRestaurante();
                    restaurante.inicioRestaurante();
                    break;
                case 2:
                    System.out.println("Entregador");
                    InterfaceEntregador entregador = new InterfaceEntregador();
                    entregador.inicioEntregador();
                    break;
                case 3:
                    System.out.println("Cliente");
                    InterfaceCliente cliente = new InterfaceCliente();
                    cliente.inicioCliente();
                    break;
                case 4:
                    System.out.println("Até logo!");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

        }
    }
}