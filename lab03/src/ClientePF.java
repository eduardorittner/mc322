import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePF extends Cliente {

    private final String cpf;
    private Date dataNascimento;

    public ClientePF(String nome, String cpf, Date dataLicenca, String educacao, String genero,
            String classeEconomica, String endereco, Date dataNascimento)
            throws Exception {

        super(nome, dataLicenca, educacao, genero, classeEconomica, endereco);

        this.dataNascimento = dataNascimento;

        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new Exception("Cpf inserido é inválido");
        }
    }

    public static ClientePF criarCliente() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Criando um novo Cliente PF");
                System.out.println("Que tipo de cliente? pf/pj");
                String tipo = scanner.next();
                System.out.println("Nome: ");
                String nome = scanner.next();
                System.out.println("Educação: ");
                String educacao = scanner.next();
                System.out.println("Gênero: ");
                String genero = scanner.next();
                System.out.println("Classe econômica: ");
                String classeEconomica = scanner.next();
                System.out.println("Endereço: ");
                String endereco = scanner.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Data da licença (dd-mm-aaaa): ");
                String rawDataLicenca = scanner.next();
                Date dataLicenca = dateFormat.parse(rawDataLicenca);
                System.out.println("Cpf: ");
                String cpf = scanner.next();
                System.out.println("Data de nascimento (dd-mm-aaaa): ");
                String rawDataNascimento = scanner.next();
                Date dataNascimento = dateFormat.parse(rawDataNascimento);
                ClientePF cliente = new ClientePF(nome, cpf, dataLicenca, educacao, genero, classeEconomica, endereco,
                        dataNascimento);
                return cliente;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Cpf digitado é invalido, tente novamente.");
            }
        }
    }

    private boolean cpfDigitosIguais(String cpf) {
        // Retorna true se o cpf for composto de somente um dígito repetido 11 vezes

        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String digitosVerificadoresCPF(String cpf) {
        // Calcula os digitos verificadores do cpf com base nos 9 primeiros números

        int total = 0;
        int atual;
        int resto;
        int primeiro_digito_verificador;
        for (int i = 0; i < 9; i++) {
            atual = Character.getNumericValue(cpf.charAt(i));
            total += atual * (10 - i);
        }
        resto = total % 11;
        if (resto < 2) {
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
        if (resto < 2) {
            segundo_digito_verificador = 0;
        } else {
            segundo_digito_verificador = 11 - resto;
        }

        String resultado = Integer.toString(primeiro_digito_verificador)
                + (Integer.toString(segundo_digito_verificador));

        return resultado;
    }

    public boolean validarCPF(String cpf) {
        String aux_cpf = cpf.replaceAll("[^\\d]", "");

        if (aux_cpf.length() != 11) {
            return false;
        }
        if (cpfDigitosIguais(aux_cpf)) {
            return false;
        }
        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresCPF(aux_cpf).equals(aux_cpf.substring(9)));
        if (digitosVerificadoresDiferentes) {
            return false;
        }

        return true;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf(String cpf) {
        return this.cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncpf: " + cpf + "\ndataNascimento: " + dataNascimento;
    }

}
