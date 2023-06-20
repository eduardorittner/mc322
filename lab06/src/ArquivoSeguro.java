import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// TODO Arrumar formatacao da data no tocsv

public class ArquivoSeguro implements IArquivo {

    private ArrayList<Seguro> listaSeguros;

    public ArquivoSeguro(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public boolean gravarArquivo(String nomeArquivo) {
        // TODO como adicionar frotas/veiculos?
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

    public String lerArquivo(String arquivo) {
        return "false";
    }
}
