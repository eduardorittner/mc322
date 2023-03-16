package lab02;

import java.util.Random;

public class Sinistro {
    int id;
    String data;
    String endereco;

    public Sinistro(String data, String endereco) {
        Random random = new Random();
        this.id = random.nextInt();
        this.data = data;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
