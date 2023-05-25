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

                        clientePF.cadastrarVeiculo(new Veiculo("GUD4142", "Toyota", "Sedan", 2020));
                        System.out.println("==== Veículo cadastrado no ClientePF ====");
                        System.out.println("===============================");
                        System.out.println(clientePF.getVeiculo("GUD4142"));
                        System.out.println("===============================");

                        // clientePJ.cadastrarVeiculo(new Veiculo("DIK1234", "Honda", "Civic", 2020));
                        // System.out.println("==== Veículo cadastrado no ClientePJ ====");
                        // System.out.println("===============================");
                        // System.out.println(clientePJ.getVeiculo("DIK1234"));
                        // System.out.println("===============================");

                        // seguradora.cadastrarSinistro(new Sinistro(new Date(), "Rua do sinistro",
                        // seguradora,
                        // clientePF.getVeiculo("GUD4142"), clientePF));
                        // System.out.println("==== Novo sinistro gerado no ClientePF ====");
                        // System.out.println("===============================");
                        // seguradora.visualizarSinistro("45878931885");
                        // System.out.println("===============================");

                        // seguradora.cadastrarSinistro(new Sinistro(new Date(), "Rua do sinistro",
                        // seguradora,
                        // clientePJ.getVeiculo("DIK1234"), clientePJ));
                        // System.out.println("==== Novo sinistro gerado no ClientePJ ====");
                        // System.out.println("===============================");
                        // seguradora.visualizarSinistro("26.774.450/0001-25");

                        System.out.println("==== Listar Clientes ====");
                        System.out.println("===============================");
                        System.out.println(seguradora.listarClientes());
                        System.out.println("===============================");

                        System.out.println("==== Visualizar sinistro ====");
                        System.out.println("===============================");
                        // TODO
                        // seguradora.visualizarSinistro("26.774.450/0001-25");
                        System.out.println("===============================");

                        System.out.println("==== Listar Sinistros ====");
                        System.out.println("===============================");
                        System.out.println(seguradora.listarSinistros());
                        System.out.println("===============================");

                        System.out.println("==== Calcula Preço Seguro (Juvenaldo) ====");
                        System.out.println("===============================");
                        // TODO
                        // System.out.println(seguradora.calculaPrecoSeguroCliente(clientePF));
                        System.out.println("===============================");

                        System.out.println("==== Calcula Preço Seguro (Milton LTDA) ====");
                        System.out.println("===============================");
                        // TODO
                        // System.out.println(seguradora.calculaPrecoSeguroCliente(clientePJ));
                        System.out.println("===============================");

                        System.out.println("==== Calcula receita ====");
                        System.out.println("===============================");
                        // TODO
                        // System.out.println(seguradora.calculaReceita());
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
