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

        if (dataInicio.after(dataFinal)) {
            throw new Exception("Data final deve ser depois da data inicial.");
        }
        if (!Validacao.validarData(dataFinal)) {
            throw new Exception("Data final do seguro não pode estar no passado.");
        }
        if (valorMensal <= 0) {
            throw new Exception("Valor mensal tem que ser maior que 0.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularValor() {
        double fatorIdade = cliente.getFatorIdade();
        double qtdCarros = cliente.listarVeiculos().size();
        double qtdSinistrosCliente = listaSinistros.size();
        double qtdSinistrosCondutores = qtdSinistrosCondutores();
        double valorBase = CalculoSeguro.VALOR_BASE.getFator();
        double valorSeguro = (valorBase * fatorIdade * (1 + 1 / (qtdCarros + 2)) * (2 + qtdSinistrosCliente / 10)
                * (5 + qtdSinistrosCondutores / 10));
        super.setValorMensal(valorSeguro);
        return valorSeguro;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + "\nVeiculo: " + veiculo.getPlaca() + super.toString();
    }

}
