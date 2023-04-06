import java.util.Date;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                // Veiculo veiculo = new Veiculo("placa", "marca", "modelo");
                ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
                // lista.add(veiculo);
                Date data = new Date();

                // Cliente cliente = new Cliente("nome", data, "educacao", "genero",
                // "classeEconomica", "endereco", lista);
                try {
                        ClientePJ clientePJ = new ClientePJ("nome", data, "educacao", "genero",
                                        "classeEconomica", "endereco", lista, data, "18577114000189");
                } catch (Exception exception) {
                        System.out.println(exception);
                }
                // System.out.println(clientePJ);
        }
}
