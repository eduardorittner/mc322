import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoSeguro implements IArquivo {

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaObjetos) {

        ArrayList<Seguro> listaSeguros = (ArrayList<Seguro>) listaObjetos;

        String colunas = "id;dataInicio;dataFim;seguradora;listaSinistros;listaCondutores;cliente;frota/veiculo;valorMensal";
        File arquivo = new File(nomeArquivo);
        try {
            arquivo.createNewFile();
            FileWriter escritor = new FileWriter(arquivo, false);
            escritor.write(colunas);
            for (Seguro seguro : listaSeguros) {
                escritor.write(seguro.toCsv());
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
