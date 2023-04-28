import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {

    private final String cnpj;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, Date dataFundacao, String cnpj) throws Exception {

        super(nome, endereco);
        this.dataFundacao = dataFundacao;

        if (validarCNPJ(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("O cnpj inserido não é válido.");
        }
    }

    private String digitosVerificadoresCNPJ(String cnpj) {
        int total = 0;
        int resto = 0;
        int atual;
        int primeiro_digito_verificador;
        int segundo_digito_verificador;
        int[] multiplicadores = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        for (int i = 0; i < 12; i++) {
            atual = Character.getNumericValue(cnpj.charAt(i));
            total += atual * multiplicadores[i + 1];
        }

        resto = total % 11;
        if (resto < 2) {
            primeiro_digito_verificador = 0;
        } else {
            primeiro_digito_verificador = 11 - resto;
        }

        total = 0;

        for (int i = 0; i < 13; i++) {
            atual = Character.getNumericValue(cnpj.charAt(i));
            total += atual * multiplicadores[i];
        }

        resto = total % 11;

        if (resto < 2) {
            segundo_digito_verificador = 0;
        } else {
            segundo_digito_verificador = 11 - resto;
        }

        String resultado = Integer.toString(primeiro_digito_verificador)
                + (Integer.toString(segundo_digito_verificador));

        return resultado;
    }

    public boolean validarCNPJ(String cnpj) {
        String aux_cnpj = cnpj.replaceAll("[^\\d]", "");

        if (aux_cnpj.length() != 14) {
            return false;
        }

        String digitosVerificadoresOriginais = aux_cnpj.substring(12);
        String digitosVerificadoresCorretos = digitosVerificadoresCNPJ(aux_cnpj);
        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresOriginais.equals(digitosVerificadoresCorretos));
        if (digitosVerificadoresDiferentes) {
            return false;
        }

        return true;
    }

    @Override
    public String getCadastroPessoal() {
        return cnpj.replaceAll("[^\\d]", "");
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncnpj: " + cnpj + "\ndataFundacao: " + dataFundacao;
    }

}
