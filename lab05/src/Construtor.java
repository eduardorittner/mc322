import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Construtor {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateScanner = new SimpleDateFormat("dd-MM-yyyy");

    public static ClientePF criarClientePF() {
        while (true) {
            try {
                System.out.println("Criando um novo Cliente PF");
                System.out.println("Nome: ");
                String nome = scanner.next();
                System.out.println("Telefone: ");
                String telefone = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                System.out.println("Educação: ");
                String educacao = scanner.next();
                System.out.println("Gênero: ");
                String genero = scanner.next();
                System.out.println("Classe econômica: ");
                String classeEconomica = scanner.next();
                System.out.println("Endereço: ");
                String endereco = scanner.next();
                System.out.println("Data da licença (dd-mm-aaaa): ");
                String rawDataLicenca = scanner.next();
                Date dataLicenca = dateScanner.parse(rawDataLicenca);
                System.out.println("Cpf: ");
                String cpf = scanner.next();
                System.out.println("Data de nascimento (dd-mm-aaaa): ");
                String rawDataNascimento = scanner.next();
                Date dataNascimento = dateScanner.parse(rawDataNascimento);
                ClientePF cliente = new ClientePF(nome, endereco, telefone, email, cpf, genero, educacao,
                        dataNascimento);
                return cliente;
            } catch (java.text.ParseException e) {
                System.out.println("Data inserida possui formato inválido, tente novamente");
            } catch (Exception e) {
                System.out.println("Cpf digitado é invalido, tente novamente.");
            }
        }
    }

    public static ClientePJ criarClientePJ() {
        while (true) {
            try {
                System.out.println("Criando um novo Cliente PJ");
                System.out.println("Nome: ");
                String nome = scanner.next();
                System.out.println("Telefone: ");
                String telefone = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                System.out.println("Endereço: ");
                String endereco = scanner.next();
                System.out.println("Cnpj: ");
                String cnpj = scanner.next();
                System.out.println("Data de fundação (dd-mm-aaaa): ");
                String rawDataFundacao = scanner.next();
                Date dataFundacao = dateScanner.parse(rawDataFundacao);
                System.out.println("Quantidade de funcionários: ");
                int qtdeFuncionarios = Integer.parseInt(scanner.next());
                ClientePJ cliente = new ClientePJ(nome, endereco, telefone, email, dataFundacao, cnpj);
                return cliente;
            } catch (java.text.ParseException e) {
                System.out.println("Data inserida possui formato inválido, tente novamente");
            } catch (Exception e) {
                System.out.println("Cpf digitado é invalido, tente novamente.");
            }
        }
    }

    public static Seguradora criarSeguradora() {
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Telefone: ");
        String telefone = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Endereco: ");
        String endereco = scanner.next();
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
        return seguradora;
    }

    public static SeguroPJ criarSeguro(Seguradora seguradora, ClientePJ cliente, Frota frota) {
        try {
            System.out.println("Data de início: ");
            Date dataInicio = dateScanner.parse(scanner.next());
            System.out.println("Data de término: ");
            Date dataFinal = dateScanner.parse(scanner.next());

            ArrayList<Condutor> listaCondutores = new ArrayList<>();
            System.out.println("Quer adicionar algum condutor? y/n");
            String escolha = scanner.next();
            while (escolha.equals("y")) {
                Condutor condutor = Construtor.criarCondutor();
                System.out.println("Quer adicionar mais um condutor? y/n");
                escolha = scanner.next();
            }
            SeguroPJ seguro = new SeguroPJ(dataInicio, dataFinal, seguradora, listaCondutores, frota, cliente);
            return seguro;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static SeguroPF criarSeguro(Seguradora seguradora, ClientePF cliente) {
        try {
            System.out.println("Placa do veículo: ");
            String placa = scanner.next();
            Veiculo veiculo = cliente.getVeiculo(placa);
            System.out.println("Data de início: ");
            Date dataInicio = dateScanner.parse(scanner.next());
            System.out.println("Data de término: ");
            Date dataFinal = dateScanner.parse(scanner.next());

            ArrayList<Condutor> listaCondutores = new ArrayList<>();
            System.out.println("Quer adicionar algum condutor? y/n");
            String escolha = scanner.next();
            while (escolha.equals("y")) {
                Condutor condutor = Construtor.criarCondutor();
                System.out.println("Quer adicionar mais um condutor? y/n");
                escolha = scanner.next();
            }
            SeguroPF seguro = new SeguroPF(dataInicio, dataFinal, seguradora, listaCondutores, veiculo, cliente);
            return seguro;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Condutor criarCondutor() {
        try {
            System.out.println("=== Cadastrando condutor ===");
            System.out.println("Cpf: ");
            String cpf = scanner.next();
            System.out.println("Nome: ");
            String nome = scanner.next();
            System.out.println("Telefone: ");
            String telefone = scanner.next();
            System.out.println("Endereço: ");
            String endereco = scanner.next();
            System.out.println("Email: ");
            String email = scanner.next();
            System.out.println("Data de nascimento: (dd-MM-yyyy)");
            Date dataNascimento = dateScanner.parse(scanner.next());
            Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, dataNascimento);
            return condutor;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Sinistro criarSinistro(Seguro seguro) {
        try {
            System.out.println("Data: dd-MM-yyyy");
            Date data = dateScanner.parse(scanner.nextLine());
            System.out.println("Endereço: ");
            String endereco = scanner.next();
            System.out.println("O titular estava envolvido no sinistro? y/n");
            if (scanner.next().equals("y")) {
                Sinistro sinistro = new Sinistro(data, endereco, null, seguro);
                return sinistro;
            }
            System.out.println("Cpf do condutor: ");
            String cpf = scanner.next();
            Condutor condutor = seguro.getCondutor(cpf);
            Sinistro sinistro = new Sinistro(data, endereco, condutor, seguro);
            return sinistro;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Veiculo criarVeiculo() {
        try {
            System.out.println("Placa: ");
            String placa = scanner.next();
            System.out.println("Marca: ");
            String marca = scanner.next();
            System.out.println("Modelo: ");
            String modelo = scanner.next();
            System.out.println("Ano de fabricacao: ");
            int anoFabricacao = Integer.parseInt(scanner.next());
            // placa marca modelo anofabricacao
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            return veiculo;
        } catch (Exception e) {
            System.out.println("Esta placa já está já registrada");
            return null;
        }
    }

    public static Frota criarFrota() {
        System.out.println("Nome da frota: ");
        String nome = scanner.next();
        return new Frota(nome);
    }
}
