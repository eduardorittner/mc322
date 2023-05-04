import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Editor {
    private Scanner scanner;
    private SimpleDateFormat dateScanner;

    private String menuSeguradora = "O que você gostaria de editar?\n1 - Nome\n2 - Telefone\n3 - Email\n4 - Endereço";
    private String menuVeiculo = "O que você gostaria de editar?\n1 - Placa\n2 - Marca\n3 - Modelo\n4 - Ano de fabricação";
    private String menuClientePF = "O que você gostaria de editar?\n1 - nome\n2 - Data da licença\n3 - educação\n4 - Classe econômica\n5 - Endereço\n6 - Data de nascimento";
    private String menuClientePJ = "O que você gostaria de editar?\n1 - Nome\n2 - Endereǫ\n3 - Data de fundação";

    public Editor(Scanner scanner, SimpleDateFormat dateScanner) {
        this.scanner = scanner;
        this.dateScanner = dateScanner;
    }

    private int next() {
        return Integer.parseInt(scanner.next());
    }

    public void editarSeguradora(Seguradora seguradora) {
        System.out.println(menuSeguradora);
        try {
            int comando = this.next();
            switch (comando) {
                case 1:
                    System.out.println("Nome: ");
                    seguradora.setNome(scanner.next());
                    return;
                case 2:
                    System.out.println("Telefone: ");
                    seguradora.setTelefone(scanner.next());
                    return;
                case 3:
                    System.out.println("Email: ");
                    seguradora.setEmail(scanner.next());
                    return;
                case 4:
                    System.out.println("Endereço: ");
                    seguradora.setEndereco(scanner.next());
                    return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarVeiculo(Veiculo veiculo) {
        System.out.println(menuVeiculo);
        try {
            int comando = this.next();
            switch (comando) {
                case 1:
                    System.out.println("Placa: ");
                    veiculo.setPlaca(scanner.next());
                    return;
                case 2:
                    System.out.println("Marca: ");
                    veiculo.setMarca(scanner.next());
                    return;
                case 3:
                    System.out.println("Modelo: ");
                    veiculo.setModelo(scanner.next());
                    return;
                case 4:
                    System.out.println("Ano de fabricação: ");
                    int anoFabricacao = Integer.parseInt(scanner.next());
                    veiculo.setAnoFabricacao(comando);
                    return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarCliente(Cliente cliente) {
        if (cliente instanceof ClientePJ) {
            editarCliente((ClientePJ) cliente);
        } else {
            editarCliente((ClientePF) cliente);
        }
    }

    public void editarCliente(ClientePJ cliente) {
        System.out.println(menuClientePJ);
        try {
            int comando = this.next();
            switch (comando) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.next();
                    cliente.setNome(nome);
                    break;
                case 2:
                    System.out.println("Endereço: ");
                    String endereco = scanner.next();
                    cliente.setEndereco(endereco);
                    break;
                case 3:
                    System.out.println("Data de fundação: ");
                    Date dataFundacao = dateScanner.parse(scanner.next());
                    cliente.setDataFundacao(dataFundacao);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarCliente(ClientePF cliente) {
        System.out.println(menuClientePF);
        try {
            int comando = this.next();
            switch (comando) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.next();
                    cliente.setNome(nome);
                    break;
                case 2:
                    System.out.println("Data da licença: ");
                    Date dataLicenca = dateScanner.parse(scanner.next());
                    cliente.setDataLicenca(dataLicenca);
                    break;
                case 3:
                    System.out.println("Educação: ");
                    String educacao = scanner.next();
                    cliente.setEducacao(educacao);
                    break;
                case 4:
                    System.out.println("Classe econômica: ");
                    String classeEconomica = scanner.next();
                    cliente.setClasseEconomica(classeEconomica);
                    break;
                case 5:
                    System.out.println("Endereço: ");
                    String endereco = scanner.next();
                    cliente.setEndereco(endereco);
                    break;
                case 6:
                    System.out.println("Data de nascimento: ");
                    Date dataNascimento = dateScanner.parse(scanner.next());
                    cliente.setDataNascimento(dataNascimento);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
