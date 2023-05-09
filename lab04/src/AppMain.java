import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AppMain {
        public static void main(String[] args) {
                try {
                        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
                        listaSeguradoras.add(new Seguradora("Petrobras", "(19) 99999-9999",
                                        "Petrobras@gmail.com",
                                        "Rua da Petrobras, 000"));

                        ClientePF clientePF = new ClientePF("Juvenaldo", "458.789.318-85", new Date(), "Yale",
                                        "Homem", "A", "Rua do Juvenaldo, 10", new Date());

                        ClientePJ clientePJ = new ClientePJ("Milton LTDA", "Rua do Milton LTDA", new Date(),
                                        "12.345.678/0001-00", 10);

                        clientePF.cadastrarVeiculo(new Veiculo("GUD4142", "Toyota", "Sedan", 2020));
                        clientePJ.cadastrarVeiculo(new Veiculo("DIK1234", "Honda", "Civic", 2020));

                        listaSeguradoras.get(0).cadastrarSinistro(
                                        new Sinistro(new Date(), "Rua do sinistro", listaSeguradoras.get(0),
                                                        clientePF.getVeiculo("GUD4142"), clientePF));

                        listaSeguradoras.get(0).cadastrarSinistro(
                                        new Sinistro(new Date(), "Rua do sinistro", listaSeguradoras.get(0),
                                                        clientePF.getVeiculo("DIK1234"), clientePJ));

                } catch (Exception e) {
                        System.out.println(e);
                }

                Menu menu = new Menu(new ArrayList<Seguradora>());
                while (true) {
                        menu.next();
                }
        }
}
