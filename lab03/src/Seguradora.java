import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        // Confirma se não existe nenhum cliente com o mesmo cpf ou cnpj já cadastrado
        for (Cliente clienteAtual : listaClientes) {
            if (cliente.getCadastroPessoal().equals(clienteAtual.getCadastroPessoal())) {
                return false;
            }
        }
        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(String cliente) {
        for (Cliente clienteAtual : listaClientes) {
            if (clienteAtual.getNome().equals(cliente)) {
                listaClientes.remove(clienteAtual);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        for (Cliente clienteAtual : listaClientes) {
            // getCanonicalName retorna o nome da classe como uma string, que pode ser
            // comparada diretamente com a string tipoCliente
            if (clienteAtual.getClass().getCanonicalName().equals(tipoCliente)) {
                clientes.add(clienteAtual);
            }
        }
        return clientes;
    }

    public boolean visualizarCliente(String cliente) {
        for (Cliente clienteAtual : listaClientes) {
            if (clienteAtual.getNome().equals(cliente)) {
                System.out.println(clienteAtual);
                return true;
            }
        }
        return false;
    }

    public boolean limparClientes() {
        // Não limpa uma lista vazia
        if (listaClientes.isEmpty()) {
            return false;
        }
        listaClientes.clear();
        return true;
    }

    public boolean gerarSinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo,
            Cliente cliente) {
        if (!cliente.listarVeiculos().contains(veiculo)) {
            return false;
        }
        Sinistro novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        listaSinistros.add(novoSinistro);
        return true;
    }

    public boolean visualizarSinistro(String cliente) {
        for (Sinistro sinistroAtual : listaSinistros) {
            if (sinistroAtual.getCliente().getNome().equals(cliente)) {
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
        if (listaSinistros.isEmpty()) {
            return false;
        }
        listaSinistros.clear();
        return true;
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
