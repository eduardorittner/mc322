
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ArquivoVeiculo implements IArquivo {

    public ArrayList<?> lerArquivo(String nomeArquivo) {
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String placa = valores[0];
                String marca = valores[1];
                String modelo = valores[2];
                int anoFabricacao = Integer.parseInt(valores[3]);

                listaVeiculos.add(new Veiculo(placa, marca, modelo, anoFabricacao));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listaVeiculos;
    }

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaVeiculos) {
        return false;
    }
}
