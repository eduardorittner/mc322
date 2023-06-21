import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class ClientePF extends Cliente {

    private final String cpf;
    private String genero;
    private String educacao;
    private Date dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;

    public ClientePF(String nome, String endereco, String telefone, String email, String cpf, String genero,
            String educacao, Date dataNascimento) throws Exception {

        super(nome, endereco, telefone, email);

        this.educacao = educacao;
        this.genero = genero;
        this.listaVeiculos = new ArrayList<>();
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;

        if (!Validacao.validarData(dataNascimento)) {
            throw new Exception("Data inserida é inválida");
        }
        if (!Validacao.validarIdade(dataNascimento)) {
            throw new Exception("Cliente tem menos que 18 anos");
        }
        if (!Validacao.validarCPF(cpf)) {
            throw new Exception("Cpf inserido é inválido");
        }
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        try {
            listaVeiculos.add(veiculo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerVeiculo(String placa) {
        Veiculo veiculo = getVeiculo(placa);
        if (veiculo != null) {
            listaVeiculos.remove(placa);
            Veiculo.removePlaca(placa);
            return true;
        }
        return false;
    }

    public Veiculo getVeiculo(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void concatenaListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        listaVeiculos.addAll(listaVeiculos);
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void limparVeiculos() {
        listaVeiculos.clear();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getFatorIdade() {
        int idade = getIdade();
        if (idade < 30) {
            return CalculoSeguro.FATOR_18_30.getFator();
        } else if (idade < 60) {
            return CalculoSeguro.FATOR_30_60.getFator();
        } else {
            return CalculoSeguro.FATOR_60_90.getFator();
        }
    }

    public int getIdade() {
        Date dataAtual = new Date();

        long diferencaEmMiliS = dataAtual.getTime() - dataNascimento.getTime();
        long diferenca = TimeUnit.DAYS.convert(diferencaEmMiliS, TimeUnit.MILLISECONDS);
        return (int) diferenca / 365;
    }

    @Override
    public String getCadastroPessoal() {
        return cpf.replaceAll("[^\\d]", "");
    }

    @Override
    public String toString() {
        return "\nNome: " + getNome() + "\nCPF: " + cpf + "\nNúmero de veículos: " + listaVeiculos.size() + "\nGênero: "
                + genero + "\nData de nascimento: " + dataNascimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientePF other = (ClientePF) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
}
