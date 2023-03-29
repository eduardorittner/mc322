import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {

    private final String cnpj;
    private Date dataFundacao;

    public ClientePJ(String nome, String cpf, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco, ArrayList<Veiculo> veiculos, Date dataFundacao, String cnpj) {

        super(nome, dataLicenca, educacao, genero, classeEconomica, endereco, veiculos);

        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    private String digitosVerificadoresCNPJ(String cnpj) {
        int total = 0;
        int resto = 0;
        int atual;
        int primeiro_digito_verificador;
        int[] multiplicadores = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        for (int i = 0; i < 12; i++) {
            atual = Character.getNumericValue(cnpj.charAt(i));
            total += atual * multiplicadores[i];
        }

        resto = total % 11;
        if (resto < 2) {
            primeiro_digito_verificador = 0;
        } else {
            primeiro_digito_verificador = 11 - resto;
        }

    }

    public boolean validarCNPJ(String cnpj) {
        String aux_cnpj = cnpj.replaceAll("[^\\d]", "");

        if (aux_cnpj.length() != 14) {
            return false;
        }
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
