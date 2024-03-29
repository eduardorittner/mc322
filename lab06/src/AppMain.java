import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AppMain {
        public static void main(String[] args) {
                try {
                        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
                        Seguradora seguradora = new Seguradora("Petrobras", "(19) 99999-9999", "Petrobras@gmail.com",
                                        "Rua da Petrobras, 000");
                        System.out.println("==== Nova seguradora criada ====");
                        System.out.println("===============================");
                        listaSeguradoras.add(seguradora);
                        System.out.println(seguradora);
                        System.out.println("===============================");

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date data = new Date();

                        try {
                                data = dateFormat.parse("10-10-2000");
                        } catch (Exception e) {
                                System.out.println(e);
                        }

                        ClientePF clientePF = new ClientePF("Juvenaldo", "Rua dos abacates", "19-984265556",
                                        "email@gmail.com", "458.789.318-85", "Homem", "Unicamp", data);
                        seguradora.cadastrarCliente(clientePF);
                        System.out.println("==== Novo ClientePF criado ====");
                        System.out.println("===============================");
                        System.out.println(clientePF);
                        System.out.println("===============================");

                        ClientePJ clientePJ = new ClientePJ("Milton LTDA.", "Rua dos abacates", "19-9999999",
                                        "milton@gmail.com", data, "18.781.203/0001-28");

                        seguradora.cadastrarCliente(clientePJ);
                        System.out.println("==== Novo ClientePJ criado ====");
                        System.out.println("===============================");
                        System.out.println(clientePJ);
                        System.out.println("===============================");

                        Frota frota = new Frota("frota bala");
                        clientePJ.cadastrarFrota(frota);

                        System.out.println("==== Nova frota criada ====");
                        System.out.println("===============================");
                        System.out.println(frota);
                        System.out.println("===============================");

                        Veiculo veiculoPF = new Veiculo("GUD4142", "Toyota", "Sedan", 2020);
                        clientePF.cadastrarVeiculo(veiculoPF);
                        System.out.println("==== Veículo cadastrado no ClientePF ====");
                        System.out.println("===============================");
                        System.out.println(clientePF.getVeiculo("GUD4142"));
                        System.out.println("===============================");

                        frota.addVeiculo(new Veiculo("DIK1234", "Honda", "Civic", 2020));
                        System.out.println("==== Veículo cadastrado na frota do ClientePJ ====");
                        System.out.println("===============================");
                        System.out.println(frota.getVeiculo("DIK1234"));
                        System.out.println("===============================");

                        ArrayList<Condutor> listaCondutoresPF = new ArrayList<>();
                        Condutor condutorPF = new Condutor("46775872801", "Rafael", "19999999999",
                                        "Rua dos Condutores, 123", "condutor@gmail.com", data);
                        listaCondutoresPF.add(condutorPF);

                        System.out.println("==== Novo condutor criado ====");
                        System.out.println("===============================");
                        System.out.println(condutorPF);
                        System.out.println("===============================");

                        SeguroPF seguroPF = new SeguroPF(data, data, seguradora, listaCondutoresPF, veiculoPF,
                                        clientePF);
                        seguradora.cadastrarSeguro(seguroPF);

                        System.out.println("==== Novo seguro PF criado ====");
                        System.out.println("===============================");
                        System.out.println(seguroPF);
                        System.out.println("===============================");

                        ArrayList<Condutor> listaCondutoresPJ = new ArrayList<>();
                        Condutor condutorPJ = new Condutor("15463069867", "Ronaldo", "19999999999",
                                        "Rua dos Condutores, 123", "condutor@gmail.com", data);
                        listaCondutoresPJ.add(condutorPJ);

                        System.out.println("==== Novo condutor criado ====");
                        System.out.println("===============================");
                        System.out.println(condutorPJ);
                        System.out.println("===============================");

                        SeguroPJ seguroPJ = new SeguroPJ(data, data, seguradora, listaCondutoresPJ, frota, clientePJ);
                        seguradora.cadastrarSeguro(seguroPJ);

                        System.out.println("==== Novo seguro PJ criado ====");
                        System.out.println("===============================");
                        System.out.println(seguroPJ);
                        System.out.println("===============================");

                        Sinistro sinistroPF = new Sinistro(data, "Rua do sinistro", condutorPF, seguroPF);
                        seguroPF.cadastrarSinistro(sinistroPF, condutorPF);

                        System.out.println("==== Novo sinistro cadastrado no seguro PF ====");
                        System.out.println("===============================");
                        System.out.println(sinistroPF);
                        System.out.println("===============================");

                        Sinistro sinistroPJ = new Sinistro(data, "Rua do sinistro", condutorPJ, seguroPJ);
                        seguroPJ.cadastrarSinistro(sinistroPJ, condutorPJ);

                        System.out.println("==== Novo sinistro cadastrado no seguro PJ ====");
                        System.out.println("===============================");
                        System.out.println(sinistroPJ);
                        System.out.println("===============================");

                        System.out.println("==== Listar Clientes ====");
                        System.out.println("===============================");
                        System.out.println(seguradora.getListaClientes());
                        System.out.println("===============================");

                        System.out.println("==== Visualizar sinistro do condutor PF ====");
                        System.out.println("===============================");
                        System.out.println(seguroPF.getSinistro(sinistroPF.getId()));
                        System.out.println("===============================");

                        System.out.println("==== Listar Seguros por cliente ====");
                        System.out.println("===============================");
                        seguradora.imprimeSegurosPorCliente();
                        System.out.println("===============================");

                        System.out.println("==== Calcula receita ====");
                        System.out.println("===============================");
                        System.out.println(seguradora.calculaReceita());
                        System.out.println("===============================");

                        System.out.println("==== Importando condutores ====");
                        ArquivoCondutor arquivoCondutores = new ArquivoCondutor();
                        ArrayList<Condutor> listaCondutores = (ArrayList<Condutor>) arquivoCondutores
                                        .lerArquivo("./lab06/dados/condutores.csv");
                        System.out.println(listaCondutores);
                        System.out.println("===============================");

                        System.out.println("==== Importando veiculos ====");
                        ArquivoVeiculo arquivoVeiculo = new ArquivoVeiculo();
                        ArrayList<Veiculo> listaVeiculos = (ArrayList<Veiculo>) arquivoVeiculo
                                        .lerArquivo("./lab06/dados/veiculos.csv");
                        System.out.println(listaVeiculos);
                        System.out.println("===============================");

                        System.out.println("==== Importando frotas ====");
                        ArquivoFrota arquivoFrota = new ArquivoFrota();
                        ArrayList<Frota> listaFrotas = (ArrayList<Frota>) arquivoFrota
                                        .lerArquivo("./lab06/dados/frotas.csv", listaVeiculos);
                        System.out.println(listaFrotas);
                        // Cadastra frotas no primeiro clientePJ
                        for (Frota _frota : listaFrotas) {
                                clientePJ.cadastrarFrota(_frota);
                        }
                        System.out.println("===============================");

                        System.out.println("==== Importando clientes PF ====");
                        ArquivoClientePF arquivoClientePF = new ArquivoClientePF();
                        ArrayList<ClientePF> listaClientesPF = (ArrayList<ClientePF>) arquivoClientePF
                                        .lerArquivo("./lab06/dados/clientesPF.csv", listaVeiculos);
                        System.out.println(listaClientesPF);
                        for (ClientePF _clientePF : listaClientesPF) {
                                seguradora.cadastrarCliente(_clientePF);
                        }
                        System.out.println("===============================");

                        System.out.println("==== Importando clientes PJ ====");
                        ArquivoClientePJ arquivoClientePJ = new ArquivoClientePJ();
                        ArrayList<ClientePJ> listaClientesPJ = (ArrayList<ClientePJ>) arquivoClientePJ
                                        .lerArquivo("./lab06/dados/clientesPJ.csv", listaFrotas);
                        System.out.println(listaClientesPJ);
                        for (ClientePJ _clientePJ : listaClientesPJ) {
                                seguradora.cadastrarCliente(_clientePJ);
                        }
                        System.out.println("===============================");

                        for (Condutor condutores : listaCondutores) {
                                if (Character.getNumericValue(condutores.getCpf().charAt(0)) < 5) {
                                        seguroPF.autorizarCondutor(condutores);
                                } else {
                                        seguroPJ.autorizarCondutor(condutores);
                                }
                        }

                        Menu menu = new Menu(listaSeguradoras);
                        while (menu.next()) {
                        }
                        System.out.println("===============================");
                        System.out.println("==== Exportando seguros ====");
                        ArquivoSeguro arquivoSeguro = new ArquivoSeguro();
                        arquivoSeguro.gravarArquivo("./lab06/dados/seguros.csv", seguradora.getListaSeguros());
                        System.out.println("===============================");

                        System.out.println("==== Exportando sinistros ====");
                        ArrayList<Sinistro> listaSinistros = new ArrayList<>();
                        for (Seguro seguro : seguradora.getListaSeguros()) {
                                listaSinistros.addAll(seguro.getListaSinistros());
                        }
                        ArquivoSinistro arquivoSinistro = new ArquivoSinistro();
                        arquivoSinistro.gravarArquivo("./lab06/dados/sinistros.csv", listaSinistros);
                        System.out.println("===============================");
                        System.exit(0);

                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}
