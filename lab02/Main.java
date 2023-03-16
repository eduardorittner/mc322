package lab02;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("adilson", "45878931885", "11082003", 20, "Rua das Árvores");
        Veiculo veiculo = new Veiculo("Honda", "DUG4587", "Fit");
        Sinistro sinistro = new Sinistro("10102001", "Rua das Árvores");
        Seguro seguro = new Seguro("Premium", "19988889876", "a@gmail.com", "Rua das Árvores");
        System.out.println(cliente.toString());
    }
}
