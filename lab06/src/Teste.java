import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Teste {
    public static void main(String agrs[]) {
        try {

            Date data = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            try {
                data = dateFormat.parse("10-10-2000");
            } catch (Exception e) {
                System.out.println(e);
            }
            Frota frota = new Frota("frota bala");
            ClientePJ clientePJ = new ClientePJ("Milton LTDA.", "Rua dos abacates", "19-9999999",
                    "milton@gmail.com", data, "18.781.203/0001-28");
            clientePJ.cadastrarFrota(frota);
            ArrayList<Frota> listaFrotas = new ArrayList<Frota>();
            listaFrotas.add(frota);
            ArquivoFrota arquivo = new ArquivoFrota(listaFrotas);
            arquivo.gravarArquivo("uepa.csv");
            System.out.println("Gravando arqiyuvo");
        } catch (Exception e) {
            System.out.println("deuy bosta");
        }
    }
}
