import java.util.Date;
import java.util.ArrayList;

public class Cliente {

    String nome;
    Date dataLicenca;
    String educacao;
    String genero;
    String classeEconomica;
    String endereco;
    ArrayList<Veiculo> veiculos;

    public Cliente(String nome, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco) {
        System.out.println("Construtora do cliente pai");
        this.nome = nome;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.endereco = endereco;
        this.veiculos = new ArrayList<Veiculo>();
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

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    @Override
    public String toString() {
        return "Cliente [classeEconomica=" + classeEconomica + ", dataLicenca=" + dataLicenca
                + ", educacao=" + educacao + ", endereco=" + endereco
                + ", genero=" + genero + ", nome=" + nome + ", veiculos=" + veiculos + "]";
    }
}
