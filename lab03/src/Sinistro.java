import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;

public class Sinistro {
    final int id;
    Date data;
    String endereco;
    Seguradora seguradora;
    Veiculo veiculo;
    Cliente cliente;
    static ArrayList<Integer> listaIds = new ArrayList<Integer>();

    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.id = criarId();
    }

    private int criarId() {
        int id;
        Random random = new Random();
        do {
            id = Math.abs(random.nextInt()); // Queremos somente id positivos
        } while (IdDuplicado(id));

        listaIds.add(id);
        return id;
    }

    private boolean IdDuplicado(int id) {
        if (listaIds.contains(id)) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Sinistro " + id + " [cliente: " + cliente.getCadastroPessoal() + ", data: " + data + ", endereco: "
                + endereco + ", seguradora: " + seguradora.getNome() + ", veiculo: " + veiculo.getPlaca() + "]";
    }

}
