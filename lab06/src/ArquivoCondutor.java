// TODO Saber exatamente como proceder com o retorn de string e etc

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArquivoCondutor implements IArquivo {

    public ArquivoCondutor() {
    }

    public ArrayList<?> lerArquivo(String nomeArquivo) {
        ArrayList<Condutor> listaCondutores = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        Condutor condutor;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String cpf = valores[0];
                String nome = valores[1];
                String telefone = valores[2].substring(1, 3) + valores[2].substring(5).replaceAll("-", "");
                String endereco = valores[3];
                String email = valores[4];
                Date dataNascimento = dateFormat.parse(valores[5]);

                try {
                    condutor = new Condutor(cpf, nome, telefone, endereco, email, dataNascimento);
                    listaCondutores.add(condutor);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listaCondutores;
    }

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaCondutores) {
        return false;
    }

}
