import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Cliente {

    String nome;
    Date dataLicenca;
    String educacao;
    String genero;
    String classeEconomica;
    String endereco;
    LinkedList<Veiculo> veiculos;

    public Cliente(String nome, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco) {
        this.nome = nome;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.endereco = endereco;
        this.veiculos = new LinkedList<Veiculo>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
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

    public LinkedList<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public String getCadastroPessoal() {
        // Método genérico para ser sobreescrito pelas classes herdeiras, equivale a
        // pedir o CPF ou CNPJ, dependendo do tipo de cliente
        return "";
    }

    @Override
    public String toString() {
        return "Cliente\nclasseEconomica: " + classeEconomica + "\ndataLicenca: " + dataLicenca
                + "\neducacao: " + educacao + "\nendereco: " + endereco
                + "\ngenero: " + genero + "\nnome: " + nome + "\nnumero de veiculos: " + veiculos.size();
    }
}
