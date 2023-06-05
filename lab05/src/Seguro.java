import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class Seguro {

    private static ArrayList<Integer> listaIds = new ArrayList<Integer>();
    private final int id;
    private Date dataInicio;
    private Date dataFinal;
    private Seguradora seguradora;
    ArrayList<Sinistro> listaSinistros;
    ArrayList<Condutor> listaCondutores;
    double valorMensal;

    public Seguro(Date dataInicio, Date dataFinal, Seguradora seguradora, ArrayList<Condutor> listaCondutores) {

        this.id = gerarId();
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = listaCondutores;
        this.valorMensal = 0.0;
    }

    public int getId() {
        return id;
    }

    abstract double calcularValor();

    public double getValorMensal() {
        calcularValor();
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    abstract Cliente getCliente();

    Condutor getCondutor(String cpf) throws Exception {
        for (Condutor condutor : listaCondutores) {
            if (condutor.getCpf().equals(cpf)) {
                return condutor;
            }
        }
        throw new Exception("Condutor não encontrado.");
    }

    ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void getSinistrosPorCondutor() {
        for (Condutor condutor : listaCondutores) {
            System.out.println(condutor);
            for (Sinistro sinistro : condutor.getListaSinistros()) {
                System.out.println(sinistro);
            }
        }
    }

    public void getSinistrosPorCondutor(Condutor condutor) {
        System.out.println(condutor);
        for (Sinistro sinistro : condutor.getListaSinistros()) {
            System.out.println(sinistro);
        }
    }

    public Sinistro getSinistro(int id) {
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getId() == id) {
                return sinistro;
            }
        }

        for (Condutor condutor : listaCondutores) {
            for (Sinistro sinistro : listaSinistros) {
                if (sinistro.getId() == id) {
                    return sinistro;
                }
            }
        }

        return null;
    }

    public boolean cadastrarSinistro(Sinistro sinistro, Condutor condutor) {
        if (!listaSinistros.contains(sinistro)) {
            listaSinistros.add(sinistro);
            if (!listaCondutores.contains(condutor)) {
                condutor.adicionarSinistro(sinistro);
                return true;
            }
        }
        return false;
    }

    public boolean removeSinistro(int id) {
        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getId() == id) {
                listaSinistros.remove(sinistro);
                listaIds.remove(id);
                return true;
            }
        }
        return false;
    }

    int qtdSinistrosCondutores() {
        int sinistros = 0;
        for (Condutor condutor : listaCondutores) {
            sinistros += condutor.getListaSinistros().size();
        }
        return sinistros;
    }

    private int gerarId() {
        int id;
        Random random = new Random();
        do {
            id = random.nextInt(0, 10000000);
        } while (listaIds.contains(id));
        listaIds.add(id);
        return id;
    }

    boolean autorizarCondutor(Condutor condutor) {
        if (!listaCondutores.contains(condutor)) {
            listaCondutores.add(condutor);
            return true;
        }
        return false;
    }

    boolean desautorizarCondutor(Condutor condutor) {
        if (listaCondutores.contains(condutor)) {
            return false;
        }
        listaCondutores.remove(condutor);
        return true;
    }

    public static ArrayList<Integer> getListaIds() {
        return listaIds;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public boolean gerarSinistro(Sinistro sinistro) {
        if (sinistro.getCondutor() == null) {
            listaSinistros.add(sinistro);
            return true;
        }
        if (sinistro.getCondutor().adicionarSinistro(sinistro)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nId: " + id + "\nValor mensal: " + valorMensal + "\nSeguradora: " + seguradora.getNome()
                + "\nQuantidade de condutores: " + listaCondutores.size() + "\nQuantidade de sinistros: "
                + listaSinistros.size();

    }

}
