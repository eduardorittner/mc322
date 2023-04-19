/*
 * Arquivo de teste de todas as classes e métodos do lab03
 */

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
        public static void main(String[] args) {

                try {
                        Scanner scanner = new Scanner(System.in);

                        // Data usada para todos os parâmetros do tipo "Date"
                        Date data = new Date();

                        // Instanciação da seguradora
                        Seguradora seguradora = new Seguradora("seguradora", "telefone", "email", "endereco");

                        // Instanciação de um cliente de cada tipo
                        ClientePF clientePF = new ClientePF("nome", "458.789.318-85", data, "educacao", "genero",
                                        "classeEconomica", "endereco", data);

                        ClientePJ clientePJ = new ClientePJ("outro nome", "endereco", data, "11.444.777/0001-61");

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

                        System.out.println("-------------------");
                        System.out.println(seguradora);
                        System.out.println("-------------------");
                        System.out.println(clientePF);
                        System.out.println("CPF é valido? " + clientePF.validarCPF(clientePF.getCadastroPessoal()));
                        System.out.println("-------------------");
                        System.out.println(clientePJ);
                        System.out.println("CNPJ é valido? " + clientePJ.validarCNPJ(clientePJ.getCadastroPessoal()));
                        System.out.println("-------------------");
                        System.out.println(veiculo1);
                        System.out.println("-------------------");
                        seguradora.visualizarSinistro("outro nome");
                        System.out.println("-------------------");
                        System.out.println("Menu da seguradora");
                        menuSeguradora(seguradora);
                        System.out.println("---------------");

                } catch (

                Exception e) {
                        System.out.println(e);
                }
        }

        public static void menuSeguradora(Seguradora seguradora) {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                        System.out.println("O que você gostaria de fazer?");
                        System.out.println("1: Visão geral da seguradora");
                        System.out.println("2: Visão geral dos clientes");
                        System.out.println("3: Visão geral dos sinistros");
                        System.out.println("4: Visualizar um cliente específico");
                        System.out.println("5: Visualizar um sinistro específico");
                        System.out.println("6: Adicionar um cliente");
                        System.out.println("7: Remover um cliente");
                        System.out.println("8: Sair");

                        String escolha = scanner.next();
                        switch (escolha) {
                                case "1":
                                        System.out.println(seguradora);
                                        break;
                                case "2":
                                        System.out.println("Que tipo de cliente? PF/PJ");
                                        String tipoCliente = scanner.next();
                                        switch (tipoCliente) {
                                                case "PF":
                                                        System.out.println(seguradora.listarClientes("ClientePF"));
                                                        break;
                                                case "PJ":
                                                        System.out.println(seguradora.listarClientes("ClientePJ"));
                                                        break;
                                                default:
                                                        System.out.println("Tipo de cliente inválido");
                                        }
                                        break;
                                case "3":
                                        System.out.println(seguradora.listarSinistros());
                                        break;
                                case "4":
                                        System.out.println("Que cliente você gostaria de visualizar?");
                                        String cliente = scanner.next();
                                        if (!seguradora.visualizarCliente(cliente)) {
                                                System.out.println("Não existe um cliente com este nome");
                                        }
                                        break;
                                case "5":
                                        System.out.println("Que sinistro você gostaria de visualizar?");
                                        String sinistro = scanner.next();
                                        if (!seguradora.visualizarSinistro(sinistro)) {
                                                System.out.println("Não existe um sinistro com este nome");
                                        }
                                        break;
                                case "6":
                                        System.out.println("Que tipo de cliente você gostaria de cadastrar?");
                                        tipoCliente = scanner.next();
                                        Cliente novoCliente;
                                        switch (tipoCliente) {
                                                case "PF":
                                                        novoCliente = ClientePF.criarCliente();
                                                        seguradora.cadastrarCliente(novoCliente);
                                                        break;
                                                case "PJ":
                                                        novoCliente = ClientePJ.criarCliente();
                                                        seguradora.cadastrarCliente(novoCliente);
                                                        break;
                                                default:
                                                        System.out.println("Tipo de cliente inválido");
                                        }
                                        break;
                                case "7":
                                        System.out.println("Que cliente você gostaria de remover?");
                                        String clienteRemovido = scanner.next();
                                        seguradora.removerCliente(clienteRemovido);
                                        break;
                                case "8":
                                        System.out.println("Progama finalizado");
                                        return;
                                default:
                                        System.out.println("Opção inválida");

                        }
                        System.out.println("Mais uma operação? y/n");
                        String resposta = scanner.next();
                        if (resposta.equals("n")) {
                                return;
                        }
                }
        }
}
