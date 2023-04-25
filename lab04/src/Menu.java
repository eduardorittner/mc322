import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Operacao menuAtual;
    private ArrayList<Seguradora> listaSeguradoras;
    private Scanner scanner;

    Menu(ArrayList<Seguradora> listaSeguradoras) {
        this.listaSeguradoras = listaSeguradoras;
        this.menuAtual = Operacao.INICIAL;
        this.scanner = new Scanner(System.in);
    }

    public void executar(int operacao) {
        if (menuAtual == Operacao.INICIAL) {
            executarFuncao(Operacao.getEnum(operacao));
        } else {
            executarFuncao(Operacao.getEnum(10 * menuAtual.getOperacao() + operacao));
        }
    }

    public void executarFuncao(Operacao operacao) {
        switch (operacao) {
            case SAIR:
                System.exit(0);
            case CADASTRAR:
            case EDITAR:
            case EXCLUIR:
            case VISUALIZAR:
            case INICIAL:
                setMenuAtual(operacao);
                break;
            case GERAR_SINISTRO:

            case CALCULAR_RECEITA:

            case CADASTRAR_CLIENTE:

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

            case LISTAR_SINISTRO_SEG:

            case LISTAR_SINISTRO_CLIENTE:

            case LISTAR_VEICULO_CLIENTE:

            case LISTAR_VEICULO_SEG:
        }

    }

    public int next() throws Exception {
        String entrada = scanner.next();
        if (!entradaValida(entrada)) {
            throw new Exception("VAITOMANOCU");
        }
        return Integer.parseInt(entrada);
    }

    private boolean entradaValida(String entrada) {
        return entrada.matches("^[0-9]*$");
    }

    public void setMenuAtual(Operacao menu) {
        menuAtual = menu;
    }
}
