
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArquivoClientePJ implements IArquivo {

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaObjetos) {
        return false;
    }

    public ArrayList<?> lerArquivo(String nomeArquivo) {
        ArrayList<ClientePJ> listaClientes = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        ClientePJ cliente;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String cnpj = valores[0];
                String nome = valores[1];
                String telefone = valores[2];
                String endereco = valores[3];
                String email = valores[4];
                Date dataFundacao = dateFormat.parse(valores[5]);

                try {
                    cliente = new ClientePJ(nome, endereco, telefone, email, dataFundacao, cnpj);
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

    public ArrayList<?> lerArquivo(String nomeArquivo, ArrayList<Frota> listaFrotas) {
        ArrayList<ClientePJ> listaClientes = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        ClientePJ cliente;
        String nomeFrota;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String cnpj = valores[0];
                String nome = valores[1];
                String telefone = valores[2];
                String endereco = valores[3];
                String email = valores[4];
                Date dataFundacao = dateFormat.parse(valores[5]);

                try {
                    cliente = new ClientePJ(nome, endereco, telefone, email, dataFundacao, cnpj);
                    for (int i = 6; i < valores.length; i++) {
                        nomeFrota = valores[i];
                        for (Frota frota : listaFrotas) {
                            if (frota.getCode().equals(nomeFrota)) {
                                cliente.cadastrarFrota(frota);
                            }
                        }
                    }
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
