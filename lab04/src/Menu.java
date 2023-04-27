import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Menu {

    private String divisor = "===================================";
    private String menuInicial = "MENU INICIAL\n\n1 - Cadastrar\n2 - Editar\n3 - Excluir\n4 - Visualizar\n5 - Gerar Sinistro\n6 - Calcular receita\n0 - Sair";
    private String menuCadastrar = "MENU CADASTRAR\n\n1 - Cadastrar cliente PF\n2 - Cadastrar cliente PJ\n3 - Cadastrar veículo\n4 - Cadastrar seguradora\n0 - Voltar";
    private String menuEditar = "MENU EDITAR\n\n1 - Editar cliente\n2 - Editar veículo\n3 - Editar sinistro\n4 - Editar seguradora\n0 - Voltar";
    private String menuExcluir = "MENU EXCLUIR\n\n1 - Excluir cliente\n2 - Excluir veículo\n3 - Excluir seguradora\n4 - Excluir sinistro\n0 - Voltar";
    private String menuVisualizar = "MENU VISUALIZAR\n\n1 - Listar clientes por seguradora\n2 - Listar sinistro por seguradora\n3 - Listar sinistro por cliente\n4 - Listar veículos por cliente\n5 - Listar veículo por seguradoras\n0 - Voltar";
    private Operacao menuAtual;
    private ArrayList<Seguradora> listaSeguradoras;
    private Seguradora seguradoraAtual;
    private Scanner scanner;
    private SimpleDateFormat dateScanner;

    Menu() {
        this.scanner = new Scanner(System.in);
        this.dateScanner = new SimpleDateFormat("dd-MM-yyyy");
        // this.listaSeguradoras = inicializar();
        // ===================================================
        // FIXME
        Seguradora temp = new Seguradora("Petrobras", "19-984265556", "email@gmail.com.br", "Rua abacate 123");
        this.listaSeguradoras = new ArrayList<Seguradora>();
        listaSeguradoras.add(temp);
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
        System.out.println(divisor);
        System.out.println("Seguradora selecionada: " + seguradoraAtual.getNome() + "\n");
        if (menuAtual == Operacao.INICIAL) {
            System.out.println(menuInicial);
            return;
        }
        if (menuAtual == Operacao.CADASTRAR) {
            System.out.println(menuCadastrar);
            return;
        }
        if (menuAtual == Operacao.EDITAR) {
            System.out.println(menuEditar);
            return;
        }
        if (menuAtual == Operacao.EXCLUIR) {
            System.out.println(menuExcluir);
            return;
        }
        if (menuAtual == Operacao.VISUALIZAR) {
            System.out.println(menuVisualizar);
            return;
        }
    }

    private void executarFuncao(Operacao operacao) {
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
                setMenuAtual(operacao);
                break;

            case MUDAR_SEGURADORA:
                mudarSeguradoraAtual();
                break;

            case GERAR_SINISTRO:
                seguradoraAtual.cadastrarSinistro(scanner, dateScanner);

            case CALCULAR_RECEITA:

            case CADASTRAR_CLIENTEPF:
                seguradoraAtual.cadastrarCliente(Construtor.criarClientePF());
                break;

            case CADASTRAR_CLIENTEPJ:
                seguradoraAtual.cadastrarCliente(Construtor.criarClientePJ());
                break;

            case CADASTRAR_VEICULO:

            case CADASTRAR_SEGURADORA:

            case EDITAR_CLIENTE:

            case EDITAR_VEICULO:

            case EDITAR_SEGURADORA:

            case EDITAR_SINISTRO:

            case EXCLUIR_CLIENTE:

            case EXCLUIR_VEICULO:

            case EXCLUIR_SEGURADORA:

            case EXCLUIR_SINISTRO:

            case LISTAR_CLIENTE_SEG:
                System.out.println(seguradoraAtual.listarClientes("Cliente PF"));
                break;

            case LISTAR_SINISTRO_SEG:

            case LISTAR_SINISTRO_CLIENTE:

            case LISTAR_VEICULO_CLIENTE:

            case LISTAR_VEICULO_SEG:
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
