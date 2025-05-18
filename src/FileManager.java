import java.io.*;

public class FileManager {
    public static void scriviSuFile(String nomeFile, String contenuto) {
        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile));
            writer.write(contenuto);
        } catch (IOException e) {
            System.out.println("Errore nella scrittura del file: " + e.getMessage());
        }
    }

    public static String leggiDaFile(String nomeFile) {
        StringBuilder contenuto = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeFile));
            String linea = reader.readLine();            
            while (linea != null) {
                contenuto.append(linea + "\n");
                linea = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file: " + e.getMessage());
        }
        return contenuto.toString();
    }

    public static void copiaFile(String sorgente, String destinazione){
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        try{
            input = new BufferedInputStream(new FileInputStream(sorgente));
        } catch (FileNotFoundException e){
            System.out.println("Errore nella lettura del file sorgente: " + e.getMessage());
        }
        try{
            output = new BufferedOutputStream(new FileOutputStream(destinazione));
        }catch (FileNotFoundException e){
            System.out.println("Errore nella lettura del file destinazione: " + e.getMessage());
        }
        if(input != null && output != null) {
            try {
                byte[] buffer = new byte[1024];
                int lunghezza = input.read(buffer);
                while (lunghezza != -1) {
                    output.write(buffer, 0, lunghezza);
                    lunghezza = input.read(buffer);
                }
                System.out.println("File copiato da " + sorgente + " a " + destinazione);
            } catch (IOException e) {
                System.out.println("Errore nella copia da " + sorgente + " a " + destinazione +": " + e.getMessage());
            }
        }
    }

    public static void eliminaFile(String nomeFile){
        File file = new File(nomeFile);
        if (file.delete()) {
            System.out.println("File " + nomeFile + " eliminato con successo.");
        } else {
            System.out.println("Impossibile eliminare il file " + nomeFile);
        }
    }
}
