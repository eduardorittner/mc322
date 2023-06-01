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
                                        "milton@gmail.com", data, "03.778.130/0001-48");

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
                        System.out.println(seguradora.listarClientes());
                        System.out.println("===============================");

                        System.out.println("==== Visualizar sinistro do condutor PF ====");
                        System.out.println("===============================");
                        System.out.println(seguroPF.getSinistro(sinistroPF.getId()));
                        System.out.println("===============================");

                        System.out.println("==== Listar Sinistros por cliente ====");
                        System.out.println("===============================");
                        seguradora.imprimeSegurosPorCliente();
                        System.out.println("===============================");

                        System.out.println("==== Calcula receita ====");
                        System.out.println("===============================");
                        System.out.println(seguradora.calculaReceita());
                        System.out.println("===============================");

                        Menu menu = new Menu(listaSeguradoras);
                        while (true) {
                                menu.next();
                        }

                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}
