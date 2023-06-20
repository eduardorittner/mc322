import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoSinistro implements IArquivo {

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaObjetos) {
        ArrayList<Sinistro> listaSinistros = (ArrayList<Sinistro>) listaObjetos;

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

    public ArrayList<?> lerArquivo(String arquivo) {
        return null;
    }
}
