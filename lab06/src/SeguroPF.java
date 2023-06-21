import java.util.Date;
import java.util.ArrayList;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(Date dataInicio, Date dataFinal, Seguradora seguradora, ArrayList<Condutor> listaCondutores,
            Veiculo veiculo, ClientePF cliente) throws Exception {
        super(dataInicio, dataFinal, seguradora, listaCondutores);
        this.veiculo = veiculo;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());

        if (valorMensal <= 0) {
            throw new Exception("Valor mensal tem que ser maior que 0.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularValor() {
        double fatorIdade = cliente.getFatorIdade();
        double qtdCarros = cliente.getListaVeiculos().size();
        double qtdSinistrosCliente = listaSinistros.size();
        double qtdSinistrosCondutores = qtdSinistrosCondutores();
        double valorBase = CalculoSeguro.VALOR_BASE.getFator();
        double valorSeguro = (valorBase * fatorIdade * (1 + 1 / (qtdCarros + 2)) * (2 + qtdSinistrosCliente / 10)
                * (5 + qtdSinistrosCondutores / 10));
        super.setValorMensal(valorSeguro);
        return valorSeguro;
    }

    @Override
    public String toCsv() {
        return super.toCsv() + cliente.getCadastroPessoal() + ";V: " + veiculo.getPlaca() + ";" + valorMensal;
    }

    @Override
    public String toString() {
        return "\nCliente: " + cliente.getNome() + "\nVeiculo: " + veiculo.getPlaca() + super.toString();
    }

}
