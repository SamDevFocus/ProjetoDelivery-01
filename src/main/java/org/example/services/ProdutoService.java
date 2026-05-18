package org.example.services;

import org.example.dao.ProdutoDAO;
import org.example.models.Produto;

import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    // =========================================================
    // LISTAR
    // =========================================================
    public List<Produto> listarPorRestaurante(int idRestaurante) {
        return produtoDAO.listarPorRestaurante(idRestaurante);
    }

    // =========================================================
    // CADASTRAR — valida limites do banco antes de salvar
    // =========================================================
    public String cadastrar(Produto produto) {

        // Nome VARCHAR(100)
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            return "Nome não pode ser vazio!";
        }
        if (produto.getNome().length() > 100) {
            return "Nome pode ter no máximo 100 caracteres!";
        }

        // Descricao VARCHAR(200) — opcional no banco mas validamos o tamanho
        if (produto.getDescricao() != null && produto.getDescricao().length() > 200) {
            return "Descrição pode ter no máximo 200 caracteres!";
        }

        // Preco NUMERIC(10,2) — não pode ser zero ou negativo
        if (produto.getPreco() <= 0) {
            return "Preço deve ser maior que zero!";
        }
        if (produto.getPreco() > 99999999.99) {
            return "Preço inválido!";
        }

        // Categoria VARCHAR(50)
        if (produto.getCategoria() == null || produto.getCategoria().trim().isEmpty()) {
            return "Categoria não pode ser vazia!";
        }
        if (produto.getCategoria().length() > 50) {
            return "Categoria pode ter no máximo 50 caracteres!";
        }

        // tudo ok — salva no banco
        produtoDAO.cadastrar(produto);
        return null; // null = sem erro
    }

    // =========================================================
    // DELETAR
    // =========================================================
    public void deletarProduto(int idProduto, int idRestaurante) {
        produtoDAO.deletarPorId(idProduto, idRestaurante);
    }
}