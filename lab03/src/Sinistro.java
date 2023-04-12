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

    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.id = criarId();
    }

    private int criarId() {
        do {
            Random random = new Random();
            int id = Math.abs(random.nextInt()); // Queremos somente id positivos
        } while (IdDuplicado(id));

        return id;
    }

    private boolean IdDuplicado(int id) {
        ArrayList<Sinistro> sinistros = seguradora.listarSinistros();
        for (Sinistro sinistroAtual : sinistros) {
            if (sinistroAtual.getId() == id) {
                return true;
            }
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
        return "[cliente: " + cliente + ", data: " + data + ", endereco: " + endereco + ", id: " + id
                + ", seguradora: " + seguradora.getNome() + ", veiculo: " + veiculo.getPlaca() + "]";
    }

}
