import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
// TODO tirar import de date
import java.util.Date;

public class Menu {

    private String divisor = "=====================================";
    private String menuInicial = "1 - Cadastrar\n2 - Editar\n3 - Excluir\n4 - Visualizar\n5 - Gerar Sinistro\n6 - Calcular receita\n7 - Calcular seguro\n8 - Transferir seguro\n9 - Selecionar seguradora\n0 - Sair";
    private String menuCadastrar = "======= MENU CADASTRAR =======\n" + divisor
            + "\n1 - Cadastrar cliente PF\n2 - Cadastrar cliente PJ\n3 - Cadastrar veículo\n4 - Cadastrar seguradora\n0 - Voltar";
    private String menuEditar = "======= MENU EDITAR =======\n" + divisor
            + "\n1 - Editar cliente\n2 - Editar veículo\n3 - Editar sinistro\n4 - Editar seguradora\n0 - Voltar";
    private String menuExcluir = "======= MENU EXCLUIR =======\n" + divisor
            + "\n1 - Excluir cliente\n2 - Excluir veículo\n3 - Excluir seguradora\n4 - Excluir sinistro\n0 - Voltar";
    private String menuVisualizar = "======= MENU VISUALIZAR =======\n" + divisor
            + " \n1 - Listar clientes por seguradora\n2 - Listar sinistro por seguradora\n3 - Listar sinistro por cliente\n4 - Listar veículos por cliente\n5 - Listar veículo por seguradoras\n0 - Voltar";
    private Operacao menuAtual;
    private ArrayList<Seguradora> listaSeguradoras;
    private Seguradora seguradoraAtual;
    private Scanner scanner;
    private SimpleDateFormat dateScanner;
    private Editor editor;

    Menu() {
        this.scanner = new Scanner(System.in);
        this.dateScanner = new SimpleDateFormat("dd-MM-yyyy");
        this.editor = new Editor(scanner, dateScanner);
        // this.listaSeguradoras = inicializar();
        // ===================================================
        // FIXME
        try {
            Seguradora temp = new Seguradora("Petrobras", "19-984265556", "email@gmail.com.br", "Rua abacate 123");
            Date data = new Date();
            ClientePF clientePF = new ClientePF("nome", "458.789.318-85", data, "educacao", "genero",
                    "classeEconomica", "endereco", data);
            ClientePJ clientePJ = new ClientePJ("outro nome", "endereco", data, "11.444.777/0001-61", 7);
            Veiculo veiculo1 = new Veiculo("placa", "marca", "modelo", 2000);
            Veiculo veiculo2 = new Veiculo("PLACA", "marca", "modelo", 2001);
            clientePF.cadastrarVeiculo(veiculo1);
            clientePJ.cadastrarVeiculo(veiculo2);
            temp.cadastrarCliente(clientePF);
            temp.cadastrarCliente(clientePJ);
            this.listaSeguradoras = new ArrayList<Seguradora>();
            listaSeguradoras.add(temp);
        } catch (Exception e) {
            System.out.println(e);
        }
        // ===================================================
        this.seguradoraAtual = listaSeguradoras.get(0);
        this.menuAtual = Operacao.INICIAL;
    }

    private ArrayList<Seguradora> inicializar() {
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

        System.out.println(divisor);
        System.out.println("LAB 04 - Eduardo Rittner Coelho 250960");
        System.out.println("Por favor cadastre pelo menos uma seguradora para começar");
        listaSeguradoras.add(Seguradora.cadastrarSeguradora(scanner));
        return listaSeguradoras;
    }

    public void next() {
        imprimirMenu();
        try {
            int comando = nextComando();
            executar(comando);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int nextComando() throws Exception {
        String entrada = scanner.next();
        return Integer.parseInt(entrada);
    }

    public void executar(int operacao) {
        executarFuncao(Operacao.getEnum(10 * menuAtual.getOperacao() + operacao));
    }

    private void imprimirMenu() {
        if (menuAtual == Operacao.INICIAL) {
            System.out.println("======= MENU DA SEGURADORA " + seguradoraAtual.getNome() + " =======");
            System.out.println(divisor);
            System.out.println(menuInicial);
        } else if (menuAtual == Operacao.CADASTRAR) {
            System.out.println(menuCadastrar);
        } else if (menuAtual == Operacao.EDITAR) {
            System.out.println(menuEditar);
        } else if (menuAtual == Operacao.EXCLUIR) {
            System.out.println(menuExcluir);
        } else if (menuAtual == Operacao.VISUALIZAR) {
            System.out.println(menuVisualizar);
        }
    }

    private void executarFuncao(Operacao operacao) {
        Cliente cliente;
        switch (operacao) {
            case INICIAL:
                if (menuAtual == Operacao.INICIAL) {
                    System.exit(0);
                }
                setMenuAtual(operacao);
                break;
            case CADASTRAR:
            case EDITAR:
            case EXCLUIR:
            case VISUALIZAR:
                System.out.println(divisor);
                setMenuAtual(operacao);
                break;

            case SELECIONAR_SEGURADORA:
                System.out.println("======= Selecionando seguradora =======");
                mudarSeguradoraAtual();
                System.out.println(divisor);
                break;

            case GERAR_SINISTRO:
                System.out.println("======= Gerando sinistro =======");
                seguradoraAtual.cadastrarSinistro(Construtor.criarSinistro(seguradoraAtual));
                System.out.println(divisor);
                break;

            case CALCULAR_RECEITA:
                System.out.println("======= Calculando a receita =======");
                System.out.println("Receita: " + seguradoraAtual.calculaReceita());
                System.out.println(divisor);
                break;

            case CALCULAR_SEGURO_CLIENTE:
                System.out.println("======= Calculando o seguro do cliente =======");
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                System.out.println("Valor: " + seguradoraAtual.calculaPrecoSeguroCliente(cliente));
                System.out.println(divisor);
                break;

            case TRANSFERIR_SEGURO:
                System.out.println("======= Transferindo seguro =======");
                System.out.println("Id do cliente que quer transferir o seguro: ");
                Cliente clienteOrigem = seguradoraAtual.getCliente(scanner.next());
                System.out.println("Id do cliente para quem quer transferir o seguro: ");
                Cliente clienteDestino = seguradoraAtual.getCliente(scanner.next());
                System.out.println(clienteDestino);
                seguradoraAtual.transferirSeguro(clienteOrigem, clienteDestino);
                System.out.println(divisor);
                break;

            case CADASTRAR_CLIENTEPF:
                System.out.println("======= Cadastrando cliente com CPF =======");
                seguradoraAtual.cadastrarCliente(Construtor.criarClientePF());
                System.out.println(divisor);
                break;

            case CADASTRAR_CLIENTEPJ:
                System.out.println("======= Cadastrando cliente com CNPJ =======");
                seguradoraAtual.cadastrarCliente(Construtor.criarClientePJ());
                System.out.println(divisor);
                break;

            case CADASTRAR_VEICULO:
                System.out.println("======= Cadastrando veículo =======");
                System.out.println("Id do cliente: ");
                seguradoraAtual.getCliente(scanner.next()).cadastrarVeiculo(Construtor.criarVeiculo());
                System.out.println(divisor);
                break;

            case CADASTRAR_SEGURADORA:
                System.out.println("======= Cadastrando seguradora =======");
                seguradoraAtual = Construtor.criarSeguradora();
                listaSeguradoras.add(seguradoraAtual);
                System.out.println(divisor);
                break;

            case EDITAR_CLIENTE:
                System.out.println("======= Editando cliente =======");
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                editor.editarCliente(cliente);
                System.out.println(divisor);
                break;

            case EDITAR_VEICULO:
                System.out.println("======= Editando veículo =======");
                System.out.println("Id do cliente dono do veículo: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                System.out.println("Placa do veículo: ");
                Veiculo veiculo = cliente.getVeiculo(scanner.next());
                editor.editarVeiculo(veiculo);
                System.out.println(divisor);
                break;

            case EDITAR_SEGURADORA:
                System.out.println("======= Editando seguradora =======");
                editor.editarSeguradora(seguradoraAtual);
                System.out.println(divisor);
                break;

            case EXCLUIR_CLIENTE:
                System.out.println("======= Excluindo cliente ========");
                System.out.println("Id do cliente: ");
                seguradoraAtual.removerCliente(scanner.next());
                System.out.println(divisor);
                break;

            case EXCLUIR_VEICULO:
                System.out.println("======= Excluindo veiculo ========");
                System.out.println("Placa do carro: ");
                String placa = scanner.next();
                for (Cliente clienteAtual : seguradoraAtual.listarClientes()) {
                    for (Veiculo veiculoAtual : clienteAtual.listarVeiculos()) {
                        if (veiculoAtual.getPlaca().equals(placa)) {
                            clienteAtual.removerVeiculo(veiculoAtual.getPlaca());
                        }
                    }
                }
                System.out.println(divisor);
                break;

            case EXCLUIR_SEGURADORA:
                System.out.println("======= Excluindo seguradora ========");
                System.out.println("Nome da seguradora: ");
                String nome = scanner.next();
                if (seguradoraAtual.getNome().equals(nome)) {
                    listaSeguradoras.remove(seguradoraAtual);
                    seguradoraAtual = listaSeguradoras.get(0);
                } else {
                    for (Seguradora seguradora : listaSeguradoras) {
                        if (seguradora.getNome().equals(nome)) {
                            listaSeguradoras.remove(seguradora);
                        }
                    }
                }
                System.out.println(divisor);
                break;

            case EXCLUIR_SINISTRO:
                System.out.println("======= Excluindo sinistro ========");
                System.out.println("Id do sinistro: ");
                int id = Integer.parseInt(scanner.next());
                seguradoraAtual.removeSinistro(id);
                System.out.println(divisor);
                break;

            case LISTAR_CLIENTE_SEG:
                System.out.println("======= Listando clientes por seguradora ========");
                ArrayList<Cliente> listaClientes = seguradoraAtual.listarClientes();
                for (Cliente clienteAux : listaClientes) {
                    System.out.println(clienteAux);
                    System.out.println(divisor);
                }
                break;

            case LISTAR_SINISTRO_SEG:
                System.out.println("======= Listando sinistros por seguradora ========");
                ArrayList<Sinistro> listaSinistros = seguradoraAtual.listarSinistros();
                for (Sinistro sinistroAux : listaSinistros) {
                    System.out.println(sinistroAux);
                    System.out.println(divisor);
                }
                break;

            case LISTAR_SINISTRO_CLIENTE:
                System.out.println("======= Listando sinistros por cliente ========");
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                ArrayList<Sinistro> sinistrosCliente = seguradoraAtual.listarSinistrosCliente(cliente);
                for (Sinistro sinistroAux2 : sinistrosCliente) {
                    System.out.println(sinistroAux2);
                    System.out.println(divisor);
                }
                break;

            case LISTAR_VEICULO_CLIENTE:
                System.out.println("======= Listando veiculos por cliente ========");
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                for (Veiculo veiculoAux : cliente.listarVeiculos()) {
                    System.out.println(veiculoAux);
                    System.out.println(divisor);
                }
                break;

            case LISTAR_VEICULO_SEG:
                System.out.println("======= Listando veiculos por seguradora ========");
                for (Cliente clienteVeiculo : seguradoraAtual.listarClientes()) {
                    for (Veiculo veiculoAux2 : clienteVeiculo.listarVeiculos()) {
                        System.out.println(veiculoAux2);
                        System.out.println(divisor);
                    }
                }
                break;
        }
    }

    public void setMenuAtual(Operacao menu) {
        menuAtual = menu;
    }

    private void mudarSeguradoraAtual() {
        while (true) {
            System.out.println("Para qual seguradora você gostaria de mudar?");
            for (Seguradora seguradora : listaSeguradoras) {
                System.out.println(seguradora.getNome());
            }
            String entrada = scanner.next();
            for (Seguradora seguradora : listaSeguradoras) {
                if (seguradora.getNome().equals(entrada)) {
                    this.seguradoraAtual = seguradora;
                    return;
                }
            }
        }
    }
}
