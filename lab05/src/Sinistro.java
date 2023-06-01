import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;

public class Sinistro {
    private final int id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    private static ArrayList<Integer> listaIds = new ArrayList<Integer>();

    public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
        this.id = criarId();
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public static ArrayList<Integer> getListaIds() {
        return listaIds;
    }

    public static void setListaIds(ArrayList<Integer> listaIds) {
        Sinistro.listaIds = listaIds;
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
        return "Sinistro " + id + "\nData: " + data + "\nEndereço: " + endereco + "\nCondutor: " + condutor.getCpf()
                + "\nSeguro: " + seguro.getId();
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
