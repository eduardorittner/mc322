// TODO

import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArquivoClientePF implements IArquivo {
    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaObjetos) {

    }

    public ArrayList<?> lerArquivo(String nomeArquivo, ArrayList<Veiculo> listaVeiculos) {
        ArrayList<ClientePF> listaClientes = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        ClientePF cliente;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String cpf = valores[0];
                String nome = valores[1];
                String telefone = valores[2];
                String endereco = valores[3];
                String email = valores[4];
                String sexo = valores[5];
                String ensino = valores[6];
                Date dataNascimento = dateFormat.parse(valores[7]);
                for (int i = 8; i < valores.length; i++) {
                    // Para cada carro
                    String placa = valores[i];

                }

                try {
                    listaClientes.add(cliente);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listaClientes;
    }

    public ArrayList<?> lerArquivo(String nomeArquivo) {
        ArrayList<ClientePF> listaClientes = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        ClientePF cliente;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String cpf = valores[0];
                String nome = valores[1];
                String telefone = valores[2];
                String endereco = valores[3];
                String email = valores[4];
                String sexo = valores[5];
                String ensino = valores[6];
                Date dataNascimento = dateFormat.parse(valores[7]);
                for (int i = 8; i < valores.length; i++) {
                    // Para cada carro
                    String placa = valores[i];

                }

                try {
                    listaClientes.add(cliente);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listaClientes;
    }
}
