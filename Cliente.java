public class Cliente {

    String nome;
    String cpf;
    String dataNascimento;
    String endereco;
    int idade;

    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    private boolean digitosIguaisCPF(String cpf) {
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String digitosVerificadoresCPF(String cpf) {
        int total = 0;
        int atual;
        int resto;
        int primeiro_digito_verificador;
        for (int i = 0; i < 9; i++) {
            atual = Character.getNumericValue(cpf.charAt(i));
            total += atual * (10 - i);
        }
        resto = total % 11;
        if (resto == 0 || resto == 1) {
            primeiro_digito_verificador = 0;
        } else {
            primeiro_digito_verificador = 11 - resto;
        }

        total = 0;

        for (int i = 0; i < 9; i++) {
            atual = Character.getNumericValue(cpf.charAt(i));
            total += atual * (11 - i);
        }
        total += primeiro_digito_verificador * 2;
        resto = total % 11;
        int segundo_digito_verificador;
        if (resto == 0 || resto == 1) {
            segundo_digito_verificador = 0;
        } else {
            segundo_digito_verificador = 11 - resto;
        }

        String resultado = Integer.toString(primeiro_digito_verificador)
                .concat(Integer.toString(segundo_digito_verificador));
        return resultado;
    }

    public boolean validarCPF() {
        cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11) {
            return false;
        }
        if (digitosIguaisCPF(cpf)) {
            return false;
        }
        String digitos_verificadores = digitosVerificadoresCPF(cpf);
        if (digitos_verificadores.charAt(0) != cpf.charAt(9)) {
            return false;
        }
        if (digitos_verificadores.charAt(1) != cpf.charAt(10)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", idade="
                + idade + ", nome=" + nome + "]";
    }
}
