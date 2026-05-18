package org.example.telas;

import org.example.models.Produto;
import org.example.models.Restaurante;
import org.example.services.ProdutoService;
import org.example.utils.Input;
import org.example.utils.Loading;

import java.util.List;

import static org.example.utils.Loading.limparTela;

public class InterfaceProdutoRestaurante {

    private ProdutoService produtoService = new ProdutoService();

    public void menu(Restaurante restauranteLogado) {

        boolean rodando = true;

        while (rodando) {

            Loading.LimparTerminal(
                    "Carregando cardápio..."
            );

            System.out.println("┌──────────────────────────────────┐");
            System.out.println("│        GERENCIAR CARDÁPIO        │");

            System.out.printf (
                    "│  Restaurante: %-17s│%n",
                    restauranteLogado.getNome()
            );

            System.out.println("├──────────────────────────────────┤");
            System.out.println("│                                  │");
            System.out.println("│  [1] Criar Produto               │");
            System.out.println("│  [2] Listar Produtos             │");
            System.out.println("│  [3] Deletar Produto             │");
            System.out.println("│                                  │");
            System.out.println("│  [0] Voltar                      │");
            System.out.println("│                                  │");
            System.out.println("└──────────────────────────────────┘");

            System.out.print("  > ");

            int opcao =
                    Input.lerOpcao();

            switch (opcao) {

                case 1:

                    criarProduto(
                            restauranteLogado
                    );

                    break;

                case 2:

                    listarProdutos(
                            restauranteLogado
                    );

                    break;

                case 3:

                    deletarProduto(
                            restauranteLogado
                    );

                    break;

                case 0:

                    Loading.LimparTerminal(
                            "Voltando..."
                    );

                    rodando = false;
                    break;

                default:

                    System.out.println(
                            "\n  > Opção inválida!"
                    );

                    Loading.esperar(1200);
            }
        }
    }

    public void criarProduto(Restaurante restauranteLogado) {

        Loading.LimparTerminal(
                "Abrindo cadastro..."
        );

        Produto p = new Produto();

        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│          NOVO PRODUTO            │");
        System.out.println("├──────────────────────────────────┤");

        System.out.printf (
                "│  Restaurante: %-17s│%n",
                restauranteLogado.getNome()
        );

        System.out.println("└──────────────────────────────────┘");

        System.out.print("\n  > Nome: ");

        p.setNome(
                Input.lerTexto("Nome")
        );

p.setPreco(
        Input.lerDouble(
                "  > Preço: R$ "
        )
);

        System.out.print("  > Categoria: ");

        p.setCategoria(
                Input.lerTexto("Categoria")
        );

        p.setIdRestaurante(
                restauranteLogado.getId()
        );

        Loading.LimparTerminal(
                "Salvando produto..."
        );

        produtoService.cadastrar(p);

        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│        PRODUTO CRIADO!           │");
        System.out.println("├──────────────────────────────────┤");

        System.out.printf (
                "│  Nome: %-26s│%n",
                p.getNome()
        );

        System.out.printf (
                "│  Preço: R$ %-20.2f│%n",
                p.getPreco()
        );

        System.out.printf (
                "│  Categoria: %-21s│%n",
                p.getCategoria()
        );

        System.out.println("└──────────────────────────────────┘");

        System.out.println("\n  [ENTER] Continuar...");
        Input.scanner.nextLine();
    }

    public void listarProdutos(Restaurante restauranteLogado) {

        Loading.LimparTerminal(
                "Carregando produtos..."
        );

        List<Produto> produtos =
                produtoService
                        .listarPorRestaurante(
                                restauranteLogado.getId()
                        );

        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│             CARDÁPIO             │");

        System.out.printf (
                "│  Restaurante: %-17s│%n",
                restauranteLogado.getNome()
        );

        System.out.println("├──────────────────────────────────┤");

        if (produtos.isEmpty()) {

            System.out.println(
                    "│  Nenhum produto cadastrado.      │"
            );

        } else {

            for (Produto p : produtos) {

                System.out.printf (
                        "│  ID: %-28s│%n",
                        "#" + p.getId()
                );

                System.out.printf (
                        "│  Nome: %-26s│%n",
                        p.getNome()
                );

                System.out.printf (
                        "│  Categoria: %-21s│%n",
                        p.getCategoria()
                );

                System.out.printf (
                        "│  Preço: R$ %-20.2f│%n",
                        p.getPreco()
                );

                System.out.println(
                        "├──────────────────────────────────┤"
                );
            }
        }

        System.out.println("└──────────────────────────────────┘");

        System.out.println("\n  [ENTER] Voltar...");
        Input.scanner.nextLine();
    }

    public void deletarProduto(Restaurante restauranteLogado) {

        Loading.LimparTerminal(
                "Carregando produtos..."
        );

        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│          DELETAR PRODUTO         │");

        System.out.printf (
                "│  Restaurante: %-17s│%n",
                restauranteLogado.getNome()
        );

        System.out.println("├──────────────────────────────────┤");
        System.out.println("│  Digite 0 para cancelar          │");
        System.out.println("└──────────────────────────────────┘");

        System.out.print("\n  > ID do produto: ");

        int idProduto =
                Input.lerOpcao();

        if (idProduto == 0) {

            System.out.println(
                    "\n  > Operação cancelada."
            );

            Loading.esperar(1200);

            return;
        }

        produtoService.deletarProduto(
                idProduto,
                restauranteLogado.getId()
        );

        Loading.LimparTerminal(
                "Removendo produto..."
        );

        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│       PRODUTO REMOVIDO!          │");

        System.out.printf (
                "│  Produto #%04d deletado.         │%n",
                idProduto
        );

        System.out.println("└──────────────────────────────────┘");

        System.out.println("\n  [ENTER] Continuar...");
        Input.scanner.nextLine();
    }
}