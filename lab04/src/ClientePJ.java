import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {

    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    public ClientePJ(String nome, String endereco, Date dataFundacao, String cnpj, int qtdeFuncionarios)
            throws Exception {

        super(nome, endereco);
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;

        if (Validacao.validarCNPJ(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("O cnpj inserido não é válido.");
        }
    }

    @Override
    public double calculaScore() {
        return CalculoSeguro.VALOR_BASE.getFator() * (1 + (qtdeFuncionarios) / 100) * listarVeiculos().size();
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
        return "Nome: " + getNome() + "\nCNPJ: " + cnpj + "\nValor do seguro: " + getValorSeguro()
                + "\nQuantidade de funcionários: " + qtdeFuncionarios;
    }

}
