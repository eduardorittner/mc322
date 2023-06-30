import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Menu {

    private String divisor = "=====================================";
    private String menuInicial = "1 - Cadastrar\n2 - Excluir\n3 - Visualizar\n4 - Gerar Sinistro\n5 - Calcular receita\n6 - Calcular seguro\n7 - Selecionar seguradora\n0 - Sair";
    private String menuCadastrar = "======= MENU CADASTRAR =======\n" + divisor
            + "\n1 - Cadastrar cliente PF\n2 - Cadastrar cliente PJ\n3 - Cadastrar seguro PF\n4 - Cadastrar seguro PJ\n5 - Cadastrar condutor\n6 - Cadastrar veiculo\n7 - Cadastrar seguradora\n8 - Cadastrar frota\n0 - Voltar";
    private String menuExcluir = "======= MENU EXCLUIR =======\n" + divisor
            + "\n1 - Excluir cliente\n2 - Excluir veículo\n3 - Excluir seguradora\n4 - Excluir sinistro\n0 - Voltar";
    private String menuVisualizar = "======= MENU VISUALIZAR =======\n" + divisor
            + " \n1 - Listar clientes por seguradora\n2 - Listar seguros por seguradora\n3 - Listar frotas por cliente\n4 - Listar veículos por cliente\n5 - Listar condutor por seguro\n6 - Listar sinistros por cliente\n0 - Voltar";
    private MenuOperacoes menuAtual;
    private ArrayList<Seguradora> listaSeguradoras;
    private Seguradora seguradoraAtual;
    private Scanner scanner;
    private SimpleDateFormat dateScanner;

    Menu(ArrayList<Seguradora> listaSeguradoras) {
        this.scanner = new Scanner(System.in);
        this.dateScanner = new SimpleDateFormat("dd-MM-yyyy");
        if (listaSeguradoras.equals(null)) {
            this.listaSeguradoras = inicializar();
        } else {
            this.listaSeguradoras = listaSeguradoras;
            this.seguradoraAtual = listaSeguradoras.get(0);
            this.menuAtual = MenuOperacoes.INICIAL;
        }
    }

    private ArrayList<Seguradora> inicializar() {
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

        System.out.println(divisor);
        System.out.println("LAB 04 - Eduardo Rittner Coelho 250960");
        System.out.println("Por favor cadastre pelo menos uma seguradora para começar");
        listaSeguradoras.add(Seguradora.cadastrarSeguradora(scanner));
        return listaSeguradoras;
    }

    public boolean next() {
        imprimirMenu();
        try {
            int comando = nextComando();
            if ((executar(comando))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return true;
        }
    }

    public int nextComando() throws Exception {
        String entrada = scanner.next();
        return Integer.parseInt(entrada);
    }

    public boolean executar(int operacao) {
        if (executarFuncao(MenuOperacoes.getEnum(10 * menuAtual.getMenuOperacoes() + operacao)) == false) {
            return false;
        }
        return true;
    }

    private void imprimirMenu() {
        if (menuAtual == MenuOperacoes.INICIAL) {
            System.out.println("======= MENU DA SEGURADORA " + seguradoraAtual.getNome() + " =======");
            System.out.println(divisor);
            System.out.println(menuInicial);
        } else if (menuAtual == MenuOperacoes.CADASTRAR) {
            System.out.println(menuCadastrar);
        } else if (menuAtual == MenuOperacoes.EXCLUIR) {
            System.out.println(menuExcluir);
        } else if (menuAtual == MenuOperacoes.VISUALIZAR) {
            System.out.println(menuVisualizar);
        }
    }

    private boolean executarFuncao(MenuOperacoes operacao) {
        Cliente cliente;
        ClientePF clientePF;
        ClientePJ clientePJ;
        Seguro seguro;
        SeguroPF seguroPF;
        SeguroPJ seguroPJ;
        Frota frota;
        String nome;

        switch (operacao) {
            case INICIAL:
                if (menuAtual == MenuOperacoes.INICIAL) {
                    return false;
                }
                setMenuAtual(operacao);
                break;
            case CADASTRAR:
            case EXCLUIR:
            case VISUALIZAR:
                // Nesse caso, a unica operação realizada é a mudança do menu atual
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
                System.out.println("Id do seguro: ");
                seguro = seguradoraAtual.getSeguro(Integer.parseInt(scanner.next()));
                Sinistro sinistro = Construtor.criarSinistro(seguro);
                seguro.gerarSinistro(sinistro);
                System.out.println(divisor);
                break;

            case CALCULAR_RECEITA:
                System.out.println("======= Calculando a receita =======");
                System.out.println("Receita: " + seguradoraAtual.calculaReceita());
                System.out.println(divisor);
                break;

            case CALCULAR_SEGURO:
                System.out.println("======= Calculando seguro =======");
                System.out.println("Id do seguro: ");
                seguro = seguradoraAtual.getSeguro(Integer.parseInt(scanner.next()));
                if (seguro != null) {
                    System.out.println(seguro.getValorMensal());
                } else {
                    System.out.println("Seguro não encontrado.");
                }
                System.out.println(divisor);

                break;

            case CADASTRAR_CLIENTEPF:
                try {
                    System.out.println("======= Cadastrando cliente com CPF =======");
                    seguradoraAtual.cadastrarCliente(Construtor.criarClientePF());
                    System.out.println(divisor);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(divisor);
                break;

            case CADASTRAR_CLIENTEPJ:
                try {
                    System.out.println("======= Cadastrando cliente com CNPJ =======");
                    seguradoraAtual.cadastrarCliente(Construtor.criarClientePJ());
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(divisor);
                break;

            case CADASTRAR_SEGUROPF:
                System.out.println("======= Cadastrando Seguro PF =======");
                System.out.println("Cpf do cliente: ");
                clientePF = (ClientePF) seguradoraAtual.getCliente(scanner.next());
                if (clientePF != null) {
                    seguroPF = Construtor.criarSeguro(seguradoraAtual, clientePF);
                    seguradoraAtual.cadastrarSeguro(seguroPF);
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                System.out.println(divisor);
                break;

            case CADASTRAR_SEGUROPJ:
                System.out.println("======= Cadastrando Seguro PJ =======");
                System.out.println("Cnpj do cliente: ");
                clientePJ = (ClientePJ) seguradoraAtual.getCliente(scanner.next());
                if (clientePJ != null) {
                    System.out.println("Nome da frota: ");
                    frota = seguradoraAtual.getFrota(scanner.next());
                    seguroPJ = Construtor.criarSeguro(seguradoraAtual, clientePJ, frota);
                    seguradoraAtual.cadastrarSeguro(seguroPJ);
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                System.out.println(divisor);
                break;

            case CADASTRAR_CONDUTOR:
                System.out.println("======= Cadastrando condutor =======");
                System.out.println("Id do seguro: ");
                seguro = seguradoraAtual.getSeguro(Integer.parseInt(scanner.next()));
                if (seguro != null) {
                    seguro.autorizarCondutor(Construtor.criarCondutor());
                } else {
                    System.out.println("Seguro não encontrado.");
                }

                break;

            case CADASTRAR_VEICULO:
                System.out.println("======= Cadastrando veículo =======");
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                if (cliente instanceof ClientePF) {
                    ((ClientePF) cliente).cadastrarVeiculo(Construtor.criarVeiculo());
                } else if (cliente instanceof ClientePJ) {
                    System.out.println("Nome da frota: ");
                    frota = ((ClientePJ) cliente).getFrota(scanner.next());
                    ((ClientePJ) cliente).atualizarFrota(frota, "cadastrar", Construtor.criarVeiculo());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                break;

            case CADASTRAR_SEGURADORA:
                System.out.println("======= Cadastrando seguradora =======");
                seguradoraAtual = Construtor.criarSeguradora();
                listaSeguradoras.add(seguradoraAtual);
                System.out.println(divisor);
                break;

            case CADASTRAR_FROTA:
                System.out.println("======= Cadastrando frota =======");
                System.out.println("Id do cliente: ");
                clientePJ = (ClientePJ) seguradoraAtual.getCliente(scanner.next());
                frota = Construtor.criarFrota();
                clientePJ.cadastrarFrota(frota);
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
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());
                System.out.println("Placa do veículo: ");
                String placa = scanner.next();
                if (cliente instanceof ClientePF) {
                    if (!((ClientePF) cliente).removerVeiculo(placa)) {
                        System.out.println("Veículo não encontrado.");
                    }
                } else {
                    if (!((ClientePJ) cliente).removerVeiculo(placa)) {
                        System.out.println("Veículo não encontrado.");
                    }
                }
                System.out.println(divisor);
                break;

            case EXCLUIR_SEGURADORA:
                System.out.println("======= Excluindo seguradora ========");
                System.out.println("Nome da seguradora: ");
                nome = scanner.next();
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

            case EXCLUIR_SEGURO:
                break;

            case EXCLUIR_FROTA:
                System.out.println("======= Excluindo frota =======");
                System.out.println("Qual o identificador da frota?");
                nome = scanner.next();
                boolean removido = false;
                for (Cliente clienteAtual : seguradoraAtual.getListaClientes("PJ")) {
                    clientePJ = (ClientePJ) clienteAtual;
                    if (clientePJ.removerFrota(nome)) {
                        removido = true;
                        System.out.println("Frota " + nome + " removida com sucesso");
                        break;
                    }
                }

                if (!removido) {
                    System.out.println("Não existe frota com esse id");
                }

                break;

            case EXCLUIR_CONDUTOR:
                System.out.println("======= Excluindo condutor =======");
                System.out.println("Cpf do condutor: ");
                if (!seguradoraAtual.removeCondutor(scanner.next())) {
                    System.out.println("Condutor não encontrado.");
                }
                break;

            case LISTAR_CLIENTE_SEGURADORA:
                System.out.println("======= Listando clientes por seguradora ========");
                ArrayList<Cliente> listaClientes = seguradoraAtual.getListaClientes();
                for (Cliente clienteAux : listaClientes) {
                    System.out.println(clienteAux);
                    System.out.println(divisor);
                }
                break;

            case LISTAR_SEGURO_SEGURADORA:
                System.out.println("======= Listando sinistros por seguradora ========");
                ArrayList<Seguro> listaSeguros = seguradoraAtual.getListaSeguros();
                for (Seguro seguroAtual : listaSeguros) {
                    System.out.println(seguroAtual);
                    System.out.println(divisor);
                }
                break;

            case LISTAR_FROTA_CLIENTE:
                System.out.println("======= Listando frotas por cliente =======");
                System.out.println("Id do cliente: ");
                clientePJ = (ClientePJ) seguradoraAtual.getCliente(scanner.next());
                if (clientePJ != null) {
                    System.out.println(clientePJ.getListaFrotas());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                System.out.println(divisor);
                break;

            case LISTAR_VEICULO_CLIENTE:
                System.out.println("======= Listando veiculos por cliente ========");
                System.out.println("Id do cliente: ");
                cliente = seguradoraAtual.getCliente(scanner.next());

                if (cliente instanceof ClientePF) {
                    System.out.println(((ClientePF) cliente).getListaVeiculos());
                } else if (cliente instanceof ClientePJ) {
                    System.out.println(((ClientePJ) cliente).getVeiculosPorFrota());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                break;

            case LISTAR_CONDUTOR_SEGURO:
                System.out.println("======= Listando condutores por seguro =======");
                for (Seguro seguroCondutores : seguradoraAtual.getListaSeguros()) {
                    System.out.println("==== Seguro " + seguroCondutores.getId() + " ====");
                    for (Condutor condutor : seguroCondutores.getListaCondutores()) {
                        System.out.println(condutor);
                    }
                    System.out.println(divisor);
                }
                break;

            case LISTAR_SINISTRO_CLIENTE:
                System.out.println("======= Listando sinistros por condutor =======");
                HashMap<Cliente, ArrayList<Sinistro>> sinistrosPorCliente = seguradoraAtual.getSinistrosPorCliente();
                for (Cliente clienteSinistro : sinistrosPorCliente.keySet()) {
                    System.out.println("==== " + clienteSinistro.getNome() + " ====");
                    for (Sinistro sinistroCliente : sinistrosPorCliente.get(clienteSinistro)) {
                        System.out.println(sinistroCliente);
                    }
                    System.out.println(divisor);
                }
                break;

        }
        return true;

    }

    public void setMenuAtual(MenuOperacoes menu) {
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
