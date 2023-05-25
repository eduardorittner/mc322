import java.util.Date;
import java.util.ArrayList;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(Date dataInicio, Date dataFinal, Seguradora seguradora, ArrayList<Condutor> listaCondutores,
            int valorMensal, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFinal, seguradora, listaCondutores, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public double calcularValor() {
        double valorBase = CalculoSeguro.VALOR_BASE.getFator();
        // TODO numero de funcionarios
        int qtdFuncionarios = listaCondutores.size();
        int qtdVeiculos = cliente.qtdTotalVeiculos();
        int qtdSinistrosCliente = listaSinistros.size();
        int qtdSinistrosCondutores = qtdSinistrosCondutores();
        int anosPosFundacao = cliente.getIdade();

        double valor = (valorBase * (10 + qtdFuncionarios / 10) * (1 + 1 / (qtdVeiculos + 2))
                * (1 + 1 / (anosPosFundacao + 2)) * (2 + qtdSinistrosCliente / 10) * (2 + qtdSinistrosCondutores / 10));
        return valor;
    }

}
