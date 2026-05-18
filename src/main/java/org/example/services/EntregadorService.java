package org.example.services;

import org.example.dao.EntregadorDAO;
import org.example.dao.PedidoDAO;
import org.example.models.Entregador;
import org.example.models.Pedido;

import java.util.List;

public class EntregadorService {

    private EntregadorDAO entregadorDAO = new EntregadorDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();

    // =========================================================
    // LOGIN
    // =========================================================
    public Entregador login(String email, String senha) {
        return entregadorDAO.login(email, senha);
    }

    // =========================================================
    // CADASTRAR — valida limites do banco antes de salvar
    // =========================================================
    public String cadastrar(Entregador e) {

        // Nome VARCHAR(100)
        if (e.getNome() == null || e.getNome().trim().isEmpty()) {
            return "Nome não pode ser vazio!";
        }
        if (e.getNome().length() > 100) {
            return "Nome pode ter no máximo 100 caracteres!";
        }

        // CPF VARCHAR(11) — exatamente 11 dígitos numéricos
        if (e.getCpf() == null || e.getCpf().trim().isEmpty()) {
            return "CPF não pode ser vazio!";
        }
        if (e.getCpf().length() != 11) {
            return "CPF deve ter exatamente 11 dígitos! (sem pontos ou traços)";
        }
        if (!e.getCpf().matches("\\d+")) {
            return "CPF deve conter apenas números!";
        }

        // Telefone VARCHAR(15)
        if (e.getTelefone() == null || e.getTelefone().trim().isEmpty()) {
            return "Telefone não pode ser vazio!";
        }
        if (e.getTelefone().length() > 15) {
            return "Telefone pode ter no máximo 15 caracteres!";
        }

        // Veiculo VARCHAR(30) — opcional no banco
        if (e.getVeiculo() != null && e.getVeiculo().length() > 30) {
            return "Veículo pode ter no máximo 30 caracteres!";
        }

        // Email VARCHAR(100)
        if (e.getEmail() == null || e.getEmail().trim().isEmpty()) {
            return "Email não pode ser vazio!";
        }
        if (e.getEmail().length() > 100) {
            return "Email pode ter no máximo 100 caracteres!";
        }
        if (!e.getEmail().contains("@")) {
            return "Email inválido! Deve conter @";
        }

        // Senha VARCHAR(100)
        if (e.getSenha() == null || e.getSenha().trim().isEmpty()) {
            return "Senha não pode ser vazia!";
        }
        if (e.getSenha().length() < 6) {
            return "Senha deve ter no mínimo 6 caracteres!";
        }
        if (e.getSenha().length() > 100) {
            return "Senha pode ter no máximo 100 caracteres!";
        }

        // tudo ok — salva no banco
        entregadorDAO.cadastrar(e);
        return null; // null = sem erro
    }

    // =========================================================
    // PEDIDOS
    // =========================================================
    public List<Pedido> listarPedidosDisponiveis() {
        return pedidoDAO.listarDisponiveis();
    }

    public void aceitarPedido(int idPedido, int idEntregador) {
        pedidoDAO.vincularEntregador(idPedido, idEntregador);
    }

    public void finalizarEntrega(int idPedido) {
        pedidoDAO.atualizarStatus(idPedido, "ENTREGUE");
    }

    public List<Pedido> meusPedidos(int idEntregador) {
        return pedidoDAO.listarPorEntregador(idEntregador);
    }

    // =========================================================
    // BUSCAR ENDERECO
    // =========================================================
    public String buscarEnderecoEntrega(int idRestaurante) {
        return pedidoDAO.buscarEnderecoRestaurante(idRestaurante);
    }
}