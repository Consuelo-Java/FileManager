import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Downloader extends Thread{String nomeFile;

    public Downloader(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    @Override
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile));
            writer.write("Download completato!");
            System.out.println("File scaricato e salvato su " + nomeFile);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Errore nel download del file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Downloader d1 = new Downloader("PrimoFile.txt");
        Downloader d2 = new Downloader("SecondoFile.txt");
        Downloader d3 = new Downloader("TerzoFile.txt");
        Downloader d4 = new Downloader("QuartoFile.txt");
        Downloader d5 = new Downloader("QuintoFile.txt");

        d1.start();
        d2.start();
        d3.start();
        d4.start();
        d5.start();
    }
}
