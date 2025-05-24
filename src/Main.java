import java.io.File;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void inserisciDocumento() {
        System.out.println("Inserisci il titolo del documento:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci l'autore:");
        String autore = scanner.nextLine();

        Integer numeroPagine = null;
        do{
            try {
                System.out.println("Inserisci il numero di pagine:");
                numeroPagine = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Errore: Inserisci un numero valido!");
            }
        } while (numeroPagine == null);

        System.out.println("Inserisci il contenuto del documento:");
        String contenuto = scanner.nextLine();

        Documento doc = new Documento(titolo, autore, contenuto, numeroPagine);
        doc.salvaSuFile(titolo+".txt");
    }

    public static void cercaDocumento() {
        System.out.println("Inserisci il titolo del documento da cercare senza estensione:");
        String titolo = scanner.nextLine();
        String nomeFile = titolo + ".txt";

        Documento doc = Documento.caricaDaFile(nomeFile);
        if (doc != null) {
            System.out.println("Documento trovato:");
            System.out.println(doc.contenuto);
        } else {
            System.err.println("Documento non trovato.");
        }
    }
    public static void eliminaDocumento() {
        System.out.println("Inserisci il nome del file da eliminare senza estensione:");
        String nomeFile = scanner.nextLine() + ".txt";

        File file = new File(nomeFile);
        if(! file.exists()){
            System.err.println("Errore: Documento non trovato");
        }
        else if (file.delete()) {
            System.out.println("Documento eliminato con successo.");
        } else {
            System.err.println("Errore: Documento non eliminabile.");
        }
    }

    public static void stampaDocumenti() {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            System.out.println("Documenti salvati:");
            for (File file : files) {
                System.out.println(file.getName().replace(".ser", ""));
            }
        } else {
            System.out.println("Nessun documento salvato.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Primo documento");
        inserisciDocumento();
        System.out.println("Secondo documento");
        inserisciDocumento();
        System.out.println("Terzo documento");
        inserisciDocumento();
        cercaDocumento();
        eliminaDocumento();
        cercaDocumento();
        stampaDocumenti();
    }
}
