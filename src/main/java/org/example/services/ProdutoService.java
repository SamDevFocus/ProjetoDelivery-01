package org.example.services;

import org.example.dao.ProdutoDAO;
import org.example.models.Produto;

import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public List<Produto> listarPorRestaurante(int idRestaurante){
        return produtoDAO.listarPorRestaurante(idRestaurante);
    }

    public void cadastrar(Produto produto){
        produtoDAO.cadastrar(produto);
    }

    public void deletarProduto(int idProduto, int idRestaurante) {
        produtoDAO.deletarPorId(idProduto, idRestaurante);
    }
}