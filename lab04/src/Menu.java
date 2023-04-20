public enum Menu {
    CADASTRAR(1),
    SAIR(0);

    private final int operacao;

    Menu(int operacao) {
        this.operacao = operacao;
    }
}
