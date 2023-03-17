
public class Main {
    public static void main(String[] args) {
        // Instanciação de objetos
        Cliente cliente = new Cliente("adilson", "45878931885", "11082003", 20, "Rua das Árvores");
        Veiculo veiculo = new Veiculo("Honda", "DUG4587", "Fit");
        Sinistro sinistro = new Sinistro("10102001", "Rua das Árvores");
        Seguro seguro = new Seguro("Premium", "19988889876", "a@gmail.com", "Rua das Árvores");

        // Teste de um método de cada objeto
        System.out.println(cliente.toString());
        System.out.println(veiculo.getMarca());
        System.out.println(sinistro.getId());
        System.out.println(seguro.getEndereco());
    }
}
