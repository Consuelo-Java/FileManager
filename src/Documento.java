import java.io.*;

public class Documento implements Serializable {
    String titolo;
    String autore;
    String contenuto;
    int numeroPagine;

    public Documento(String titolo, String autore, String contenuto, int numeroPagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.contenuto = contenuto;
        this.numeroPagine = numeroPagine;
    }

    public void salvaSuFile(String nomeFile){
        File file = new File(nomeFile);
        try {
            OutputStream stream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(stream);
            objectStream.writeObject(this);
            System.out.println("Documento salvato su " + nomeFile);
        } catch (IOException e) {
            System.err.println("Si e' verificato un errore nella scrittura del file: " + e.getMessage());
        }
    }

    public static Documento caricaDaFile(String nomeFile){
        File file = new File(nomeFile);
        try {
            InputStream stream = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(stream);
            return (Documento) objectStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Si e' verificato un errore nella lettura del file: " + e.getMessage());
            return null;
        }
    }
}
