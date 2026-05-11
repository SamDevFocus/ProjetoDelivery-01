package org.example.services;

import org.example.dao.PedidoDAO;
import org.example.models.Pedido;
import org.example.utils.StatusPedido;

import java.util.List;

public class PedidoService {

    private PedidoDAO pedidoDAO = new PedidoDAO();

    public List<Pedido> listarPorRestaurante(int idRestaurante){
        return pedidoDAO.listarPorRestaurante(idRestaurante);
    }

    public List<Pedido> listarPorCliente(int idCliente){
        return pedidoDAO.listarPorCliente(idCliente);
    }

    public int salvarPedido(Pedido pedido){
        return pedidoDAO.salvarPedido(pedido);
    }

    public void atualizarStatus(int id, StatusPedido status) {
        pedidoDAO.atualizarStatus(id, status.name());
    }
}