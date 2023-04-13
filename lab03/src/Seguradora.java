import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private LinkedList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new LinkedList<Cliente>();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        // Adicionar verificação se o cliente ja esta na lista
        try {
            listaClientes.add(cliente);
            // Conferir se ja existe um cliente com esse cpf
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerCliente(String cliente) {
        try {
            for (Cliente clienteAtual : listaClientes) {
                if (clienteAtual.getNome().equals(cliente)) {
                    listaClientes.remove(clienteAtual);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public LinkedList<Cliente> listarClientes(String tipoCliente) {
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();
        for (Cliente clienteAtual : listaClientes) {
            // getCanonicalName retorna o nome da classe como uma string, que pode ser
            // comparada diretamente com a string tipoCliente
            if (clienteAtual.getClass().getCanonicalName().equals(tipoCliente)) {
                clientes.add(clienteAtual);
            }
        }
        return clientes;
    }

    public boolean limparClientes() {
        try {
            listaClientes.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gerarSinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo,
            Cliente cliente) {
        if (cliente.listarVeiculos().contains(veiculo)) {
            try {
                Sinistro novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
                listaSinistros.add(novoSinistro);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean visualizarSinistro(String cliente) {
        for (Sinistro sinistroAtual : listaSinistros) {
            if (sinistroAtual.getCliente().equals(cliente)) {
                System.out.println(sinistroAtual);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Sinistro> listarSinistros() {
        return listaSinistros;
    }

    public boolean limparSinistros() {
        try {
            listaSinistros.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getNome() {
        return nome;
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

    @Override
    public String toString() {
        return "Seguradora\nNome: " + nome + "\nTelefone: " + telefone + "\nEndereco: " + endereco + "\nEmail: "
                + email + "\nQuantidade de Clientes: " + listaClientes.size() + "\nQuantidade de Sinistros: "
                + listaSinistros.size();
    }
}
