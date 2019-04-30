// To juz jest klasa
// ktora pobiera liste z pliku z adresami IP
// i konwetruje to na OBliste i wrzuca do odpowiedniej listy


package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListUpdateClass {

public void Update(ListView<String> listIp)throws IOException {
    IpSearchClass ipSearchClass = new IpSearchClass();
    ipSearchClass.Ipclass();
    ArrayList<String> lista = new ArrayList <>();
    ObservableList<String> obList1 = FXCollections.observableArrayList();
    String fileName = "test2.txt";
    File file = new File(fileName);
    Scanner scan = null;
    try {
        scan = new Scanner(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    int i = 0;
    while (scan.hasNextLine()) {
        lista.add(scan.nextLine());
        i++;
    }
    for (int a = 0; a < i; a++) {
        obList1.add(lista.get(a));
        listIp.setItems(obList1);
    }
    obList1.add("80.192.167.88"); //Testowy IP
    obList1.add("123.206.76.184"); //Testowy IP
    listIp.setItems(obList1);// To tez Do usuniecia
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    writer.print("");
    writer.close();
}

}
