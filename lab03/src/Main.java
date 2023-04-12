import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
        public static void main(String[] args) {

                try {
                        // Data usada para todos os parâmetros do tipo "Date"
                        Date data = new Date();

                        // Instanciação da seguradora
                        Seguradora seguradora = new Seguradora("seguradora", "telefone", "email", "endereco");

                        // Instanciação de um cliente de cada tipo
                        ClientePF clientePF = new ClientePF("nome", "458.789.318-85", data, "educacao", "genero",
                                        "classeEconomica", "endereco", data);

                        ClientePJ clientePJ = new ClientePJ("outro nome", data, "educacao", "genero", "classeEconomica",
                                        "endereco", data, "11.444.777/0001-61.");

                        // Instanciação dos veículos
                        Veiculo veiculo1 = new Veiculo("placa", "marca", "modelo", 2000);
                        Veiculo veiculo2 = new Veiculo("placa", "marca", "modelo", 2001);
                        Veiculo veiculo3 = new Veiculo("placa", "marca", "modelo", 2002);
                        Veiculo veiculo4 = new Veiculo("placa", "marca", "modelo", 2003);

                        // Adicionando os veículos para cada cliente
                        clientePF.cadastrarVeiculo(veiculo1);
                        clientePJ.cadastrarVeiculo(veiculo2);

                        // Cadastrando os clientes na seguradora
                        seguradora.cadastrarCliente(clientePF);
                        seguradora.cadastrarCliente(clientePJ);

                        // Gerando um sinistro
                        seguradora.gerarSinistro(data, "endereco", seguradora, veiculo2, clientePJ);

                        // Removendo um cliente
                        seguradora.removerCliente("outro nome");

                        System.out.println(seguradora);
                        System.out.println(clientePF);
                        System.out.println(clientePJ);
                        System.out.println(veiculo1);
                        System.out.println(seguradora.visualizarSinistro("clientePF"));

                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}
