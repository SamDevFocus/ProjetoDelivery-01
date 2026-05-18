package org.example.services;

import java.util.List;
import org.example.models.Restaurante;
import org.example.dao.RestauranteDAO;

public class RestauranteService {

    private RestauranteDAO restauranteDAO = new RestauranteDAO();

    // =========================================================
    // LISTAR
    // =========================================================
    public List<Restaurante> listar() {
        return restauranteDAO.listar();
    }

    // =========================================================
    // LOGIN
    // =========================================================
    public Restaurante login(String email, String senha) {
        return restauranteDAO.login(email, senha);
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

    public String validarEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty())
            return "Endereço não pode ser vazio!";
        if (endereco.length() > 200)
            return "Endereço pode ter no máximo 200 caracteres!";
        return null;
    }

    public String validarCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty())
            return "CNPJ não pode ser vazio!";
        if (cnpj.length() != 14)
            return "CNPJ deve ter exatamente 14 dígitos! (sem pontos, barras ou traços)";
        if (!cnpj.matches("\\d+"))
            return "CNPJ deve conter apenas números!";
        return null;
    }

    public String validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty())
            return "Telefone não pode ser vazio!";
        if (telefone.length() > 15)
            return "Telefone pode ter no máximo 15 caracteres!";
        return null;
    }

    public String validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty())
            return "Categoria não pode ser vazia!";
        if (categoria.length() > 55)
            return "Categoria pode ter no máximo 55 caracteres!";
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

    // =========================================================
    // CADASTRAR — usa as validacoes acima
    // =========================================================
    public String cadastrar(Restaurante restaurante) {
        String erro;

        erro = validarNome(restaurante.getNome());
        if (erro != null) return erro;

        erro = validarEndereco(restaurante.getEndereco());
        if (erro != null) return erro;

        erro = validarCnpj(restaurante.getCnpj());
        if (erro != null) return erro;

        erro = validarTelefone(restaurante.getTelefone());
        if (erro != null) return erro;

        erro = validarCategoria(restaurante.getCategoria());
        if (erro != null) return erro;

        erro = validarEmail(restaurante.getEmail());
        if (erro != null) return erro;

        erro = validarSenha(restaurante.getSenha());
        if (erro != null) return erro;

        restauranteDAO.cadastrar(restaurante);
        return null;
    }
}