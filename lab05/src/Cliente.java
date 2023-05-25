import java.util.Scanner;
import java.util.Date;
import java.util.LinkedList;
import java.util.ArrayList;

public abstract class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    public Cliente(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    abstract public String getCadastroPessoal();

}
