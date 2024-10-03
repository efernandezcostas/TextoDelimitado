import java.io.*;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        Texto texto = new Texto();
        texto.copiarTexto();
        texto.leerTexto();
    }
}

class Texto {
    private String[] cod = {"p1", "p2", "p3"};
    private String[] desc = {"parafusos", "cravos", "tachas"};
    private int[] prezo = {3,4,5};

    public void copiarTexto() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        try(
                FileWriter fw = new FileWriter("texto1.txt");
                PrintWriter pw = new PrintWriter(fw);
        ){
            for (int i=0; i<3; i++){
                pw.println("Codigo:\t"+cod[i]);
                pw.println("Descricion:\t"+desc[i]);
                pw.println("Prezo:\t"+nf.format(prezo[i])+"\n");
            }
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void leerTexto() {

        try(
                FileReader fr = new FileReader("texto1.txt");
                BufferedReader br = new BufferedReader(fr);
        ){
            while (true) {
                String resultado = br.readLine();
                if (resultado == null) break;
                System.out.println(resultado);
            }
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
