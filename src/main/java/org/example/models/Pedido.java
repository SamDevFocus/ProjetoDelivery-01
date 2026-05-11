package org.example.models;

public class Pedido {

    private int id;
    private String status;
    private int idCliente;
    private int idRestaurante;
    private int idEntregador;

    public Pedido() {
    }

    public Pedido(
            int id,
            String status,
            int idCliente,
            int idRestaurante,
            int idEntregador
    ) {

        this.id = id;
        this.status = status;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.idEntregador = idEntregador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(
            int idCliente
    ) {
        this.idCliente = idCliente;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(
            int idRestaurante
    ) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(
            int idEntregador
    ) {
        this.idEntregador = idEntregador;
    }
}