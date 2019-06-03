
//Tutaj bede musial sie pobawic
//rozpisac to na mniejsze klasy
// ogolnie ta klasa to pobieranie listy i informacji o IP
// skonwetowanie tego do odpowiedniej formy
// i zapisanie tego na pliku TXT
package sample.Classes;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class IpSearchClass {
    public void Ipclass() throws IOException{
        //Zapisywanie do pliku
        String fileName = "test.txt";

        TreeSet<String> tablica = new TreeSet<>();

        int z = 0;

        String[] cmdarray = {"netstat", "-n"};
        Process process = Runtime.getRuntime().exec(cmdarray);
        Scanner sc = new Scanner(process.getInputStream());
        sc.useDelimiter("\\A");
        String zminna = sc.next();

        try (
                FileOutputStream fs = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fs)
        ) {
            os.writeObject(zminna);


        } catch (
                FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        // Wczytywanie pliku
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                if (z > 4) {
                    String textCon = nextLine.substring(5, 30).trim();
                    tablica.add(textCon.substring(0, textCon.length() - 6));
                }
                z++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException d) {

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
        writer.close();

        File f = new File("test2.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        for (String s : tablica) {
            fw.write(s + "\r\n");
        }
        fw.close();

    }
}
