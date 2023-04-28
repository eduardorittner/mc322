public enum Operacao {
    CADASTRAR(1),
    CADASTRAR_CLIENTEPF(11),
    CADASTRAR_CLIENTEPJ(12),
    CADASTRAR_VEICULO(13),
    CADASTRAR_SEGURADORA(14),
    EDITAR(2),
    EDITAR_CLIENTE(21),
    EDITAR_VEICULO(22),
    EDITAR_SINISTRO(23),
    EDITAR_SEGURADORA(24),
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
    SELECIONAR_SEGURADORA(7),
    INICIAL(0);

    private final int operacao;

    Operacao(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }

    public static Operacao getEnum(int operacao) {
        for (Operacao p : Operacao.values()) {
            if (p.getOperacao() == operacao) {
                return p;
            }
        }
        return Operacao.INICIAL;
    }
}
