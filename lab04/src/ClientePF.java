import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class ClientePF extends Cliente {

    private final String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Seguradora seguradora;
    private String classeEconomica;
    private Date dataNascimento;

    public ClientePF(String nome, String cpf, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco, Date dataNascimento)
            throws Exception {

        super(nome, endereco);

        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        if (Validacao.validarData(dataNascimento)) {
            this.dataNascimento = dataNascimento;
        } else {
            throw new Exception("Data inserida é inválida");
        }

        if (Validacao.validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new Exception("Cpf inserido é inválido");
        }
    }

    @Override
    public double calculaScore() {
        double fatorIdade = getFatorIdade();
        int qtdCarros = listarVeiculos().size();
        return CalculoSeguro.VALOR_BASE.getFator() * fatorIdade * qtdCarros;
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

    public String getCpf() {
        return cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        return "Nome: " + getNome() + "\nCPF: " + cpf + "\nValor do seguro: " + getValorSeguro() + "\nGênero: " + genero
                + "\nData de nascimento: " + dataNascimento;
    }

}
