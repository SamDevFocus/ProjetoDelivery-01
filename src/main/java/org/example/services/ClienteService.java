package org.example.services;

import org.example.dao.ClienteDAO;
import org.example.models.Cliente;

public class ClienteService {

    private ClienteDAO dao =
            new ClienteDAO();

    public Cliente login(String email, String senha){

        return dao.login(email, senha);

    }

    public void cadastrar(Cliente cliente){

        dao.salvar(cliente);

    }
}