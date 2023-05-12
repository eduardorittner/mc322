import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Validacao {

    private static String digitosVerificadoresCNPJ(String cnpj) {
        int total = 0;
        int resto = 0;
        int atual;
        int primeiro_digito_verificador;
        int segundo_digito_verificador;
        int[] multiplicadores = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        for (int i = 0; i < 12; i++) {
            atual = Character.getNumericValue(cnpj.charAt(i));
            total += atual * multiplicadores[i + 1];
        }

        resto = total % 11;
        if (resto < 2) {
            primeiro_digito_verificador = 0;
        } else {
            primeiro_digito_verificador = 11 - resto;
        }

        total = 0;

        for (int i = 0; i < 13; i++) {
            atual = Character.getNumericValue(cnpj.charAt(i));
            total += atual * multiplicadores[i];
        }

        resto = total % 11;

        if (resto < 2) {
            segundo_digito_verificador = 0;
        } else {
            segundo_digito_verificador = 11 - resto;
        }

        String resultado = Integer.toString(primeiro_digito_verificador)
                + (Integer.toString(segundo_digito_verificador));

        return resultado;
    }

    public static boolean validarCNPJ(String cnpj) {
        String aux_cnpj = cnpj.replaceAll("[^\\d]", "");

        if (aux_cnpj.length() != 14) {
            return false;
        }

        String digitosVerificadoresOriginais = aux_cnpj.substring(12);
        String digitosVerificadoresCorretos = digitosVerificadoresCNPJ(aux_cnpj);
        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresOriginais.equals(digitosVerificadoresCorretos));
        if (digitosVerificadoresDiferentes) {
            return false;
        }

        return true;
    }

    private static boolean cpfDigitosIguais(String cpf) {
        // Retorna true se o cpf for composto de somente um dígito repetido 11 vezes

        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String digitosVerificadoresCPF(String cpf) {
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

    public static boolean validarCPF(String cpf) {
        String aux_cpf = cpf.replaceAll("[^\\d]", "");

        if (aux_cpf.length() != 11) {
            return false;
        }
        if (cpfDigitosIguais(aux_cpf)) {
            return false;
        }

        String digitosVerificadoresOriginais = aux_cpf.substring(9);
        String digitosVerificadoresCorretos = digitosVerificadoresCPF(aux_cpf);
        boolean digitosVerificadoresDiferentes = !(digitosVerificadoresOriginais.equals(digitosVerificadoresCorretos));
        if (digitosVerificadoresDiferentes) {
            return false;
        }

        return true;
    }

    public static boolean validarNome(String nome) {
        return nome != null && nome.matches("^[a-zA-ZÀ-ȩ]*$");
    }

    public static boolean validarData(Date data) {
        Date dataAtual = new Date();
        return dataAtual.after(data);
    }

    public static boolean validarIdade(Date data) {
        Date dataAtual = new Date();

        long diferencaEmMiliS = dataAtual.getTime() - data.getTime();
        long idade = TimeUnit.DAYS.convert(diferencaEmMiliS, TimeUnit.MILLISECONDS) / 365;
        return idade > 18;
    }
}
