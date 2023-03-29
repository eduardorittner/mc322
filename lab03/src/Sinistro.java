import java.util.Random;
import java.lang.Math;

public class Sinistro {
    final int id;
    String data;
    String endereco;
    Seguradora seguradora;
    Veiculo veiculo;
    Cliente cliente;

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        Random random = new Random();
        this.id = Math.abs(random.nextInt()); // Queremos somente id positivos
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return "Sinistro [cliente=" + cliente + ", data=" + data + ", endereco=" + endereco + ", id=" + id
                + ", seguradora=" + seguradora + ", veiculo=" + veiculo + "]";
    }

}
