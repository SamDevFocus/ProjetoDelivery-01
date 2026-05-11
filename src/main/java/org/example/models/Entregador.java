package org.example.models;

public class Entregador extends Usuario {
    private String veiculo;
    private boolean disponivel = false;

    public Entregador(int id, String nome, String telefone, Endereco endereco, String cpf, String email, String senha, String veiculo) {
        super(id, nome, telefone, endereco, cpf, email, senha);
        this.veiculo = veiculo;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
