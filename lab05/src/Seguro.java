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
    private int valorMensal;

    public Seguro(Date dataInicio, Date dataFinal, Seguradora seguradora, ArrayList<Condutor> listaCondutores,
            int valorMensal) {

        this.id = gerarId();
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = listaCondutores;
        this.valorMensal = valorMensal;
    }

    int qtdSinistrosCondutores() {
        int sinistros = 0;
        for (Condutor condutor : listaCondutores) {
            sinistros += condutor.getListaSinistros().size();
        }
        return sinistros;
    }

    abstract double calcularValor();

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

    public int getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    public boolean gerarSinistro(Condutor condutor, Date data, String endereco) {
        Sinistro sinistro = new Sinistro(data, endereco, condutor, this);
        listaSinistros.add(sinistro);
        if (condutor.adicionarSinistro(sinistro)) {
            return true;
        }
        return false;
    }

}
