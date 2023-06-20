import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// TODO Arrumar formatacao da data no tocsv

public class ArquivoSinistro implements IArquivo {

    private ArrayList<Sinistro> listaSinistros;

    public ArquivoSinistro(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public boolean gravarArquivo(String nomeArquivo) {
        String colunas = "id;condutor;seguro;data;endereço";
        File arquivo = new File(nomeArquivo);
        try {
            arquivo.createNewFile();
            FileWriter escritor = new FileWriter(arquivo, false);
            escritor.write(colunas);
            for (Sinistro sinistro : listaSinistros) {
                escritor.write(sinistro.toCsv());
            }
            escritor.flush();
            escritor.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public String lerArquivo(String arquivo) {
        return "false";
    }
}
