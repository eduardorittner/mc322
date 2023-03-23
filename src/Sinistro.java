import java.util.Random;
import java.lang.Math;

public class Sinistro {
    int id;
    String data;
    String endereco;

    public Sinistro(String data, String endereco) {
        this.data = data;
        this.endereco = endereco;
        setId();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        Random random = new Random();
        this.id = Math.abs(random.nextInt()); // Queremos somente id positivos
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
}
