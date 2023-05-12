public enum MenuOperacoes {
    CADASTRAR(1),
    CADASTRAR_CLIENTEPF(11),
    CADASTRAR_CLIENTEPJ(12),
    CADASTRAR_VEICULO(13),
    CADASTRAR_SEGURADORA(14),
    EXCLUIR(2),
    EXCLUIR_CLIENTE(21),
    EXCLUIR_VEICULO(22),
    EXCLUIR_SEGURADORA(23),
    EXCLUIR_SINISTRO(24),
    VISUALIZAR(3),
    LISTAR_CLIENTE_SEG(31),
    LISTAR_SINISTRO_SEG(32),
    LISTAR_SINISTRO_CLIENTE(33),
    LISTAR_VEICULO_CLIENTE(34),
    LISTAR_VEICULO_SEG(35),
    GERAR_SINISTRO(4),
    CALCULAR_RECEITA(5),
    CALCULAR_SEGURO_CLIENTE(6),
    TRANSFERIR_SEGURO(7),
    SELECIONAR_SEGURADORA(8),
    INICIAL(0);

    private final int operacao;

    MenuOperacoes(int operacao) {
        this.operacao = operacao;
    }

    public int getMenuOperacoes() {
        return this.operacao;
    }

    public static MenuOperacoes getEnum(int operacao) {
        for (MenuOperacoes p : MenuOperacoes.values()) {
            if (p.getMenuOperacoes() == operacao) {
                return p;
            }
        }
        return MenuOperacoes.INICIAL;
    }
}
