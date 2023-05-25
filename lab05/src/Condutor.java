import java.util.Date;
import java.util.ArrayList;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;
    static ArrayList<String> listaCpfs;

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNascimento)
            throws Exception {
        if (!Validacao.validarCPF(cpf)) {
            throw new Exception("O cpf inserido não é válido");
        }
        if (listaCpfs.contains(cpf)) {
            throw new Exception("Já existe um condutor com este cpf.");
        }
        if (!Validacao.validarNome(nome)) {
            throw new Exception("Nome inserido não é válido");
        }
        if (Validacao.validarTelefone(telefone)) {
            throw new Exception("Telefone inserido não é válido. (Somente numerais)");
        }
        if (Validacao.validarData(dataNascimento)) {
            throw new Exception("A data de nascimento inserida não é válida.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
    }

    public boolean adicionarSinistro(Sinistro sinistro) {
        if (listaSinistros.contains(sinistro)) {
            return false;
        }
        listaSinistros.add(sinistro);
        return true;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public String getCpf() {
        return cpf;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
