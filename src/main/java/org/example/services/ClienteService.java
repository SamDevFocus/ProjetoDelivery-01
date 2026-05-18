package org.example.services;

import org.example.dao.ClienteDAO;
import org.example.models.Cliente;

public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();

    // =========================================================
    // LOGIN
    // =========================================================
    public Cliente login(String email, String senha) {
        return dao.login(email, senha);
    }

    // =========================================================
    // VALIDACOES INDIVIDUAIS — usadas pela tela em loop
    // =========================================================
    public String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            return "Nome não pode ser vazio!";
        if (nome.length() > 100)
            return "Nome pode ter no máximo 100 caracteres!";
        return null;
    }

    public String validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty())
            return "CPF não pode ser vazio!";
        if (cpf.length() != 11)
            return "CPF deve ter exatamente 11 dígitos! (sem pontos ou traços)";
        if (!cpf.matches("\\d+"))
            return "CPF deve conter apenas números!";
        return null;
    }

    public String validarEmail(String email) {
        if (email == null || email.trim().isEmpty())
            return "Email não pode ser vazio!";
        if (email.length() > 100)
            return "Email pode ter no máximo 100 caracteres!";
        if (!email.contains("@"))
            return "Email inválido! Deve conter @";
        return null;
    }

    public String validarSenha(String senha) {
        if (senha == null || senha.trim().isEmpty())
            return "Senha não pode ser vazia!";
        if (senha.length() < 6)
            return "Senha deve ter no mínimo 6 caracteres!";
        if (senha.length() > 100)
            return "Senha pode ter no máximo 100 caracteres!";
        return null;
    }

    public String validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty())
            return "Telefone não pode ser vazio!";
        if (telefone.length() > 15)
            return "Telefone pode ter no máximo 15 caracteres!";
        return null;
    }

    // =========================================================
    // CADASTRAR — usa as validacoes acima
    // =========================================================
    public String cadastrar(Cliente cliente) {
        String erro;

        erro = validarNome(cliente.getNome());
        if (erro != null) return erro;

        erro = validarCpf(cliente.getCpf());
        if (erro != null) return erro;

        erro = validarEmail(cliente.getEmail());
        if (erro != null) return erro;

        erro = validarSenha(cliente.getSenha());
        if (erro != null) return erro;

        erro = validarTelefone(cliente.getTelefone());
        if (erro != null) return erro;

        dao.salvar(cliente);
        return null;
    }

    // =========================================================
    // BUSCAR
    // =========================================================
    public String buscarEnderecoPorCliente(int idCliente) {
        return dao.buscarEnderecoPorCliente(idCliente);
    }

    public String buscarNomePorId(int idCliente) {
        return dao.buscarNomePorId(idCliente);
    }
}