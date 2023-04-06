import java.util.Date;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                // Veiculo veiculo = new Veiculo("placa", "marca", "modelo");
                ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
                Date data = new Date();
                Cliente cliente = new Cliente("nome", data, "educao", "gener", "calse", "endereco");
                // lista.add(veiculo);
                String teste = "Cliente";
                System.out.println(cliente.getClass().getCanonicalName().equals(teste));

                // Cliente cliente = new Cliente("nome", data, "educacao", "genero",
                // "classeEconomica", "endereco", lista);
                // System.out.println(clientePJ);
        }
}
