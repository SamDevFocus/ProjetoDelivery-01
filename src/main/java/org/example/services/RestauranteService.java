package org.example.services;

import java.util.List;
import org.example.models.Restaurante;
import org.example.dao.RestauranteDAO;

public class RestauranteService {

    private RestauranteDAO restauranteDAO =
            new RestauranteDAO();

    public List<Restaurante> listar() {

        return restauranteDAO.listar();
    }

    public void cadastrar(Restaurante restaurante) {

        restauranteDAO.cadastrar(restaurante);
    }

    public Restaurante login(String email, String senha) {

        return restauranteDAO.login(email, senha);
    }
}