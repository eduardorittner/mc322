import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email,
            String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSeguros = new ArrayList<Seguro>();
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

    public double calculaReceita() {
        int receita = 0;
        for (Seguro seguro : listaSeguros) {
            receita += seguro.calcularValor();
        }
        return receita;
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        // Confirma se não existe nenhum cliente com o mesmo cpf ou cnpj já
        // cadastrado
        if (listaClientes.contains(cliente)) {
            throw new Exception("Já existe um cliente com o mesmo ID cadastrado");
        }
        listaClientes.add(cliente);
    }

    public boolean removerCliente(String idCliente) {
        Cliente cliente = getCliente(idCliente);
        if (cliente != null) {
            removeSegurosCliente(cliente);
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    private boolean removeSegurosCliente(Cliente cliente) {
        for (Seguro seguro : listaSeguros) {
            if (seguro.getCliente().equals(cliente)) {
                listaSeguros.remove(seguro);
                return true;
            }
        }
        return false;
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

    public boolean visualizarCliente(String idCliente) {
        Cliente cliente = getCliente(idCliente);
        if (cliente != null) {
            System.out.println(cliente);
            return true;
        }
        System.out.println("O id não foi encontrado");
        return false;
    }

    public boolean cadastrarSeguro(Seguro seguro) {
        if (listaSeguros.contains(seguro)) {
            return false;
        }
        listaSeguros.add(seguro);
        return true;
    }

    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Cliente> getListaClientes(String tipo) {

        ArrayList<Cliente> lista = new ArrayList<>();

        if (tipo.equals("PF")) {
            for (Cliente cliente : listaClientes) {
                if (cliente instanceof ClientePF) {
                    lista.add(cliente);
                }
            }
        }
        if (tipo.equals("PJ")) {
            for (Cliente cliente : listaClientes) {
                if (cliente instanceof ClientePJ) {
                    lista.add(cliente);
                }
            }
        }
        return lista;
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

    public boolean limparClientes() {
        // Não limpa uma lista vazia
        if (listaClientes.isEmpty()) {
            return false;
        }
        listaClientes.clear();
        return true;
    }

    public Condutor getCondutor(String cpf) {
        String aux_cpf = cpf.replaceAll("[^\\d]", "");

        for (Seguro seguro : listaSeguros) {
            for (Condutor condutor : seguro.getListaCondutores()) {
                if (condutor.getCpf().equals(aux_cpf)) {
                    return condutor;
                }
            }
        }
        return null;
    }

    public boolean removeCondutor(String cpf) {
        String aux_cpf = cpf.replaceAll("[^\\d]", "");

        for (Seguro seguro : listaSeguros) {
            for (Condutor condutor : seguro.getListaCondutores()) {
                if (condutor.getCpf().equals(aux_cpf)) {
                    seguro.desautorizarCondutor(condutor);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeSinistro(int id) {
        for (Seguro seguro : listaSeguros) {
            if (seguro.removeSinistro(id)) {
                return true;
            }
        }
        return false;
    }

    public Seguro getSeguro(int id) {
        for (Seguro seguro : listaSeguros) {
            if (seguro.getId() == id) {
                return seguro;
            }
        }
        return null;
    }

    public Frota getFrota(String nome) {
        for (Cliente cliente : listaClientes) {
            if (cliente instanceof ClientePJ) {
                for (Frota frota : ((ClientePJ) cliente).getListaFrotas()) {
                    if (frota.getCode().equals(nome)) {
                        return frota;
                    }
                }
            }
        }
        return null;
    }

    public void imprimeSegurosPorCliente() {
        HashMap<Cliente, ArrayList<Seguro>> segurosPorCliente = getSegurosPorCliente();
        for (Cliente cliente : segurosPorCliente.keySet()) {
            System.out.println(cliente);
            System.out.println(segurosPorCliente.get(cliente));
        }
    }

    private HashMap<Cliente, ArrayList<Seguro>> getSegurosPorCliente() {
        HashMap<Cliente, ArrayList<Seguro>> segurosPorCliente = new HashMap<>();
        for (Seguro seguro : listaSeguros) {
            Cliente cliente = seguro.getCliente();
            if (!segurosPorCliente.containsKey(cliente)) {
                segurosPorCliente.put(cliente, new ArrayList<Seguro>());
            }
            segurosPorCliente.get(cliente).add(seguro);
        }
        return segurosPorCliente;
    }

    public HashMap<Cliente, ArrayList<Sinistro>> getSinistrosPorCliente() {

        HashMap<Cliente, ArrayList<Sinistro>> sinistrosPorCliente = new HashMap<>();
        for (Seguro seguro : listaSeguros) {
            Cliente cliente = seguro.getCliente();
            if (!sinistrosPorCliente.containsKey(cliente)) {
                sinistrosPorCliente.put(cliente, new ArrayList<Sinistro>());
            }
            sinistrosPorCliente.get(cliente).addAll(seguro.getListaSinistros());
        }
        return sinistrosPorCliente;
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
                "\nQuantidade de Clientes: " + listaClientes.size();
    }
}
