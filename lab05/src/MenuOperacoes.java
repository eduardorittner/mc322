public enum MenuOperacoes {
    CADASTRAR(1),
    CADASTRAR_CLIENTEPF(11),
    CADASTRAR_CLIENTEPJ(12),
    CADASTRAR_SEGUROPF(13),
    CADASTRAR_SEGUROPJ(14),
    CADASTRAR_CONDUTOR(15),
    CADASTRAR_VEICULO(16),
    CADASTRAR_SEGURADORA(17),
    CADASTRAR_FROTA(18),
    EXCLUIR(2),
    EXCLUIR_CLIENTE(21),
    EXCLUIR_VEICULO(22),
    EXCLUIR_SEGURADORA(23),
    EXCLUIR_SINISTRO(24),
    EXCLUIR_SEGURO(25),
    EXCLUIR_FROTA(26),
    EXCLUIR_CONDUTOR(27),
    VISUALIZAR(3),
    LISTAR_CLIENTE_SEGURADORA(31),
    LISTAR_SEGURO_SEGURADORA(32),
    LISTAR_FROTA_CLIENTE(33),
    LISTAR_VEICULO_CLIENTE(34),
    LISTAR_CONDUTOR_SEGURO(35),
    LISTAR_SINISTRO_CLIENTE(36),
    GERAR_SINISTRO(4),
    CALCULAR_RECEITA(5),
    CALCULAR_SEGURO(6),
    SELECIONAR_SEGURADORA(7),
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
