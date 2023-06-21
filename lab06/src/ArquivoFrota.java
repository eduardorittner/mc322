import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class ArquivoFrota implements IArquivo {

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaFrotas) {
        return false;
    }

    public ArrayList<?> lerArquivo(String nomeArquivo) {
        ArrayList<Frota> listaFrotas = new ArrayList<Frota>();

        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String code = valores[0];

                listaFrotas.add(new Frota(code));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listaFrotas;
    }

    public ArrayList<?> lerArquivo(String nomeArquivo, ArrayList<Veiculo> listaVeiculos) {
        ArrayList<Frota> listaFrotas = new ArrayList<Frota>();
        Frota frota;
        String placa;

        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine(); // Le a primeira linha, o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                String valores[] = linha.split(",");
                String code = valores[0];
                frota = new Frota(code);

                for (int i = 1; i < valores.length; i++) {
                    placa = valores[i];
                    for (Veiculo veiculo : listaVeiculos) {
                        if (veiculo.getPlaca().equals(placa)) {
                            frota.addVeiculo(veiculo);
                        }
                    }
                }
                listaFrotas.add(frota);
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return listaFrotas;
    }

}
