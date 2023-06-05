import java.util.ArrayList;
import java.util.Random;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

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

    public Veiculo getVeiculo(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
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

    @Override

    public String toString() {
        return "Nome: " + code + "\nQuantidade de Veiculos: " + listaVeiculos.size();
    }

}
