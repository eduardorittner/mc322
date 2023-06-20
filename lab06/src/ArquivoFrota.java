import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class ArquivoFrota implements IArquivo {

    private ArrayList<Frota> listaFrotas;

    public ArquivoFrota(ArrayList<Frota> listaFrotas) {
        this.listaFrotas = listaFrotas;
    }

    public boolean gravarArquivo(String nomeArquivo) {

        int quantidadeVeiculos = quantidadeMaxVeiculos(listaFrotas);
        File arquivo = new File(nomeArquivo);
        System.out.println("a1ui");
        try {
            if (!arquivo.createNewFile()) {
                FileWriter escritor = new FileWriter(arquivo);
                String primeiraLinha = "ID_FROTA";
                for (int veiculo = 1; veiculo <= quantidadeVeiculos; veiculo++) {
                    primeiraLinha += ",VEICULO" + veiculo;
                }
                escritor.write(primeiraLinha + "\n");

                for (Frota frota : listaFrotas) {
                    String linha = frota.getCode();
                    for (Veiculo veiculo : frota.getListaVeiculos()) {
                        linha += "," + veiculo.getPlaca();

                    }
                    escritor.write(linha + "\n");
                }
                escritor.flush();

            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private int quantidadeMaxVeiculos(ArrayList<Frota> listaFrotas) {
        int max = 0;
        int atual = 0;
        for (Frota frota : listaFrotas) {
            atual = frota.getListaVeiculos().size();
            if (atual > max) {
                max = atual;
            }
        }
        return max;
    }

    public String lerArquivo(String nomeArquivo) {
        // TODO
        return "oi";
    }
}
