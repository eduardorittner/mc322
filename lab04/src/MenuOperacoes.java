public enum MenuOperacoes {
    CADASTRAR(1),
    CADASTRAR_CLIENTEPF(11),
    CADASTRAR_CLIENTEPJ(12),
    CADASTRAR_VEICULO(13),
    CADASTRAR_SEGURADORA(14),
    EDITAR(2),
    EDITAR_CLIENTE(21),
    EDITAR_VEICULO(22),
    EDITAR_SEGURADORA(23),
    EXCLUIR(3),
    EXCLUIR_CLIENTE(31),
    EXCLUIR_VEICULO(32),
    EXCLUIR_SEGURADORA(34),
    EXCLUIR_SINISTRO(33),
    VISUALIZAR(4),
    LISTAR_CLIENTE_SEG(41),
    LISTAR_SINISTRO_SEG(42),
    LISTAR_SINISTRO_CLIENTE(43),
    LISTAR_VEICULO_CLIENTE(44),
    LISTAR_VEICULO_SEG(45),
    GERAR_SINISTRO(5),
    CALCULAR_RECEITA(6),
    CALCULAR_SEGURO_CLIENTE(7),
    TRANSFERIR_SEGURO(8),
    SELECIONAR_SEGURADORA(9),
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
