package org.example.services;

import org.example.dao.ItemPedidoDAO;
import org.example.models.ItemPedido;

public class ItemPedidoService {

    private ItemPedidoDAO dao =
            new ItemPedidoDAO();

    public void salvarItem(
            ItemPedido item
    ){

        dao.salvarItem(item);
    }
}