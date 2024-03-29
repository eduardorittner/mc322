import java.util.Scanner;
import java.util.Date;
import java.util.LinkedList;
import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String endereco;
    private ArrayList<Veiculo> veiculos;
    private double valorSeguro;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.veiculos = new ArrayList<Veiculo>();
        this.valorSeguro = 0;
    }

    public double getValorSeguro() {
        return valorSeguro;
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
            calculaScore();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerVeiculo(String placa) {
        Veiculo veiculo = getVeiculo(placa);
        if (veiculo != null) {
            veiculos.remove(placa);
            Veiculo.removePlaca(placa);
            calculaScore();
            return true;
        }
        return false;
    }

    public Veiculo getVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void concatenaListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        veiculos.addAll(listaVeiculos);
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public void limparVeiculos() {
        veiculos.clear();
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double calculaScore() {
        // Método genérico para ser sobreescrito pelas classes herdeiras
        return 0;
    }

    public String getCadastroPessoal() {
        // Método genérico para ser sobreescrito pelas classes herdeiras, equivale a
        // pedir o CPF ou CNPJ, dependendo do tipo de cliente
        return "";
    }

}
