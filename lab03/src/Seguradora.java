import java.util.LinkedList;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private int quantidadeSinistros;
    private ArrayList<Cliente> listaClientes;
    private int quantidadeClientes;

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        try {
            listaClientes.add(cliente);
            quantidadeClientes++;
            return true;
        } finally {
            return false;
        }
    }

    public boolean removerCliente(String cliente) {
        try {
            for (int i = 0; i < quantidadeClientes; i++) {
                if (listaClientes.get(i).getNome() == cliente) {
                    listaClientes.remove(i);
                    quantidadeClientes--;
                    return true;
                }
            }
        } finally {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo,
            Cliente cliente) {
        try {
            Sinistro novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
            listaSinistros.add(novoSinistro);
            quantidadeSinistros++;
            return true;
        } finally {
            return false;
        }
    }

    public Sinistro visualizarSinistro(String cliente) {
        for (int i = 0; i < quantidadeSinistros; i++) {
        }
    }

    public ArrayList<Sinistro> listarSinistros() {
        return listaSinistros;
    }

    Sinistro getSinistro(int indice) {
        return listaSinistros.get(indice);
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public int getQuantidadeSinistros() {
        return quantidadeSinistros;
    }

    public void setQuantidadeSinistros(int quantidadeSinistros) {
        this.quantidadeSinistros = quantidadeSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
