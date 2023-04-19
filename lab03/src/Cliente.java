import java.util.Scanner;
import java.util.Date;
import java.util.LinkedList;
import java.util.ArrayList;

public class Cliente {

    String nome;
    String endereco;
    ArrayList<Veiculo> veiculos;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.veiculos = new ArrayList<Veiculo>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        try {
            veiculos.add(veiculo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerVeiculo(String placa) {
        for (Veiculo veiculoAtual : veiculos) {
            if (veiculoAtual.getPlaca().equals(placa)) {
                veiculos.remove(placa);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public String getCadastroPessoal() {
        // Método genérico para ser sobreescrito pelas classes herdeiras, equivale a
        // pedir o CPF ou CNPJ, dependendo do tipo de cliente
        return "";
    }

    @Override
    public String toString() {
        return "Cliente\nendereco: " + endereco
                + "\nnome: " + nome + "\nnumero de veiculos: " + veiculos.size();
    }
}
