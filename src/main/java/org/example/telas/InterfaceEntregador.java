package org.example.telas;

import org.example.utils.Input;

public class InterfaceEntregador {

    public void inicioEntregador(){
        boolean rodando = true;
        while (rodando) {

            System.out.println("+---------------------------------+");
            System.out.println("|            DELIVERY             |");
            System.out.println("+---------------------------------+");
            System.out.println("| Entregador                      |");
            System.out.println("+---------------------------------+");
            System.out.println("|       1 - Entrar                |");
            System.out.println("|       2 - Criar Conta           |");
            System.out.println("|       3 - Sair                  |");
            System.out.println("+---------------------------------+");
            System.out.print("Escolha uma opção: ");


            int opcaoInicialRestaurante = Input.scanner.nextInt();
            switch (opcaoInicialRestaurante) {
                case 1:
                    System.out.println("1 Entrar");
                    exibirLogin();
                    break;
                case 2:
                    System.out.println("2 Criar Conta");
                    exibirCadastro();
                    break;
                case 3:
                    System.out.println("3 Sair");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção invalida");

            }
        }
    }

    public void exibirLogin() {
        
    }
    public void exibirCadastro() {

    }
}
