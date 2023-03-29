
public class Main {
    public static void main(String[] args) {
        // Instanciação de objetos
        Cliente cliente = new Cliente("adilson", "458.789.318-85", "11082003", 20, "Rua das Árvores");
        Veiculo veiculo = new Veiculo("Honda", "DUG4587", "Fit");
        Sinistro sinistro = new Sinistro("10102001", "Rua das Árvores");
        Seguro seguro = new Seguro("Premium", "19988889876", "a@gmail.com", "Rua das Árvores");

        // Testes das classes
        System.out.println("--------------------------------------");
        System.out.println("Testando a classe Cliente");
        System.out.println("toString: " + cliente);
        System.out.println("getCpf: " + cliente.getCpf());
        cliente.setCpf("123.456.789-12");
        System.out.println("setCpf: Mudando o cpf para um número inválido");
        System.out.println("getCpf: " + cliente.getCpf());
        System.out.println("setNome");
        cliente.setNome("adriano");
        System.out.println("getNome: " + cliente.getNome());

        System.out.println("--------------------------------------");
        System.out.println("Testando a classe Sinistro");
        System.out.println("getId: " + sinistro.getId());
        System.out.println("setId");
        sinistro.setId();
        System.out.println("getId: " + sinistro.getId());

        System.out.println("--------------------------------------");
        System.out.println("Testando a classe Seguro");
        System.out.println("getEndereco: " + seguro.getEndereco());
        System.out.println("setEndereco: Rua dos Abacateiros");
        seguro.setEndereco("Rua dos Abacateiros");
        System.out.println("getEndereco: " + seguro.getEndereco());

        System.out.println("--------------------------------------");
        System.out.println("Testando a classe Veiculo");
        System.out.println("getModelo: " + veiculo.getModelo());
        System.out.println("setModelo: Jeep");
        veiculo.setModelo("Jeep");
        System.out.println("getModelo: " + veiculo.getModelo());
    }
}
