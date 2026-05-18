package org.example.utils;

public class Loading {

    // =========================================================
    // LIMPAR TELA
    // =========================================================
    public static void limparTela() {

        for (int i = 0; i < 35; i++) {

            System.out.println();
        }
    }

    // =========================================================
    // TELA DE CARREGAMENTO
    // =========================================================
    public static void LimparTerminal(String mensagem) {

        limparTela();

        System.out.println(mensagem);

        esperar(1200);

        limparTela();
    }

    // =========================================================
    // ESPERAR
    // =========================================================
    public static void esperar(int tempo) {

        try {

            Thread.sleep(tempo);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}