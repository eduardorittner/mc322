import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

public class ClientePJ extends Cliente {

    private final String cnpj;
    private Date dataFundacao;

    public ClientePJ(String nome, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco, Date dataFundacao, String cnpj)
            throws Exception {

        super(nome, dataLicenca, educacao, genero, classeEconomica, endereco);

        if (validarCNPJ(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("O cnpj inserido não é válido.");
        }
        this.dataFundacao = dataFundacao;
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

        System.out.println(resultado);

        return resultado;
    }

    public boolean validarCNPJ(String cnpj) {
        String aux_cnpj = cnpj.replaceAll("[^\\d]", "");

        if (aux_cnpj.length() != 14) {
            return false;
        }

        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresCNPJ(aux_cnpj).equals(aux_cnpj.substring(11)));
        if (digitosVerificadoresDiferentes) {
            return false;
        }
        System.out.println(digitosVerificadoresCNPJ(aux_cnpj));

        return true;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        return super.toString() + "cnpj=" + cnpj + ", dataFundacao=" + dataFundacao + "]";
    }

}
