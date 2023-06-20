import java.util.ArrayList;

public class Veiculo {

    private static ArrayList<String> listaPlacas = new ArrayList<String>();
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) throws Exception {
        if (!placaValida(placa)) {
            throw new Exception("Esta placa já está registrada no sistema");
        }
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public static boolean placaValida(String placa) {
        if (listaPlacas.contains(placa)) {
            return false;
        }
        return true;
    }

    public static void removePlaca(String placa) {
        listaPlacas.remove(placa);
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo + "\nAno de fabricação: "
                + anoFabricacao;
    }

}
