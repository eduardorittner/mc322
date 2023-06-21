import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ClientePJ extends Cliente {

    private final String cnpj;
    private Date dataFundacao;
    private ArrayList<Frota> listaFrotas;

    public ClientePJ(String nome, String endereco, String telefone, String email, Date dataFundacao, String cnpj)
            throws Exception {

        super(nome, endereco, telefone, email);
        this.dataFundacao = dataFundacao;
        this.listaFrotas = new ArrayList<Frota>();
        this.cnpj = cnpj;

        if (!Validacao.validarCNPJ(cnpj)) {
            throw new Exception("O cnpj inserido não é válido.");
        }
        if (!Validacao.validarData(dataFundacao)) {
            throw new Exception("A data de fundação inserida não é válida");
        }
    }

    public Frota getFrota(String id) {
        for (Frota frota : listaFrotas) {
            if (frota.getCode().equals(id)) {
                return frota;
            }
        }
        return null;
    }

    public boolean cadastrarFrota(Frota frota) {
        if (listaFrotas.contains(frota)) {
            return false;
        }
        listaFrotas.add(frota);
        return true;
    }

    public boolean removerFrota(String id) {
        for (Frota frota : listaFrotas) {
            if (frota.getCode().equals(id)) {
                listaFrotas.remove(frota);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public void limpaListaFrotas() {
        listaFrotas.clear();
    }

    public void concatenaListaFrotas(ArrayList<Frota> listaFrotas) {
        this.listaFrotas.addAll(listaFrotas);
    }

    public boolean atualizarFrota(Frota frota, String comando, Veiculo veiculo) {
        if (comando.equals("cadastrar")) {
            if (frota.addVeiculo(veiculo)) {
                return true;
            }
        }
        if (comando.equals("remover")) {
            if (frota.removeVeiculo(veiculo)) {
                return true;
            }
        }
        if (comando.equals("limpar")) {
            listaFrotas.remove(frota);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(String placa) {
        for (Frota frota : listaFrotas) {
            Veiculo veiculo = frota.getVeiculo(placa);
            if (veiculo != null) {
                return atualizarFrota(frota, "remover", veiculo);
            }
        }
        return false;
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(String nomeFrota) {
        return getFrota(nomeFrota).getListaVeiculos();
    }

    public ArrayList<Veiculo> getVeiculosPorFrota() {
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        for (Frota frota : listaFrotas) {
            listaVeiculos.addAll(frota.getListaVeiculos());
        }
        return listaVeiculos;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getIdade() {
        Date dataAtual = new Date();
        Date data = dataFundacao;

        long diferencaEmMiliS = dataAtual.getTime() - data.getTime();
        int idade = (int) TimeUnit.DAYS.convert(diferencaEmMiliS, TimeUnit.MILLISECONDS) / 365;
        return idade;
    }

    public int qtdTotalVeiculos() {
        int qtd = 0;
        for (Frota frota : listaFrotas) {
            qtd += frota.getListaVeiculos().size();
        }
        return qtd;
    }

    @Override
    public String getCadastroPessoal() {
        return cnpj.replaceAll("[^\\d]", "");
    }

    @Override
    public String toString() {
        return "\nNome: " + getNome() + "\nCNPJ: " + cnpj + "\nNúmero de frotas: " + listaFrotas.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientePJ other = (ClientePJ) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }
}
