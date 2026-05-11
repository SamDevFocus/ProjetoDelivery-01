package org.example.dao;

import org.example.connection.Conexao;
import org.example.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {

    public Cliente login(String email, String senha){

        String sql =
                "SELECT * FROM Cliente " +
                        "WHERE Email = ? AND senha = ?";

        try {

            Connection conn =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs =
                    stmt.executeQuery();

            if(rs.next()){

                Cliente cliente =
                        new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEmail(rs.getString("Email"));

                return cliente;
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void salvar(Cliente cliente){

        String sql =
                "INSERT INTO Cliente " +
                        "(Nome, cpf, Telefone, Email, senha) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());

            stmt.execute();

            conn.close();

        } catch (Exception e){

            e.printStackTrace();

        }
    }

}