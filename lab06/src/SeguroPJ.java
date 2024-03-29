import java.util.Date;
import java.util.ArrayList;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(Date dataInicio, Date dataFinal, Seguradora seguradora, ArrayList<Condutor> listaCondutores,
            Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFinal, seguradora, listaCondutores);
        this.frota = frota;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());

    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularValor() {
        double valorBase = CalculoSeguro.VALOR_BASE.getFator();
        double qtdFuncionarios = listaCondutores.size();
        double qtdVeiculos = cliente.qtdTotalVeiculos();
        double qtdSinistrosCliente = listaSinistros.size();
        double qtdSinistrosCondutores = qtdSinistrosCondutores();
        double anosPosFundacao = cliente.getIdade();
        double valorSeguro = (valorBase * (10 + qtdFuncionarios / 10) * (1 + 1 / (qtdVeiculos + 2))
                * (1 + 1 / (anosPosFundacao + 2)) * (2 + qtdSinistrosCliente / 10) * (2 + qtdSinistrosCondutores / 10));
        super.setValorMensal(valorSeguro);

        return valorSeguro;
    }

    @Override
    public String toCsv() {
        return super.toCsv() + cliente.getCadastroPessoal() + ";F: " + frota.getCode() + ";" + valorMensal;
    }

    @Override
    public String toString() {
        return "\nNome: " + cliente.getNome() + "\nFrota: " + frota.getCode() + super.toString();
    }
}
