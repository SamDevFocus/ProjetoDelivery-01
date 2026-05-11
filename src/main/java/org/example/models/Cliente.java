package org.example.models;

public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(
            int id,
            String nome,
            String telefone,
            Endereco endereco,
            String cpf,
            String email,
            String senha
    ) {

        super(
                id,
                nome,
                telefone,
                endereco,
                cpf,
                email,
                senha
        );
    }
}