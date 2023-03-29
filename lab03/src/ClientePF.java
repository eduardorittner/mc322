import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {

    private final String cpf;
    private Date dataNascimento;

    public ClientePF(String nome, String cpf, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco, ArrayList<Veiculo> veiculos, Date dataNascimento) {

        super(nome, dataLicenca, educacao, genero, classeEconomica, endereco, veiculos);

        this.dataNascimento = dataNascimento;

        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            this.cpf = "cpf invalido";
        }
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
        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresCPF(aux_cpf).equals(aux_cpf.substring(9)));
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

    public String getCpf(String cpf) {
        return this.cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "cpf: " + cpf + "dataNascimento: " + dataNascimento;
    }

}
