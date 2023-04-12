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

    public static Cliente criarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando um novo Cliente");
        System.out.println("Que tipo de cliente? pf/pj");
        String tipo = scanner.next();
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Educação: ");
        String educacao = scanner.next();
        System.out.println("Gênero: ");
        String genero = scanner.next();
        System.out.println("Classe econômica: ");
        String classeEconomica = scanner.next();
        System.out.println("Endereço: ");
        String endereco = scanner.next();
        System.out.println("Data da licença (xx/xx/xxxx): ");
        String dataLicenca = scanner.next();
        Date data = new Date();
        Cliente cliente = new Cliente(nome, data, educacao, genero, classeEconomica, endereco);
        return cliente;
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

    @Override
    public String toString() {
        return "Cliente\nclasseEconomica: " + classeEconomica + "\ndataLicenca: " + dataLicenca
                + "\neducacao: " + educacao + "\nendereco: " + endereco
                + "\ngenero: " + genero + "\nnome: " + nome + "\nnumero de veiculos: " + veiculos.size();
    }
}
