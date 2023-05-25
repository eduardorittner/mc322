import java.util.ArrayList;
import java.util.Random;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    private static ArrayList<Integer> listaIds;

    public Frota(String code) {
        this.code = code;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void limparListaVeiculos() {
        listaVeiculos.clear();
    }

    public boolean addVeiculo(Veiculo veiculo) {
        if (listaVeiculos.contains(veiculo)) {
            return false;
        }
        listaVeiculos.add(veiculo);
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

}
