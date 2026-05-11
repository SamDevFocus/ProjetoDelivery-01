package org.example.dao;

import org.example.connection.Conexao;
import org.example.models.Restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {

    public List<Restaurante> listar(){

        List<Restaurante> restaurantes =
                new ArrayList<>();

        String sql =
                "SELECT * FROM Restaurante";

        try {

            Connection conn =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()){

                Restaurante restaurante =
                        new Restaurante();

                restaurante.setId(
                        rs.getInt("id")
                );

                restaurante.setNome(
                        rs.getString("nome")
                );

                restaurante.setEndereco(
                        rs.getString("endereco")
                );

                restaurante.setCnpj(
                        rs.getString("cnpj")
                );

                restaurante.setTelefone(
                        rs.getString("telefone")
                );

                restaurante.setCategoria(
                        rs.getString("categoria")
                );

                restaurante.setEmail(
                        rs.getString("email")
                );

                restaurante.setSenha(
                        rs.getString("senha")
                );

                restaurantes.add(restaurante);
            }

            conn.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return restaurantes;
    }

    public Restaurante login(
            String email,
            String senha
    ){

        String sql =
                "SELECT * FROM Restaurante " +
                        "WHERE Email = ? AND Senha = ?";

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

                Restaurante restaurante =
                        new Restaurante();

                restaurante.setId(
                        rs.getInt("id")
                );

                restaurante.setNome(
                        rs.getString("nome")
                );

                restaurante.setEndereco(
                        rs.getString("endereco")
                );

                restaurante.setCnpj(
                        rs.getString("cnpj")
                );

                restaurante.setTelefone(
                        rs.getString("telefone")
                );

                restaurante.setCategoria(
                        rs.getString("categoria")
                );

                restaurante.setEmail(
                        rs.getString("email")
                );

                restaurante.setSenha(
                        rs.getString("senha")
                );

                conn.close();

                return restaurante;
            }

            conn.close();

        } catch (Exception e){

            e.printStackTrace();
        }

        return null;
    }


    public void cadastrar(Restaurante restaurante){

        String sql =
                "INSERT INTO Restaurante " +
                        "(nome, endereco, cnpj, telefone, categoria, email, senha) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, restaurante.getNome());
            stmt.setString(2, restaurante.getEndereco());
            stmt.setString(3, restaurante.getCnpj());
            stmt.setString(4, restaurante.getTelefone());
            stmt.setString(5, restaurante.getCategoria());
            stmt.setString(6, restaurante.getEmail());
            stmt.setString(7, restaurante.getSenha());

            stmt.executeUpdate();

            conn.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}