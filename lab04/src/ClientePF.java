import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePF extends Cliente {

    private final String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Seguradora seguradora;
    private Veiculo veiculo;
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
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;

        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new Exception("Cpf inserido é inválido");
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    private boolean cpfDigitosIguais(String cpf) {
        // Retorna true se o cpf for composto de somente um dígito repetido 11 vezes

        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String digitosVerificadoresCPF(String cpf) {
        // Calcula os digitos verificadores do cpf com base nos 9 primeiros números

        int total = 0;
        int atual;
        int resto;
        int primeiro_digito_verificador;
        for (int i = 0; i < 9; i++) {
            atual = Character.getNumericValue(cpf.charAt(i));
            total += atual * (10 - i);
        }
        resto = total % 11;
        if (resto < 2) {
            primeiro_digito_verificador = 0;
        } else {
            primeiro_digito_verificador = 11 - resto;
        }

        total = 0;

        for (int i = 0; i < 9; i++) {
            atual = Character.getNumericValue(cpf.charAt(i));
            total += atual * (11 - i);
        }
        total += primeiro_digito_verificador * 2;
        resto = total % 11;
        int segundo_digito_verificador;
        if (resto < 2) {
            segundo_digito_verificador = 0;
        } else {
            segundo_digito_verificador = 11 - resto;
        }

        String resultado = Integer.toString(primeiro_digito_verificador)
                + (Integer.toString(segundo_digito_verificador));

        return resultado;
    }

    public boolean validarCPF(String cpf) {
        String aux_cpf = cpf.replaceAll("[^\\d]", "");

        if (aux_cpf.length() != 11) {
            return false;
        }
        if (cpfDigitosIguais(aux_cpf)) {
            return false;
        }

        String digitosVerificadoresOriginais = aux_cpf.substring(9);
        String digitosVerificadoresCorretos = digitosVerificadoresCPF(aux_cpf);
        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresOriginais.equals(digitosVerificadoresCorretos));
        if (digitosVerificadoresDiferentes) {
            return false;
        }

        return true;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getCadastroPessoal() {
        return cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncpf: " + cpf + "\ndataNascimento: " + dataNascimento;
    }

}
