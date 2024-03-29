import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;

public class Sinistro {
    private final int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    private static ArrayList<Integer> listaIds = new ArrayList<Integer>();
    // As operações mais realizadas na listaIds são de adição no fim do vetor e
    // iteração sobre o mesmo, sendo assim, um array é mais eficiente

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
        return "Sinistro " + id + "\nSeguradora: " + seguradora.getNome() + "\nCliente: " + cliente.getCadastroPessoal()
                + "\nVeículo: " + veiculo.getPlaca() + "\nData: " + data + "\nEndereço: " + endereco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sinistro other = (Sinistro) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
