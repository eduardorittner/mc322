import java.util.ArrayList;

public interface IArquivo {

    public boolean gravarArquivo(String nomeArquivo, ArrayList<?> listaObjetos);

    public ArrayList<?> lerArquivo(String arquivo);
}
