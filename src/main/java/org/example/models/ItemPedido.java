package org.example.models;

public class ItemPedido {

    private int id;
    private int quantidade;
    private double precoUnit;
    private int idPedido;
    private int idProduto;

    public ItemPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(
            int quantidade
    ) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(
            double precoUnit
    ) {
        this.precoUnit = precoUnit;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(
            int idPedido
    ) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(
            int idProduto
    ) {
        this.idProduto = idProduto;
    }
}