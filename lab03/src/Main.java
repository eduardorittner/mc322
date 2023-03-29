import java.util.Date;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                Veiculo veiculo = new Veiculo("placa", "marca", "modelo");
                ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
                lista.add(veiculo);
                Date data = new Date();
                Cliente cliente = new Cliente("nome", data, "educacao", "genero", "classeEconomica", "endereco", lista);
                ClientePF clientePF = new ClientePF("nome", "45878931885", data, "educacao", "genero",
                                "classeEconomica", "endereco", lista, data);
                System.out.println(clientePF);

        }
}
