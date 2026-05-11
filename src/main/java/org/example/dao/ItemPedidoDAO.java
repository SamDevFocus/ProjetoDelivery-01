package org.example.dao;

import org.example.connection.Conexao;
import org.example.models.ItemPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ItemPedidoDAO {

    public void salvarItem(
            ItemPedido item
    ){

        String sql =
                "INSERT INTO ItemPedido " +
                        "(quantidade, precounit, id_pedido, id_produto) " +
                        "VALUES (?, ?, ?, ?)";

        try {

            Connection conn =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(
                    1,
                    item.getQuantidade()
            );

            stmt.setDouble(
                    2,
                    item.getPrecoUnit()
            );

            stmt.setInt(
                    3,
                    item.getIdPedido()
            );

            stmt.setInt(
                    4,
                    item.getIdProduto()
            );

            stmt.execute();

            conn.close();

        } catch (Exception e){

            e.printStackTrace();

        }
    }
}