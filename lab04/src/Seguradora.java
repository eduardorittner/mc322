import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email,
            String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    public static Seguradora cadastrarSeguradora(Scanner scanner) {
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Telefone: ");
        String telefone = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Endereco: ");
        String endereco = scanner.next();
        return new Seguradora(nome, telefone, email, endereco);
    }

    public void transferirSeguro(Cliente clienteOrigem, Cliente clienteDestino) {
        clienteDestino.concatenaListaVeiculos(clienteOrigem.listarVeiculos());
        clienteOrigem.limparVeiculos();
        clienteDestino.calculaScore();
        clienteOrigem.calculaScore();
    }

    public double calculaReceita() {
        int receita = 0;
        for (Cliente cliente : listaClientes) {
            receita += calculaPrecoSeguroCliente(cliente);
        }
        return receita;
    }

    public double calculaPrecoSeguroCliente(Cliente cliente) {
        double resultado = cliente.calculaScore() * (1 + qtdeSinistros(cliente));
        cliente.setValorSeguro(resultado);
        return resultado;
    }

    private int qtdeSinistros(Cliente cliente) {
        int qtd = 0;
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getCliente().equals(cliente)) {
                qtd++;
            }
        }
        return qtd;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        // Confirma se não existe nenhum cliente com o mesmo cpf ou cnpj já
        // cadastrado
        for (Cliente clienteAtual : listaClientes) {
            if (cliente.getCadastroPessoal().equals(
                    clienteAtual.getCadastroPessoal())) {
                return false;
            }
        }
        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(String cliente) {
        // TODO testar que a funcao removeSinistrosCliente funciona
        for (Cliente clienteAtual : listaClientes) {
            if (clienteAtual.getNome().equals(cliente)) {
                removeSinistrosCliente(clienteAtual);
                listaClientes.remove(clienteAtual);
                return true;
            }
        }
        return false;
    }

    private void removeSinistrosCliente(Cliente cliente) {
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getCliente().equals(cliente)) {
                listaSinistros.remove(sinistro);
            }
        }
    }

    public ArrayList<Cliente> listarClientes() {
        return listaClientes;
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

    public Cliente getCliente(String id) {
        id = id.replaceAll("[^\\d]", "");
        for (Cliente cliente : listaClientes) {
            if (cliente.getCadastroPessoal().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean cadastrarSinistro(Sinistro sinistro) {
        if (sinistro.equals(null)) {
            return false;
        }
        listaSinistros.add(sinistro);
        return false;
    }

    public Sinistro getSinistro(String in) {
        try {
            int id = Integer.parseInt(in);
            for (Sinistro sinistro : listaSinistros) {
                if (sinistro.getId() == id) {
                    return sinistro;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean visualizarSinistro(String idCliente) {
        String idNormalizado = idCliente.replaceAll("[^\\d]", "");
        for (Sinistro sinistroAtual : listaSinistros) {
            if (sinistroAtual.getCliente().getCadastroPessoal().equals(idNormalizado)) {
                System.out.println(sinistroAtual);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Sinistro> listarSinistrosCliente(Cliente cliente) {
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getCliente().equals(cliente)) {
                sinistrosCliente.add(sinistro);
            }
        }
        return sinistrosCliente;
    }

    public ArrayList<Sinistro> listarSinistros() {
        return listaSinistros;
    }

    public boolean removeSinistro(int id) {
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getId() == (id)) {
                listaSinistros.remove(sinistro);
                return true;
            }
        }
        return false;
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
        return "Seguradora\nNome: " + nome + "\nTelefone: " + telefone +
                "\nEndereço: " + endereco + "\nEmail: " + email +
                "\nQuantidade de Clientes: " + listaClientes.size() +
                "\nQuantidade de Sinistros: " + listaSinistros.size();
    }
}
