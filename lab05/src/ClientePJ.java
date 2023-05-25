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

        if (Validacao.validarCNPJ(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("O cnpj inserido não é válido.");
        }
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

    public boolean cadastrarFrota(Frota frota) {
        if (listaFrotas.contains(frota)) {
            return false;
        }
        listaFrotas.add(frota);
        return true;
    }

    public boolean removerFrota(Frota frota) {
        if (listaFrotas.contains(frota)) {
            listaFrotas.remove(frota);
            return true;
        }
        return false;
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
        return false;
    }

    public boolean getVeiculosPorFrota(Frota frota) {
        try {
            for (Veiculo veiculo : frota.getListaVeiculos()) {
                System.out.println(veiculo);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getVeiculosPorFrota() {
        try {
            for (Frota frota : listaFrotas) {
                for (Veiculo veiculo : frota.getListaVeiculos()) {
                    System.out.println(veiculo);

                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCNPJ: " + cnpj;
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
